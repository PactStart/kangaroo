package io.github.pactstart.simple.web.framework.encrypt.springboot.autoconfigure;

import com.google.common.collect.Lists;
import io.github.pactstart.simple.web.framework.constants.FrameworkConstants;
import io.github.pactstart.simple.web.framework.enums.RequestSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = FrameworkConstants.ENCRYPT_CONFIG_PREFIX)
public class EncryptConfig {

    private boolean debug;

    private String key;

    /**
     * 响应数据编码
     */
    private String responseCharset = "UTF-8";

    private List<String> encryptUriList = Lists.newArrayList();

    private List<String> urlPatternList = Lists.newArrayList("/*");

    private boolean checkSign;

    private int expireTime = 60000;

    private List<String> requestSourceList = Lists.newArrayList(RequestSource.Android.name(), RequestSource.iOS.name());
}
