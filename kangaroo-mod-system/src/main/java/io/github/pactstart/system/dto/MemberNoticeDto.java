package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MemberNoticeDto extends BaseDto {

    private Long id;

    private Integer memberId;

    private String nickname;

    private Integer status;

    private Integer bizType;

    private Integer showType;

    private String title;

    private String content;

    private Boolean readed;

    private Date createTime;

    private Boolean del;

}