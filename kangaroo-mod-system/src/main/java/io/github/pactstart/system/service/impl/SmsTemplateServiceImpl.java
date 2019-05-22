package io.github.pactstart.system.service.impl;

import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.MapperUtils;
import io.github.pactstart.system.dao.SmsTemplateMapper;
import io.github.pactstart.system.dto.SmsTemplateDto;
import io.github.pactstart.system.entity.SmsTemplate;
import io.github.pactstart.system.service.SmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SmsTemplateServiceImpl implements SmsTemplateService {

    @Autowired
    private SmsTemplateMapper smsTemplateMapper;

    @Override
    public void add(SmsTemplateDto smsTemplateDto) {
        SmsTemplate smsTemplate = findByTemplateId(smsTemplateDto.getTemplateId());
        if (smsTemplate != null) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, "模板Id已存在");
        }
        smsTemplate = MapperUtils.map(smsTemplateDto, SmsTemplate.class);
        smsTemplate.setOperateTime(new Date());
        smsTemplateMapper.insertSelective(smsTemplate);
    }

    @Override
    public List<SmsTemplateDto> getAll() {
        return MapperUtils.mapList(smsTemplateMapper.selectAll(), SmsTemplateDto.class);
    }

    @Override
    public SmsTemplate findByTemplateId(String templateId) {
        return smsTemplateMapper.selectByPrimaryKey(templateId);
    }

    @Override
    public void deleteByTemplateId(String templateId) {
        smsTemplateMapper.deleteByPrimaryKey(templateId);
    }
}
