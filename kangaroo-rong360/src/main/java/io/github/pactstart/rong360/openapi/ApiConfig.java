package io.github.pactstart.rong360.openapi;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiConfig {

    /**
     * 接口URl
     */
    private String serverUrl;

    /**
     * 分配给应用的唯一标识
     */
    private String appId;

    /**
     * API协议版本，默认值：1.0
     */
    private String version = "1.0";

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 私钥
     */
    private String privateKey;

    /**
     * 响应格式，仅支持json
     */
    private String format = "json";

    /**
     * 签名类型
     */
    private String signType = "RSA";

    /**
     * 连接超时时间，单位：ms
     */
    private int connectTimeoutMs = 3000;

    /**
     * 读超时时间，单位：ms
     */
    private int readTimeoutMs = 15000;

    /**
     * 回调URL
     */
    private String returnURL;

    /**
     * biz_data加密方式（0不加密，1加密:采用DES加密算法）
     */
    private String bizEnc;

    /**
     * RSA加密后的密钥（biz_enc为1时为必传）
     */
    private String desKey;
}
