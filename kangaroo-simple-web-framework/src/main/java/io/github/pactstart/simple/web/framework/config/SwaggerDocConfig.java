package io.github.pactstart.simple.web.framework.config;

import io.github.pactstart.simple.web.framework.constants.FrameworkConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = FrameworkConstants.SWAGGER_CONFIG_PREFIX)
public class SwaggerDocConfig {

    private String version = "1.0";
    private String title = "Api Documentation";
    private String description = "Api Documentation";
    private String termsOfServiceUrl = "urn:tos";
    private String license = "Apache 2.0";
    private String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";

    private String name = "";
    private String url = "";
    private String email = "";
}
