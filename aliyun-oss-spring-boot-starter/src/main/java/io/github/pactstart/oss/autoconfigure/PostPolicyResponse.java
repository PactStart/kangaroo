package io.github.pactstart.oss.autoconfigure;

public class PostPolicyResponse {

    /**
     * 指的用户请求的accessid。注意仅知道accessid, 对数据不会有影响。
     */
    private String accessid;

    /**
     * 指的是用户要往哪个域名发往上传请求。
     */
    private String host;

    /**
     * 指的是用户表单上传的策略policy，是经过base64编码过的字符串
     */
    private String policy;

    /**
     * 是对上述第三个变量policy签名后的字符串
     */
    private String signature;

    /**
     * 上传目录
     */
    private String dir;

    /**
     * 指的是当前上传策略失效时间，这个变量并不会发送到OSS，因为这个已经指定在policy里面
     */
    private long expire;

    /**
     * 经过base64编码后生成的
     */
    private String callback;


    public String getAccessid() {
        return accessid;
    }

    public void setAccessid(String accessid) {
        this.accessid = accessid;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
