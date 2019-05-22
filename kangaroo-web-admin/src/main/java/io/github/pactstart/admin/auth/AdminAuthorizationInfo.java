package io.github.pactstart.admin.auth;

import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.auth.SimpleUserInfo;

public class AdminAuthorizationInfo implements AuthenticationInfo {

    private SimpleUserInfo userInfo;

    public SimpleUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(SimpleUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String getUserName() {
        return userInfo.getUsername();
    }

    @Override
    public Integer getUserId() {
        return userInfo.getId();
    }
}
