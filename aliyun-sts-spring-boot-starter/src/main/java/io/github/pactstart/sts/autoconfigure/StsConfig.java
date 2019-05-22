package io.github.pactstart.sts.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("aliyun.sts")
public class StsConfig {

    private ProductConfig oss;

    public ProductConfig getOss() {
        return oss;
    }

    public void setOss(ProductConfig oss) {
        this.oss = oss;
    }
}
