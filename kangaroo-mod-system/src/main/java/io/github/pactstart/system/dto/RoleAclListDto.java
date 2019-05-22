package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.OperateDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleAclListDto extends OperateDto {

    private Integer roleId;

    private List<Integer> aclList;

}
