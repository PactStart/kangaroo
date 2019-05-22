package io.github.pactstart.admin.system.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class UploadSceneForm {

    @NotBlank(message = "未指定上传场景")
    private String scene;

    private Boolean callback;
}
