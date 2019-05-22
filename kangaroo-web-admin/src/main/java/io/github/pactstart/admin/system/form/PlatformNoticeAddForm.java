package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class PlatformNoticeAddForm {
    @NotBlank(message = "标题不能为空")
    @Length(min = 1, max = 50, message = "标题不能超过50个字符")
    private String title;

    @NotBlank(message = "内容不能为空")
    @Length(min = 1, max = 1024, message = "内容不能超过1024个字符")
    private String content;
}
