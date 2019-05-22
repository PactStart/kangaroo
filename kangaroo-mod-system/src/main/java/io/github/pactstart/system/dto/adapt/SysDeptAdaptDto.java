package io.github.pactstart.system.dto.adapt;

import com.google.common.collect.Lists;
import io.github.pactstart.biz.common.utils.LevelUtil;
import io.github.pactstart.system.dto.SysDeptDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SysDeptAdaptDto extends SysDeptDto {

    private List<SysDeptAdaptDto> deptList = Lists.newArrayList();

    public static SysDeptAdaptDto newDefault() {
        SysDeptAdaptDto dto = new SysDeptAdaptDto();
        dto.setId(0);
        dto.setParentId(0);
        dto.setLevel(LevelUtil.ROOT);
        dto.setName("默认部门");
        dto.setSeq(-1);
        return dto;
    }

}
