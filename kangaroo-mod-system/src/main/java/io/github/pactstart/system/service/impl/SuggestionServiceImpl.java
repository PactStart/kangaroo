package io.github.pactstart.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.PageUtils;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.system.dao.SuggestionMapper;
import io.github.pactstart.system.dto.SuggestionDto;
import io.github.pactstart.system.dto.SuggestionQueryDto;
import io.github.pactstart.system.entity.Suggestion;
import io.github.pactstart.system.enums.SuggestionStatusEnum;
import io.github.pactstart.system.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Autowired
    private SuggestionMapper suggestionMapper;

    @Override
    public void add(SuggestionDto suggestionDto) {
        Suggestion suggestion = Suggestion.builder().source(suggestionDto.getSource()).memberId(suggestionDto.getMemberId()).contactInfo(suggestionDto.getContactInfo())
                .problemType(suggestionDto.getProblemType()).content(suggestionDto.getContent()).attachs(suggestionDto.getAttachs()).build();
        if (!ValidUtils.isValid(suggestion.getAttachs())) {
            suggestion.setAttachs("");
        }
        suggestion.setCreateTime(new Date());
        suggestion.setStatus(SuggestionStatusEnum.PENDING_HANDLE.getValue());
        suggestion.setReply("");
        suggestion.setOperator("");
        suggestion.setOperateTime(new Date());
        suggestionMapper.insertSelective(suggestion);
    }

    @Override
    public PageResultDto<SuggestionDto> query(SuggestionQueryDto suggestionQueryDto) {
        Page<Suggestion> page = PageHelper.startPage(suggestionQueryDto.getPageNum(), suggestionQueryDto.getPageSize()).doSelectPage(() -> suggestionMapper.query(suggestionQueryDto));
        return PageUtils.convert(page, SuggestionDto.class);
    }

    @Override
    public void handle(SuggestionDto suggestionDto) {
        Suggestion suggestion = suggestionMapper.selectByPrimaryKey(suggestionDto.getId());
        if (suggestion == null) {
            throw new ApplicationException(ResponseCode.RESOURCE_NOT_EXISTS, "您要处理的建议不存在");
        }
        if (SuggestionStatusEnum.valueOf(suggestion.getStatus()) != SuggestionStatusEnum.PENDING_HANDLE) {
            throw new ApplicationException(ResponseCode.NON_SUPPORTED_OPER, "您要处理的建议非待处理状态");
        }
        Suggestion after = Suggestion.builder().id(suggestion.getId()).status(SuggestionStatusEnum.HANDLED.getValue())
                .reply(suggestionDto.getReply()).operator(suggestionDto.getOperator()).operateTime(new Date()).build();
        suggestionMapper.updateByPrimaryKeySelective(after);
    }
}
