package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class RoleIdForm {

    @NotNull(message = "roleId不能为空")
    private Integer roleId;
}
