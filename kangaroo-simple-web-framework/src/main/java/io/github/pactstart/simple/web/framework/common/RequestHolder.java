package io.github.pactstart.simple.web.framework.common;


import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;

import javax.servlet.http.HttpServletRequest;

public class RequestHolder {

    private static final ThreadLocal<AuthenticationInfo> authenticationInfoHolder = new ThreadLocal<AuthenticationInfo>();

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void add(AuthenticationInfo authenticationInfo) {
        authenticationInfoHolder.set(authenticationInfo);
    }

    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static AuthenticationInfo getAuthenticationInfo() {
        return authenticationInfoHolder.get();
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        authenticationInfoHolder.remove();
        requestHolder.remove();
    }
}
