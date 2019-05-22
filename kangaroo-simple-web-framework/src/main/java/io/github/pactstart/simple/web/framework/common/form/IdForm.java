package io.github.pactstart.simple.web.framework.common.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class IdForm {

    @NotNull(message = "id不能为空")
    private Integer id;
}
