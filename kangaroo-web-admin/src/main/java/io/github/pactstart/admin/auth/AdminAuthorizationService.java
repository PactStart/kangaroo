package io.github.pactstart.admin.auth;

import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.auth.AuthorizationService;
import io.github.pactstart.system.service.SysCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminAuthorizationService implements AuthorizationService {

    @Autowired
    private SysCoreService sysCoreService;

    @Override
    public boolean canAccess(AuthenticationInfo authenticationInfo, String url) {
        return sysCoreService.hasUrlAcl(authenticationInfo.getUserId(), url);
    }
}
