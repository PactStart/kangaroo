package io.github.pactstart.system.dto;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysUserDto extends BaseDto {

    private Integer id;

    private String username;

    private String telephone;

    private String mail;

    @JSONField(serialize = false)
    private String password;

    private Integer deptId;

    private Integer status;

    private String remark;

    private String operator;

    private String operateIp;

    private Date operateTime;

}