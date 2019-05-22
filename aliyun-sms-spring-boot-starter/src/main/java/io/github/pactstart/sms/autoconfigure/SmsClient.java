package io.github.pactstart.sms.autoconfigure;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created on 17/6/7.
 * 短信API产品的DEMO程序,工程中包含了一个SmsDemo类，直接通过
 * 执行main函数即可体验短信产品API功能(只需要将AK替换成开通了云通信-短信产品功能的AK即可)
 * 工程依赖了2个jar包(存放在工程的libs目录下)
 * 1:aliyun-java-sdk-core.jar
 * 2:aliyun-java-sdk-dysmsapi.jar
 *
 * 备注:Demo工程编码采用UTF-8
 * 国际短信发送请勿参照此DEMO
 */
public class SmsClient {

    private SmsConfig smsConfig;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    IAcsClient client = null;

    public SmsClient(SmsConfig smsConfig) {
        this.smsConfig = smsConfig;
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", smsConfig.getAccessKeyId(), smsConfig.getAccessKeySecret());
        this.client = new DefaultAcsClient(profile);
    }

    public SmsResponse sendSms(String signName, String templateCode, String phone, Map<String, String> params) throws Exception {
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(SmsParamUtils.convert2Json(params));

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = client.getAcsResponse(request);

        SmsResponse resp = new SmsResponse();
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            resp.setSuccess(true);
        } else {
            resp.setSuccess(false);
            if ("isv.BUSINESS_LIMIT_CONTROL".equals(sendSmsResponse.getCode())) {
                resp.setError("频繁获取验证码，请稍后再试!");
            } else {
                resp.setError(sendSmsResponse.getMessage());
            }
        }
        return resp;
    }


    public QuerySendDetailsResponse querySendDetails(String phone, String bizId, Date sendDate, long pageNum, long pageSize) throws Exception {
        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber(phone);
        //可选-流水号
        request.setBizId(bizId);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(sendDate));
        //必填-页大小
        request.setPageSize(pageSize);
        //必填-当前页码从1开始计数
        request.setCurrentPage(pageNum);

        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = client.getAcsResponse(request);

        return querySendDetailsResponse;
    }

}
