package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserPasswordModifyForm {

    @NotBlank(message = "当前密码不能为空")
    @Pattern(regexp = "[A-Za-z0-9]{6,20}", message = "当前密码由6-20位字母或数字组成")
    private String password;

    @NotBlank(message = "新密码不能为空")
    @Pattern(regexp = "[A-Za-z0-9]{6,20}", message = "新密码由6-20位字母或数字组成")
    private String newPassword;

    @NotBlank(message = "确认新密码不能为空")
    private String confirmNewPassword;

}
