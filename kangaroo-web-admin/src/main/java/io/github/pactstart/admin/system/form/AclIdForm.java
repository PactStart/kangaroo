package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AclIdForm {

    @NotNull(message = "aclId不能为空")
    private Integer aclId;
}
