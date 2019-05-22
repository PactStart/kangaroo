package io.github.pactstart.simple.web.framework.auth;

/**
 * 授权
 */
public interface AuthorizationService {

    boolean canAccess(AuthenticationInfo authenticationInfo, String url);
}
