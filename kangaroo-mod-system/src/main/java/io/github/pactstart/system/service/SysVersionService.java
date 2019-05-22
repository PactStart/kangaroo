package io.github.pactstart.system.service;

import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.system.dto.SysVersionDto;
import io.github.pactstart.system.dto.SysVersionQueryDto;

public interface SysVersionService {

    /**
     * 添加版本
     *
     * @param sysVersionDto
     */
    void add(SysVersionDto sysVersionDto);

    /**
     * 更新版本
     *
     * @param sysVersionDto
     */
    void update(SysVersionDto sysVersionDto);

    /**
     * 查询版本
     *
     * @param sysVersionQueryDto
     * @return
     */
    PageResultDto<SysVersionDto> query(SysVersionQueryDto sysVersionQueryDto);

    /**
     * 获取最新的版本
     *
     * @param sysVersionQueryDto
     * @return
     */
    SysVersionDto getNewestVersion(SysVersionQueryDto sysVersionQueryDto);

}
