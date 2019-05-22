package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SuggestionHandleForm {

    @NotNull(message = "反馈id不能为空")
    private Integer id;

    @NotBlank(message = "回复/备注不能为空")
    private String reply;
}
