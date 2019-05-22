package io.github.pactstart.system.service;

import io.github.pactstart.biz.common.dto.IdDto;
import io.github.pactstart.system.dto.SysDeptDto;

public interface SysDeptService {

    /**
     * 创建部门
     *
     * @param sysDeptDto
     */
    void add(SysDeptDto sysDeptDto);

    /**
     * 修改部门kyunooo
     *
     * @param sysDeptDto
     */
    void update(SysDeptDto sysDeptDto);

    /**
     * 删除部门
     *
     * @param idDto
     */
    void delete(IdDto idDto);
}
