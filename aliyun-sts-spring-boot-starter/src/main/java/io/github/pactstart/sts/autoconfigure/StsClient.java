package io.github.pactstart.sts.autoconfigure;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StsClient {

    // 目前只有"cn-hangzhou"这个region可用, 不要使用填写其他region的值
    private static final String REGION_CN_HANGZHOU = "cn-hangzhou";
    private static final String STS_API_VERSION = "2015-04-01";
    // 此处必须为 HTTPS
    private static final ProtocolType protocolType = ProtocolType.HTTPS;
    private static Logger logger = LoggerFactory.getLogger(StsClient.class);
    private ProductConfig productConfig;
    private String policy;

    public StsClient() {
    }

    public StsClient(ProductConfig productConfig, String policy) {
        this.productConfig = productConfig;
        this.policy = policy;
    }

    public StsResponse acquireToken() throws Exception {
        try {
            // 创建一个 Aliyun Acs Client, 用于发起 OpenAPI 请求
            IClientProfile profile = DefaultProfile.getProfile(REGION_CN_HANGZHOU, productConfig.getAccessKeyId(), productConfig.getAccessKeySecret());
            DefaultAcsClient client = new DefaultAcsClient(profile);

            // 创建一个 AssumeRoleRequest 并设置请求参数
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setVersion(STS_API_VERSION);
            request.setMethod(MethodType.POST);
            request.setProtocol(protocolType);
            request.setEndpoint("sts.aliyuncs.com");

            request.setRoleArn(productConfig.getRoleArn());
            request.setRoleSessionName(productConfig.getRoleSessionName());
            request.setPolicy(policy);
            request.setDurationSeconds(productConfig.getTokenExpireTime());

            // 发起请求，并得到response
            final AssumeRoleResponse response = client.getAcsResponse(request);

            StsResponse stsResponse = new StsResponse();
            stsResponse.setAccessKeyId(response.getCredentials().getAccessKeyId());
            stsResponse.setAccessKeySecret(response.getCredentials().getAccessKeySecret());
            stsResponse.setExpirationTime(response.getCredentials().getExpiration());
            stsResponse.setSecurityToken(response.getCredentials().getSecurityToken());
            stsResponse.setExpireSeconds(productConfig.getTokenExpireTime());


            return stsResponse;
        } catch (ClientException e) {
            logger.error("Failed to get a token, Error code: {},Error message: {}", e.getErrCode(), e.getErrMsg());
            throw e;
        }
    }

    public void setProductConfig(ProductConfig productConfig) {
        this.productConfig = productConfig;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }
}
