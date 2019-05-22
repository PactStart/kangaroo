package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class RoleAclChangeForm {

    @NotNull(message = "roleId不能为空")
    private Integer roleId;

    private List<Integer> aclList;
}
