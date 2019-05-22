package io.github.pactstart.rong360.openapi;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.pactstart.rong360.openapi.exception.Rong360ApiException;
import io.github.pactstart.rong360.openapi.request.BaseRequest;
import io.github.pactstart.rong360.openapi.response.BaseResponse;
import io.github.pactstart.rong360.openapi.utils.Base64Utils;
import io.github.pactstart.rong360.openapi.utils.RSAUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.lang.reflect.ParameterizedType;
import java.util.*;

@Slf4j
public class DefaultRong360Client implements Rong360Client {

    private ApiConfig apiConfig;

    public DefaultRong360Client(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    public <T extends BaseResponse> T execute(BaseRequest<T> baseRequest) throws Rong360ApiException {
        //1.设置请求参数
        Map<String, String> params = Maps.newHashMap();
        params.put("app_id", apiConfig.getAppId());
        params.put("version", apiConfig.getVersion());
        params.put("sign_type", apiConfig.getSignType());
        params.put("format", apiConfig.getFormat());
        params.put("timestamp", String.valueOf(new Date().getTime() / 1000));
        params.put("method", baseRequest.getMethod());
        params.put("biz_data", JSON.toJSONString(baseRequest.getBizDataMap()));

        //2.排序
        String paramsStr = sort(params);
        log.debug("请求参数排序并使用&连接：{}", paramsStr);

        CloseableHttpResponse httpResponse = null;
        try {
            //3.RSA加密
            byte[] bytes = RSAUtils.generateSHA1withRSASignature(paramsStr, apiConfig.getPrivateKey());
            String sign = Base64Utils.encode(bytes);
            params.put("sign", sign);
            log.debug("签名：{}", sign);

            //4.构造请求
            HttpPost httpPost = new HttpPost(apiConfig.getServerUrl());
            List<NameValuePair> nameValuePairList = Lists.newArrayList();
            params.forEach((key, value) -> {
                nameValuePairList.add(new BasicNameValuePair(key, value));
            });
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
            httpPost.setEntity(urlEncodedFormEntity);

            //设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(baseRequest.getReadTimeOutMs())
                    .setConnectTimeout(baseRequest.getConnectTimeOutMs())
                    .build();
            httpPost.setConfig(requestConfig);

            //5.执行请求
            CloseableHttpClient httpClient = HttpClients.createDefault();
            httpResponse = httpClient.execute(httpPost);
            log.debug("响应状态>>>{}", httpResponse.getStatusLine());
            int status = httpResponse.getStatusLine().getStatusCode();
            //4.判断http响应状态码
            if (status == HttpStatus.SC_OK) {
                //5.获取响应类型并实例化
                ParameterizedType type = (ParameterizedType) baseRequest.getClass().getGenericSuperclass();
                Class<T> responseClass = (Class<T>) type.getActualTypeArguments()[0];
                T response = responseClass.newInstance();
                //6.填充响应对象
                response.process(httpResponse);
                return response;
            } else {
                log.error("请求参数:{}", params);
                throw new Rong360ApiException("服务端响应状态码为" + status);
            }
        } catch (Exception e) {
            log.error("请求参数:{}", params);
            throw new Rong360ApiException("api调用失败", e);
        } finally {
            if (httpResponse != null) {
                EntityUtils.consumeQuietly(httpResponse.getEntity());
            }
        }
    }

    /**
     * key字典序排序，键值对之间使用&相连
     *
     * @param params 参数
     * @return 排序拼接后的字符串
     */
    private String sort(Map<String, String> params) {
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 升序排序
                        return obj1.compareTo(obj2);
                    }
                });
        for (String key : params.keySet()) {
            map.put(key, params.get(key));
        }
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        String str = "";
        while (iter.hasNext()) {
            String key = iter.next();
            String value = map.get(key);
            str += key + "=" + value + "&";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
