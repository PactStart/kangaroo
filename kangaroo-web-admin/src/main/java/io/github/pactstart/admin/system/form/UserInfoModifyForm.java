package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserInfoModifyForm {

    @Length(min = 6, max = 20, message = "用户名长度为6-20个字符")
    private String username;

}
