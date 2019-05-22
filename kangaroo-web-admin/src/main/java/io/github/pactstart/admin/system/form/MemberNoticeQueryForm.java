package io.github.pactstart.admin.system.form;

import io.github.pactstart.simple.web.framework.common.form.PageForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberNoticeQueryForm extends PageForm {

    private Integer memberId;

    private Integer status;

    private Integer bizType;

    private Integer showType;

    private Boolean readed;
}
