package io.github.pactstart.chuanglan.autoconfiguration.request;

public class SmsBalanceRequest {
    /**
     * 创蓝API账号，必填
     */
    private String account;
    /**
     * 创蓝API密码，必填
     */
    private String password;

    public SmsBalanceRequest() {

    }

    public SmsBalanceRequest(String account, String password) {
        super();
        this.account = account;
        this.password = password;

    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
