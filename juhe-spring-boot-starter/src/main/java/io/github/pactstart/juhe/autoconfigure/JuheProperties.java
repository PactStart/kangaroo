package io.github.pactstart.juhe.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "juhe")
public class JuheProperties {

    private String idcardKey;

    private String bankcardKey;

    private String bankcard4Key;

    private String bankcardSilkKey;

    public String getIdcardKey() {
        return idcardKey;
    }

    public void setIdcardKey(String idcardKey) {
        this.idcardKey = idcardKey;
    }

    public String getBankcardKey() {
        return bankcardKey;
    }

    public void setBankcardKey(String bankcardKey) {
        this.bankcardKey = bankcardKey;
    }

    public String getBankcard4Key() {
        return bankcard4Key;
    }

    public void setBankcard4Key(String bankcard4Key) {
        this.bankcard4Key = bankcard4Key;
    }

    public String getBankcardSilkKey() {
        return bankcardSilkKey;
    }

    public void setBankcardSilkKey(String bankcardSilkKey) {
        this.bankcardSilkKey = bankcardSilkKey;
    }
}
