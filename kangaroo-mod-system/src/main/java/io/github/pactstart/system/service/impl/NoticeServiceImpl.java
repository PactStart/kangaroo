package io.github.pactstart.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.biz.common.utils.PageUtils;
import io.github.pactstart.biz.common.utils.SpringContextHolder;
import io.github.pactstart.commonutils.JsonUtils;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.jpush.autoconfigure.JPushService;
import io.github.pactstart.jpush.autoconfigure.PushObject;
import io.github.pactstart.system.dao.MemberNoticeMapper;
import io.github.pactstart.system.dao.PlatformNoticeMapper;
import io.github.pactstart.system.dao.PlatformNoticeReadedMapper;
import io.github.pactstart.system.dto.*;
import io.github.pactstart.system.entity.MemberNotice;
import io.github.pactstart.system.entity.PlatformNotice;
import io.github.pactstart.system.entity.PlatformNoticeReaded;
import io.github.pactstart.system.enums.MemberNoticeStatusEnum;
import io.github.pactstart.system.enums.NoticeTypeEnum;
import io.github.pactstart.system.enums.PlatformNoticeStatusEnum;
import io.github.pactstart.system.model.MemberIdNicknamePair;
import io.github.pactstart.system.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private MemberNoticeMapper memberNoticeMapper;

    @Autowired
    private PlatformNoticeMapper platformNoticeMapper;

    @Autowired
    private PlatformNoticeReadedMapper platformNoticeReadedMapper;

    @Autowired
    private JPushService jPushService;

    public void sendCustomMemberNotice2(CustomMemberNoticeSendDto customMemberNoticeSendDto) {
        for (MemberIdNicknamePair pair : customMemberNoticeSendDto.getMemberList()) {
            MemberNotice memberNotice = new MemberNotice();
            memberNotice.setMemberId(pair.getMemberId());
            memberNotice.setNickname(pair.getMemberNickname());
            memberNotice.setTitle(customMemberNoticeSendDto.getTitle());
            memberNotice.setContent(customMemberNoticeSendDto.getContent());
            memberNotice.setBizType(customMemberNoticeSendDto.getBizType());
            memberNotice.setShowType(customMemberNoticeSendDto.getShowType());
            memberNotice.setReaded(false);
            memberNotice.setDel(false);
            memberNotice.setStatus(MemberNoticeStatusEnum.SENDING.getValue());
            memberNotice.setCreateTime(new Date());
            memberNoticeMapper.insert(memberNotice);


            //发送
            Map<String, Object> extras = customMemberNoticeSendDto.getExtras();
            extras.put("noticeType", NoticeTypeEnum.MEMBER_NOTICE.getValue());
            boolean result = sendJpush(getAlias(pair.getMemberId()), customMemberNoticeSendDto.getTitle(), customMemberNoticeSendDto.getContent(), extras);

            memberNoticeMapper.updateStatus(memberNotice.getId(), result ? MemberNoticeStatusEnum.SEND_SUCCESS.getValue() : MemberNoticeStatusEnum.SEND_FAIL.getValue());
        }

    }

    public void sendCustomMemberNotice(CustomMemberNoticeSendDto customMemberNoticeSendDto) {
        if (!ValidUtils.isValid(customMemberNoticeSendDto.getMemberList())) {
            return;
        }
        List<MemberNotice> memberNoticeList = Lists.newArrayList();
        List<String> alias = new ArrayList<>();
        for (MemberIdNicknamePair pair : customMemberNoticeSendDto.getMemberList()) {
            MemberNotice memberNotice = new MemberNotice();
            memberNotice.setMemberId(pair.getMemberId());
            memberNotice.setNickname(pair.getMemberNickname());
            memberNotice.setTitle(customMemberNoticeSendDto.getTitle());
            memberNotice.setContent(customMemberNoticeSendDto.getContent());
            memberNotice.setBizType(customMemberNoticeSendDto.getBizType());
            memberNotice.setShowType(customMemberNoticeSendDto.getShowType());
            memberNotice.setReaded(false);
            memberNotice.setDel(false);
            memberNotice.setStatus(MemberNoticeStatusEnum.SENDING.getValue());
            memberNotice.setCreateTime(new Date());
            memberNoticeList.add(memberNotice);

            alias.add(getAlias(pair.getMemberId()));
        }
        memberNoticeMapper.insertList(memberNoticeList);
        //发送
        Map<String, Object> extras = customMemberNoticeSendDto.getExtras();
        extras.put("noticeType", NoticeTypeEnum.MEMBER_NOTICE.getValue());
        boolean result = sendJpush(alias, customMemberNoticeSendDto.getTitle(), customMemberNoticeSendDto.getContent(), extras);

        List<Long> noticeIdList = Lists.newArrayList();
        memberNoticeList.forEach(item -> noticeIdList.add(item.getId()));

        memberNoticeMapper.batchUpdateStatus(noticeIdList, result ? MemberNoticeStatusEnum.SEND_SUCCESS.getValue() : MemberNoticeStatusEnum.SEND_FAIL.getValue());
    }

    @Override
    public void sendMemberNotice(MemberNoticeSendDto memberNoticeSendDto) {
        MemberNotice memberNotice = MapperUtils.map(memberNoticeSendDto, MemberNotice.class);
        memberNotice.setReaded(false);
        memberNotice.setDel(false);
        if (memberNoticeSendDto.isOnlyStore()) {
            memberNotice.setStatus(MemberNoticeStatusEnum.SENDING.getValue());
        } else {
            memberNotice.setStatus(MemberNoticeStatusEnum.ONLY_STORE.getValue());
        }
        memberNotice.setCreateTime(new Date());
        memberNoticeMapper.insert(memberNotice);

        if (!memberNoticeSendDto.isOnlyStore()) {
            Map<String, Object> extras = Maps.newHashMap();
            extras.put("bizType", memberNotice.getBizType());
            extras.put("showType", memberNotice.getShowType());
            extras.put("noticeType", memberNoticeSendDto.getNoticeType());
            boolean result = sendJpush(getAlias(memberNoticeSendDto.getMemberId()), memberNoticeSendDto.getTitle(), JsonUtils.obj2String(memberNoticeSendDto.getContent()), extras);
            memberNoticeMapper.updateStatus(memberNotice.getId(), result ? MemberNoticeStatusEnum.SEND_SUCCESS.getValue() : MemberNoticeStatusEnum.SEND_FAIL.getValue());
        }
    }

    @Override
    public MemberNoticeDto readMemberNotice(MemberNoticeReadDto readDto) {
        MemberNotice memberNotice = memberNoticeMapper.selectByPrimaryKey(readDto.getId());
        if (memberNotice == null || memberNotice.getDel() || !memberNotice.getMemberId().equals(readDto.getMemberId())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "消息不存在或非法操作");
        }

        memberNoticeMapper.updateReadedById(memberNotice.getId());
        memberNotice.setReaded(true);
        return MapperUtils.map(memberNotice, MemberNoticeDto.class);
    }

    @Override
    public void readMemberNoticeAll(Integer memberId) {
        memberNoticeMapper.updateReadedByMemberId(memberId);
    }

    @Override
    public PageResultDto<MemberNoticeDto> queryMemberNotice(MemberNoticeQueryDto queryDto) {
        Page<MemberNotice> result = PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize()).doSelectPage(() -> memberNoticeMapper.query(queryDto));
        return PageUtils.convert(result, MemberNoticeDto.class);
    }

    @Override
    public void addPlatformNotice(PlatformNoticeAddDto addDto) {
        PlatformNotice platformNotice = MapperUtils.map(addDto, PlatformNotice.class);
        platformNotice.setStatus(PlatformNoticeStatusEnum.DRAFT.getValue());
        platformNotice.setReadCount(0);
        platformNotice.setOperateTime(new Date());
        platformNotice.setCreateTime(new Date());
        platformNoticeMapper.insert(platformNotice);
    }

    @Override
    public void sendPlatformNotice(PlatformNoticeSendDto platformNoticeSendDto) {
        PlatformNotice platformNotice = platformNoticeMapper.selectByPrimaryKey(platformNoticeSendDto.getPlatformNoticeId());
        if (platformNotice == null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "平台通知不存在");
        }

        if (platformNotice.getStatus().equals(PlatformNoticeStatusEnum.PUBLISH.getValue())) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "平台通知已发布，不能重复发布");
        }

        List<String> alias = new ArrayList<>();
        for (Integer id : platformNoticeSendDto.getMemberIdList()) {
            alias.add(getAlias(id));
        }
        //发送
        Map<String, Object> extras = Maps.newHashMap();
        extras.put("noticeType", NoticeTypeEnum.PLATFORM.getValue());
        sendJpush(alias, platformNotice.getTitle(), platformNotice.getContent(), extras);
        platformNoticeMapper.updateStatus(platformNotice.getId(), PlatformNoticeStatusEnum.PUBLISH.getValue());
    }

    @Transactional
    @Override
    public PlatformNoticeDto readPlatformNotice(PlatformNoticeReadDto readDto) {
        PlatformNotice platformNotice = platformNoticeMapper.selectByPrimaryKey(readDto.getPlatformNoticeId());
        if (platformNotice == null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "平台通知不存在");
        }

        Example example = new Example(PlatformNoticeReaded.class);
        example.createCriteria().andEqualTo("platformNoticeId", readDto.getPlatformNoticeId()).andEqualTo("memberId", readDto.getMemberId());
        if (platformNoticeReadedMapper.selectCountByExample(example) == 0) {
            PlatformNoticeReaded noticeReaded = MapperUtils.map(readDto, PlatformNoticeReaded.class);
            noticeReaded.setCreateTime(new Date());
            platformNoticeReadedMapper.insert(noticeReaded);
            platformNoticeMapper.incrementReadCount(platformNotice.getId());
        }

        return MapperUtils.map(platformNotice, PlatformNoticeDto.class);
    }

    @Override
    public PageResultDto<PlatformNoticeDto> queryPlatformNotice(PlatformNoticeQueryDto queryDto) {
        Page<PlatformNotice> result = PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize()).doSelectPage(() -> platformNoticeMapper.query(queryDto));
        return PageUtils.convert(result, PlatformNoticeDto.class);
    }

    @Override
    public PageResultDto<PlatformNoticeDto> queryMyPlatformNotice(MyPlatformNoticeQueryDto queryDto) {
        Page<PlatformNotice> result = PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize()).doSelectPage(() -> platformNoticeMapper.queryMyPlatformNotice(queryDto.getMemberId(), PlatformNoticeStatusEnum.PUBLISH.getValue(), queryDto.getReaded()));
        return PageUtils.convert(result, PlatformNoticeDto.class);
    }

    @Override
    public void updateMemberNickname(Integer memberId, String newNickname) {
        memberNoticeMapper.updateMemberNickname(memberId, newNickname);
    }

    @Override
    public int countUnReadByMemberId(Integer memberId) {
        int unreadMemberNoticeCount = memberNoticeMapper.countUnreadByMemberId(memberId);
        int readedPlatformNoticeCount = platformNoticeReadedMapper.countByMemberId(memberId);
        int totalPlatformNoticeCount = platformNoticeMapper.countByStatus(PlatformNoticeStatusEnum.PUBLISH.getValue());
        int unreadPlatformNoticeCount = totalPlatformNoticeCount > readedPlatformNoticeCount ? totalPlatformNoticeCount - readedPlatformNoticeCount : 0;
        return unreadMemberNoticeCount + unreadPlatformNoticeCount;
    }

    @Transactional
    @Override
    public void readPlatformNoticeAll(Integer memberId) {
        List<PlatformNotice> platformNoticeList = platformNoticeMapper.queryMyPlatformNotice(memberId, PlatformNoticeStatusEnum.PUBLISH.getValue(), false);
        for (PlatformNotice platformNotice : platformNoticeList) {
            PlatformNoticeReaded noticeReaded = new PlatformNoticeReaded();
            noticeReaded.setMemberId(memberId);
            noticeReaded.setPlatformNoticeId(platformNotice.getId());
            noticeReaded.setCreateTime(new Date());
            platformNoticeReadedMapper.insert(noticeReaded);
        }
    }

    @Override
    public void deletePlatformNotice(PlatformNoticeIdDto platformNoticeIdDto) {
        PlatformNotice platformNotice = platformNoticeMapper.selectByPrimaryKey(platformNoticeIdDto.getPlatformNoticeId());
        if (platformNotice == null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "您要删除平台通知不存在");
        }
        PlatformNoticeStatusEnum platformNoticeStatusEnum = PlatformNoticeStatusEnum.valueOf(platformNotice.getStatus());
        if (platformNoticeStatusEnum == PlatformNoticeStatusEnum.DELETE) {

        }
        if (platformNoticeStatusEnum == PlatformNoticeStatusEnum.PUBLISH) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "已发布的平台通知不能删除");
        } else {
            platformNoticeMapper.updateStatus(platformNotice.getId(), PlatformNoticeStatusEnum.DELETE.getValue());
        }
    }

    @Override
    public PlatformNoticeDto get(PlatformNoticeIdDto platformNoticeIdDto) {
        PlatformNotice platformNotice = platformNoticeMapper.selectByPrimaryKey(platformNoticeIdDto.getPlatformNoticeId());
        return MapperUtils.map(platformNotice, PlatformNoticeDto.class);
    }

    private String getAlias(Integer id) {
        //项目名称_环境_id
        return jPushService.getName() + "_" + SpringContextHolder.getCurrentEnv().name() + "_" + id;
    }

    private boolean sendJpush(String alias, String alert, String msgCotent, Map<String, Object> extras) {
        List<String> listAlias = new ArrayList<>(2);
        listAlias.add(alias);
        return sendJpush(listAlias, alert, msgCotent, extras);
    }

    private boolean sendJpush(List<String> alias, String alert, String msgCotent, Map<String, Object> extras) {
        PushObject pushObject = new PushObject();
        pushObject.setAlias(alias);
        pushObject.setAlert(alert);
        pushObject.setMsgContent(msgCotent);
        pushObject.setExtras(extras);
        return jPushService.sendPush(pushObject);
    }
}
