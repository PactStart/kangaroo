package io.github.pactstart.rong360.autoconfigure;

import io.github.pactstart.rong360.openapi.ApiConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rong360")
public class Rong360Config extends ApiConfig {
}
