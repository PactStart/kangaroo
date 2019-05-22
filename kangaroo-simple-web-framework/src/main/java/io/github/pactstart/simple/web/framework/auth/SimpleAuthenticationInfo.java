package io.github.pactstart.simple.web.framework.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleAuthenticationInfo implements AuthenticationInfo {

    private Integer userId;

    private String userName;

}
