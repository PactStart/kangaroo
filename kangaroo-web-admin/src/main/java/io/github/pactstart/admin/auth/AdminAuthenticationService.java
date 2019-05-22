package io.github.pactstart.admin.auth;

import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.auth.AuthenticationService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AdminAuthenticationService implements AuthenticationService {

    @Override
    public AuthenticationInfo auth(HttpServletRequest request) {
        return (AuthenticationInfo) request.getSession().getAttribute(AdminConstants.SYS_USER_SESSION_KEY);
    }
}
