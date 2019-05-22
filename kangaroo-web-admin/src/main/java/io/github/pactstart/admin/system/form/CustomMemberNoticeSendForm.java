package io.github.pactstart.admin.system.form;

import com.google.common.collect.Maps;
import io.github.pactstart.biz.common.dto.BaseDto;
import io.github.pactstart.system.model.MemberIdNicknamePair;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CustomMemberNoticeSendForm extends BaseDto {

    @Size(min = 1, message = "未选择任何推送用户")
    private List<MemberIdNicknamePair> memberList;

    @NotBlank(message = "通知标题不能为空")
    private String title;

    private String content = "{}";

    @NotNull(message = "未指定显示类型")
    private Integer showType;

    @NotNull(message = "未指定业务类型")
    private Integer bizType;

    private Map<String, Object> extras = Maps.newHashMap();

}
