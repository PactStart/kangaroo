package io.github.pactstart.simple.web.framework;


import io.github.pactstart.simple.web.framework.constants.FrameworkConstants;
import io.github.pactstart.simple.web.framework.filter.*;
import io.github.pactstart.simple.web.framework.interceptor.HttpInterceptor;
import io.github.pactstart.simple.web.framework.resolver.AuthenticationInfoArgumentResolver;
import io.github.pactstart.simple.web.framework.resolver.RequestSourceArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@EnableConfigurationProperties(MVCConfig.class)
@Configuration
public class MVCConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private MVCConfig mvcConfig;

    @Autowired(required = false)
    private Validator validator;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        AuthenticationInfoArgumentResolver authenticationInfoArgumentResolver = new AuthenticationInfoArgumentResolver();
        argumentResolvers.add(authenticationInfoArgumentResolver);
        RequestSourceArgumentResolver requestSourceArgumentResolver = new RequestSourceArgumentResolver();
        argumentResolvers.add(requestSourceArgumentResolver);
    }

    @ConditionalOnProperty(prefix = FrameworkConstants.MVC_CONFIG_PREFIX, name = "corsEnabled")
    @Bean
    public FilterRegistrationBean corsFilter() {
        CorsProperties cors = mvcConfig.getCors();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(cors.getAllowOrigins());
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowedMethods(cors.getAllowMethods());
        corsConfiguration.setAllowCredentials(cors.isAllowCredentials());
        corsConfiguration.setMaxAge(cors.getMaxAge());
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(cors.getPathPattern(), corsConfiguration);
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CorsFilter(source));
        registrationBean.setOrder(0);
        return registrationBean;
    }

    @ConditionalOnProperty(prefix = FrameworkConstants.MVC_CONFIG_PREFIX, name = "enableAjax", havingValue = "true")
    @Bean
    public FilterRegistrationBean ajaxFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("ajaxFilter");
        AjaxFilter ajaxFilter = new AjaxFilter();
        registrationBean.setFilter(ajaxFilter);
        registrationBean.setOrder(1);
        registrationBean.setUrlPatterns(mvcConfig.getAjaxUrlPatternList());
        return registrationBean;
    }

    @ConditionalOnProperty(prefix = FrameworkConstants.MVC_CONFIG_PREFIX, name = "enableRequestSource", havingValue = "true")
    @Bean
    public FilterRegistrationBean requestSourceFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("requestSourceFilter");
        RequestSourceFilter requestSourceFilter = new RequestSourceFilter();
        registrationBean.setFilter(requestSourceFilter);
        registrationBean.setOrder(2);
        registrationBean.setUrlPatterns(mvcConfig.getUrlPatternsForFilter());
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean loginFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.addInitParameter("authUrl", mvcConfig.getAuthUrl());
        registrationBean.addInitParameter("anonUrls", mvcConfig.getAnonUrls());
        registrationBean.setName("loginFilter");
        LoginFilter loginFilter = new LoginFilter();
        registrationBean.setFilter(loginFilter);
        registrationBean.setOrder(3);
        registrationBean.setUrlPatterns(mvcConfig.getUrlPatternsForFilter());
        return registrationBean;
    }

    @ConditionalOnProperty(prefix = FrameworkConstants.MVC_CONFIG_PREFIX, name = "enableAcl", havingValue = "true")
    @Bean
    public FilterRegistrationBean aclFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.addInitParameter("exclusionUrls", mvcConfig.getAclExclusionUrls());
        registrationBean.setName("aclFilter");
        AclControlFilter aclControlFilter = new AclControlFilter();
        registrationBean.setFilter(aclControlFilter);
        registrationBean.setOrder(4);
        registrationBean.setUrlPatterns(mvcConfig.getUrlPatternsForFilter());
        return registrationBean;
    }

    @ConditionalOnProperty(prefix = FrameworkConstants.MVC_CONFIG_PREFIX, name = "servletRequestWrapperEnabled", havingValue = "true")
    @Bean
    public FilterRegistrationBean RequestWrapperFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("requestWrapperFilter");
        RequestWrapperFilter requestWrapperFilter = new RequestWrapperFilter();
        registrationBean.setFilter(requestWrapperFilter);
        registrationBean.setOrder(100);
        registrationBean.setUrlPatterns(mvcConfig.getUrlPatternsForFilter());
        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new HttpInterceptor(mvcConfig.isServletRequestWrapperEnabled()));
        for (String urlPattern : mvcConfig.getUrlPatternsForInteceptor()) {
            interceptorRegistration.addPathPatterns(urlPattern);
        }
        super.addInterceptors(registry);
    }

    @Override
    public Validator getValidator() {
        return validator;
    }
}
