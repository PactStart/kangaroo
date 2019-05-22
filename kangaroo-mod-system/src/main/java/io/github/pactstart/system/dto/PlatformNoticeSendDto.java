package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlatformNoticeSendDto extends BaseDto {

    private List<Integer> memberIdList;

    private Integer platformNoticeId;

}
