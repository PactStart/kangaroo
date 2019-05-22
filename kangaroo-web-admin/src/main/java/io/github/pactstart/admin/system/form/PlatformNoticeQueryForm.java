package io.github.pactstart.admin.system.form;

import io.github.pactstart.simple.web.framework.common.form.PageForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatformNoticeQueryForm extends PageForm {
    private Integer status;
}
