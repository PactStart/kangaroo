package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class UserPhoneSmsLoginForm {

    @NotBlank(message = "电话不可以为空")
    @Pattern(regexp = "1[3456789]\\d{9}", message = "手机号格式不合法")
    @Length(min = 11, max = 11, message = "电话长度需11个字符")
    private String phone;

    @NotBlank(message = "短信验证码不可以为空")
    private String smsCode;
}
