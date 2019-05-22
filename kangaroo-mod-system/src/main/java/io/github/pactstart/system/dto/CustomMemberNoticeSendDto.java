package io.github.pactstart.system.dto;

import com.google.common.collect.Maps;
import io.github.pactstart.biz.common.dto.BaseDto;
import io.github.pactstart.system.model.MemberIdNicknamePair;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CustomMemberNoticeSendDto extends BaseDto {

    private List<MemberIdNicknamePair> memberList;

    private String title;

    private String content;

    private Integer showType;

    private Integer bizType;

    private Map<String, Object> extras = Maps.newHashMap();

}
