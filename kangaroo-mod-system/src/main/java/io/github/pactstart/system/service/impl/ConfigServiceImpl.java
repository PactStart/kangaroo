package io.github.pactstart.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.biz.common.utils.PageUtils;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.system.dao.ConfigLogMapper;
import io.github.pactstart.system.dao.ConfigMapper;
import io.github.pactstart.system.dto.*;
import io.github.pactstart.system.entity.Config;
import io.github.pactstart.system.entity.ConfigLog;
import io.github.pactstart.system.enums.ConfigValueTypeEnum;
import io.github.pactstart.system.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private ConfigLogMapper configLogMapper;

    @Override
    public PageResultDto<ConfigDto> query(ConfigQueryDto queryDto) {
        Page<Config> result = PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize()).doSelectPage(() -> configMapper.query(queryDto));
        return PageUtils.convert(result, ConfigDto.class);
    }

    @Override
    public List<ConfigDto> getAll() {
        return MapperUtils.mapList(configMapper.selectAll(), ConfigDto.class);
    }

    @Transactional
    @Override
    public void add(ConfigDto configDto) {
        Example example = new Example(Config.class);
        example.createCriteria().andEqualTo("namespace", configDto.getNamespace()).andEqualTo("name", configDto.getName());
        if (configMapper.selectCountByExample(example) > 0) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "配置已存在");
        }
        validateConfig(configDto.getConfigType(), configDto.getValue(), configDto.getDefaultValue(), configDto.getJsonSchema());
        Config config = MapperUtils.map(configDto, Config.class);
        if (!ValidUtils.isValid(config.getJsonSchema())) {
            config.setJsonSchema("");
        }
        config.setOperateTime(new Date());
        configMapper.insert(config);

        ConfigLog configLog = ConfigLog.builder().namespace(configDto.getNamespace()).name(configDto.getName())
                .oldType(0).newType(configDto.getConfigType())
                .oldValue("").newValue(configDto.getValue())
                .operator(configDto.getOperator()).operateTime(new Date()).operateIp(configDto.getOperateIp()).build();
        configLogMapper.insert(configLog);
    }

    private void validateConfig(Integer configValueType, String value, String defaultValue, String jsonSchema) {
        ConfigValueTypeEnum configValueTypeEnum = ConfigValueTypeEnum.valueOf(configValueType);
        if (configValueTypeEnum == ConfigValueTypeEnum.BOOL_TYPE) {
            if (!"true" .equalsIgnoreCase(value) && !"false" .equalsIgnoreCase(value)) {
                throw new ApplicationException(ResponseCode.INVALID_PARAM, "配置值有误，布尔类型取值范围：true 或者 false");
            }
            if (!"true" .equalsIgnoreCase(defaultValue) && !"false" .equalsIgnoreCase(defaultValue)) {
                throw new ApplicationException(ResponseCode.INVALID_PARAM, "默认配置值有误，布尔类型取值范围：true 或者 false");
            }
        } else if (configValueTypeEnum == ConfigValueTypeEnum.NUMBER_TYPE) {
            try {
                Integer.valueOf(value);
            } catch (NumberFormatException e) {
                throw new ApplicationException(ResponseCode.INVALID_PARAM, "配置值有误,不能转化为数值类型");
            }
            try {
                Integer.valueOf(defaultValue);
            } catch (NumberFormatException e) {
                throw new ApplicationException(ResponseCode.INVALID_PARAM, "默认配置值有误,不能转化为数值类型");
            }
        } else if (configValueTypeEnum == ConfigValueTypeEnum.JSON_TYPE) {
//            if (!ValidUtils.isValid(jsonSchema)) {
//                throw new ApplicationException(ResponseCode.INVALID_PARAM, "配置类型为json格式时，需填写Json shcema");
//            }
//            SchemaLoader loader = SchemaLoader.builder().schemaJson(new JSONObject(jsonSchema)).draftV7Support().build();
//            Schema schema = loader.load().build();
//            try {
//                value = value.trim();
//                if (value.startsWith("[")) {
//                    schema.validate(new JSONArray(value));
//                } else {
//                    schema.validate(new JSONObject(value));
//                }
//            } catch (JSONException e) {
//                log.error("配置值不是一个有效的Json格式的字符串", e);
//                throw new ApplicationException(ResponseCode.INVALID_JSON_STRING, "配置值不是一个有效的Json格式的字符串");
//            } catch (ValidationException e) {
//                log.error("配置值有误,不符合定义的schema", e);
//                ResponseCode responseCode = new ResponseCode(ResponseCode.INVALID_PARAM, "配置值有误,不符合定义的schema");
//                throw new ApplicationException(responseCode);
//            }
//            try {
//                schema.validate(new JSONObject(defaultValue));
//            } catch (JSONException e) {
//                log.error("默认配置值不是一个有效的Json格式的字符串", e);
//                throw new ApplicationException(ResponseCode.INVALID_JSON_STRING, "默认配置值不是一个有效的Json格式的字符串");
//            } catch (ValidationException e) {
//                log.error("默认配置值有误,不符合定义的schema", e);
//                ResponseCode responseCode = new ResponseCode(ResponseCode.INVALID_PARAM, "默认配置值有误,不符合定义的schema");
//                responseCode.setData(e.getCausingExceptions());
//                throw new ApplicationException(responseCode);
//            }
        }
    }

    @Transactional
    @Override
    public void update(ConfigUpdateDto configUpdateDto) {
        Config before = configMapper.selectByPrimaryKey(configUpdateDto.getId());
        if (before == null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "配置不存在");
        }
        validateConfig(configUpdateDto.getConfigType(), configUpdateDto.getValue(), configUpdateDto.getDefaultValue(), configUpdateDto.getJsonSchema());

        Config after = Config.builder().id(before.getId()).configType(configUpdateDto.getConfigType()).description(configUpdateDto.getDescription())
                .value(configUpdateDto.getValue()).defaultValue(configUpdateDto.getDefaultValue()).jsonSchema(configUpdateDto.getJsonSchema()).operateIp(configUpdateDto.getOperateIp()).operateTime(new Date()).build();
        configMapper.updateByPrimaryKeySelective(after);

        ConfigLog configLog = ConfigLog.builder().namespace(before.getNamespace()).name(before.getName())
                .oldType(before.getConfigType()).newType(configUpdateDto.getConfigType())
                .oldValue(before.getValue()).newValue(after.getValue())
                .operator(configUpdateDto.getOperator()).operateIp(configUpdateDto.getOperateIp()).operateTime(new Date()).build();
        configLogMapper.insert(configLog);
    }

    @Transactional
    @Override
    public void delete(ConfigDeleteDto configDeleteDto) {
        Config config = new Config();
        config.setNamespace(configDeleteDto.getNamespace());
        config.setName(configDeleteDto.getName());
        config = configMapper.selectOne(config);
        if (config != null) {
            configLogMapper.deleteByPrimaryKey(config.getId());
            ConfigLog configLog = ConfigLog.builder().namespace(config.getNamespace()).name(config.getName())
                    .oldType(config.getConfigType()).newType(config.getConfigType())
                    .oldValue(config.getValue()).newValue("删除该配置")
                    .operator(configDeleteDto.getOperator()).operateIp(configDeleteDto.getOperateIp()).operateTime(new Date()).build();
            configLogMapper.insert(configLog);
        }
    }

    @Override
    public PageResultDto<ConfigLogDto> queryLog(ConfigLogQueryDto queryDto) {
        Page<ConfigLog> result = PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize()).doSelectPage(() -> configLogMapper.query(queryDto));
        return PageUtils.convert(result, ConfigLogDto.class);
    }

    @Override
    public ConfigDto getById(Integer id) {
        return MapperUtils.map(configMapper.selectByPrimaryKey(id), ConfigDto.class);
    }
}
