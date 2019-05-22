package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.PageQueryDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuggestionQueryDto extends PageQueryDto {

    private Integer problemType;

    private String contactInfo;

    private Integer status;
}
