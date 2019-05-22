package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserAddForm {

    @NotBlank(message = "用户名不可以为空")
    @Length(min = 3, max = 20, message = "用户名长度为3-20个字符")

    private String username;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "[A-Za-z0-9]{6,20}", message = "密码由6-20位字母或数字组成")
    private String password;

    @NotBlank(message = "电话不可以为空")
    @Pattern(regexp = "1[3456789]\\d{9}", message = "手机号格式不合法")
    @Length(min = 11, max = 11, message = "电话长度需11个字符")
    private String telephone;

    @NotBlank(message = "邮箱不允许为空")
    @Length(min = 5, max = 50, message = "邮箱长度需要在50个字符以内")
    @Email(message = "邮箱格式不正确")
    private String mail;

    @NotNull(message = "必须提供用户所在的部门")
    private Integer deptId;

    @NotNull(message = "必须指定用户的状态")
    private Integer status;

    @Length(min = 0, max = 200, message = "备注长度需要在200个字以内")
    private String remark = "";

}
