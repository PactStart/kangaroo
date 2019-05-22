package io.github.pactstart.admin.system.form;

import io.github.pactstart.simple.web.framework.common.form.PageForm;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchLogForm extends PageForm {

    private Integer type;

    private String operator;

    private String fromTime;

    private String toTime;
}
