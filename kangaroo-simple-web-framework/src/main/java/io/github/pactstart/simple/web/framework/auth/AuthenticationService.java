package io.github.pactstart.simple.web.framework.auth;

import javax.servlet.http.HttpServletRequest;

/**
 * 认证
 */
public interface AuthenticationService {

    AuthenticationInfo auth(HttpServletRequest request);
}
