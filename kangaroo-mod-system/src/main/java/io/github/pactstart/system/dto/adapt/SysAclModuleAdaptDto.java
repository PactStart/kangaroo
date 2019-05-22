package io.github.pactstart.system.dto.adapt;

import com.google.common.collect.Lists;
import io.github.pactstart.system.dto.SysAclModuleDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SysAclModuleAdaptDto extends SysAclModuleDto {

    // 子模块
    private List<SysAclModuleAdaptDto> aclModuleList = Lists.newArrayList();

    //当前模块权限点
    private List<SysAclAdaptDto> aclList = Lists.newArrayList();

}
