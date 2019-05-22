package io.github.pactstart.system.dto;

import io.github.pactstart.biz.common.dto.BaseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberNoticeSendDto extends BaseDto {

    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 会员昵称
     */
    private String nickname;

    /**
     * 业务类型
     */
    private Integer bizType;

    /**
     * 显示类型
     */
    private Integer showType;

    /**
     * 通知类型，0会员通知，1平台通知
     */
    private Integer noticeType;

    /**
     * 通知标题
     */
    private String title;

    /**
     * 通知内容
     */
    private String content;

    /**
     * 是否只存储不发送，默认为false
     */
    private boolean onlyStore;
}
