package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserIdForm {

    @NotNull(message = "userId不能为空")
    private Integer userId;
}
