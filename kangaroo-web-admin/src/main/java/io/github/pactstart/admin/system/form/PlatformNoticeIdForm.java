package io.github.pactstart.admin.system.form;

import javax.validation.constraints.NotNull;

public class PlatformNoticeIdForm {

    @NotNull(message = "平台通知id不能为空")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
