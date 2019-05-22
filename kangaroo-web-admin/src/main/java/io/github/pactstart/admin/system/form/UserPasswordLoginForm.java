package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class UserPasswordLoginForm {

    @NotNull(message = "手机号或邮箱不可以为空")
    private String loginId;

    @NotNull(message = "密码不可以为空")
    private String password;
}
