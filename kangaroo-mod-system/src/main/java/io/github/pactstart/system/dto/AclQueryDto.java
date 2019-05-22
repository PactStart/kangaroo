package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.PageQueryDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AclQueryDto extends PageQueryDto {

    private Integer aclModuleId;

    private String name;

    private String url;

}
