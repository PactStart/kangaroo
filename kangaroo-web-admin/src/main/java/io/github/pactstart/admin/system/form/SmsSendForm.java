package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
public class SmsSendForm {

    @Pattern(regexp = "1[3456789]\\d{9}", message = "手机号格式不正确")
    @NotBlank(message = "电话不可以为空")
    private String phone;

    @NotNull(message = "场景不能为空")
    private Integer scene;
}