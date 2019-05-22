package io.github.pactstart.system.service;

import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.system.dto.*;

public interface NoticeService {

    /**
     * 发送自定义会员消息
     *
     * @param customMemberNoticeSendDto
     */
    void sendCustomMemberNotice(CustomMemberNoticeSendDto customMemberNoticeSendDto);

    /**
     * 发送会员消息
     *
     * @param memberNoticeSendDto
     */
    void sendMemberNotice(MemberNoticeSendDto memberNoticeSendDto);

    /**
     * 会员消息已读
     *
     * @param readDto
     */
    MemberNoticeDto readMemberNotice(MemberNoticeReadDto readDto);

    /**
     * 会员消息全部已读
     *
     * @param memberId
     */
    void readMemberNoticeAll(Integer memberId);

    /**
     * 查询会员消息
     *
     * @param queryDto
     * @return
     */
    PageResultDto<MemberNoticeDto> queryMemberNotice(MemberNoticeQueryDto queryDto);

    /**
     * 添加平台通知
     *
     * @param addDto
     */
    void addPlatformNotice(PlatformNoticeAddDto addDto);

    /**
     * 发送平台通知
     *
     * @param platformNoticeSendDto
     */
    void sendPlatformNotice(PlatformNoticeSendDto platformNoticeSendDto);

    /**
     * 已读平台通知
     *
     * @param readDto
     */
    PlatformNoticeDto readPlatformNotice(PlatformNoticeReadDto readDto);

    /**
     * 查询平台通知
     *
     * @param queryDto
     * @return
     */
    PageResultDto<PlatformNoticeDto> queryPlatformNotice(PlatformNoticeQueryDto queryDto);

    /**
     * 查询我的平台通知（含已读、未读）
     *
     * @param queryDto
     * @return
     */
    PageResultDto<PlatformNoticeDto> queryMyPlatformNotice(MyPlatformNoticeQueryDto queryDto);

    /**
     * 更新会员昵称
     *
     * @param memberId
     * @param newNickname
     */
    void updateMemberNickname(Integer memberId, String newNickname);

    /**
     * 获取未读消息数量
     *
     * @param memberId
     * @return
     */
    int countUnReadByMemberId(Integer memberId);

    /**
     * 平台通知全部已读
     *
     * @param memberId
     */
    void readPlatformNoticeAll(Integer memberId);

    /**
     * 删除平台通知
     *
     * @param platformNoticeIdDto
     */
    void deletePlatformNotice(PlatformNoticeIdDto platformNoticeIdDto);

    /**
     * 根据id获取平台通知
     *
     * @param platformNoticeIdDto
     * @return
     */
    PlatformNoticeDto get(PlatformNoticeIdDto platformNoticeIdDto);
}
