package io.github.pactstart.admin.system.form;

import io.github.pactstart.simple.web.framework.common.form.PageForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuggestionQueryForm extends PageForm {

    private String contactInfo;

    private Integer problemType;

    private Integer status;
}
