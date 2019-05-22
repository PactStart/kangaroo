package io.github.pactstart.simple.web.framework;

import com.google.common.collect.Lists;
import io.github.pactstart.simple.web.framework.constants.FrameworkConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = FrameworkConstants.MVC_CONFIG_PREFIX)
public class MVCConfig {

    private List<String> urlPatternsForFilter = Lists.newArrayList("/*");

    private List<String> urlPatternsForInteceptor = Lists.newArrayList("/**");

    /**
     * 域名
     */
    private String domain = "";

    /**
     * 授权认证地址
     */
    private String authUrl = "";

    /**
     * 是否开启ajax filter
     */
    private boolean enableAjax;

    /**
     * 需要ajax请求的接口
     */
    private List<String> ajaxUrlPatternList = Lists.newArrayList("/*");
    ;

    /**
     * 支持的匿名访问接口，多个用逗号分隔，支持Ant Path Pattern
     */
    private String anonUrls = "";

    /**
     * 是否开启ack filter
     */
    private boolean enableAcl;

    /**
     * 访问控制过滤器需要排除的url，多个用逗号分隔，支持Ant Path Pattern
     */
    private String aclExclusionUrls = "";

    private boolean corsEnabled;

    /**
     * 跨域配置
     */
    private CorsProperties cors;

    /**
     * 是否包装servletRequest,主要用于复用流
     */
    private boolean servletRequestWrapperEnabled;

    /**
     * 是否开启请求来源过滤器
     */
    private boolean requestSourceEnabled;

}
