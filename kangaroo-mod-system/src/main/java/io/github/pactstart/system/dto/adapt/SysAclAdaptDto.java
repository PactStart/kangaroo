package io.github.pactstart.system.dto.adapt;

import io.github.pactstart.system.dto.SysAclDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SysAclAdaptDto extends SysAclDto {

    // 是否要默认选中
    private boolean checked = false;

    // 是否有权限操作
    private boolean hasAcl = false;
}
