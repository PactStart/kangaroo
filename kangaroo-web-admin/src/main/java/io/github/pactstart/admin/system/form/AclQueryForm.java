package io.github.pactstart.admin.system.form;

import io.github.pactstart.simple.web.framework.common.form.PageForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AclQueryForm extends PageForm {

    private Integer aclModuleId;

    private String name;

    private String path;

}
