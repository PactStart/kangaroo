package io.github.pactstart.system.service;

import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.system.dto.*;

import java.util.List;


public interface ConfigService {
    /**
     * 查询配置
     *
     * @param queryDto
     * @return
     */
    PageResultDto<ConfigDto> query(ConfigQueryDto queryDto);

    /**
     * 获取所有配置
     *
     * @return
     */
    List<ConfigDto> getAll();

    /**
     * 添加配置
     *
     * @param configDto
     */
    void add(ConfigDto configDto);

    /**
     * 更新配置
     *
     * @param configUpdateDto
     */
    void update(ConfigUpdateDto configUpdateDto);

    /**
     * 删除配置
     *
     * @param configDeleteDto
     */
    void delete(ConfigDeleteDto configDeleteDto);

    /**
     * 查询配置修改日志
     *
     * @param queryDto
     * @return
     */
    PageResultDto<ConfigLogDto> queryLog(ConfigLogQueryDto queryDto);

    /**
     * 获取配置
     *
     * @param id
     * @return
     */
    ConfigDto getById(Integer id);
}
