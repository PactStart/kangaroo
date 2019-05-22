package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.PageQueryDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserQueryDto extends PageQueryDto {

    private Integer deptId;

    private Integer status;

    private String telephone;

    private String username;

}
