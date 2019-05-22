package io.github.pactstart.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.biz.common.utils.PageUtils;
import io.github.pactstart.commonutils.DataUtils;
import io.github.pactstart.commonutils.JsonUtils;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.system.dao.SmsRecordMapper;
import io.github.pactstart.system.dto.SmsRecordDto;
import io.github.pactstart.system.dto.SmsRecordQueryDto;
import io.github.pactstart.system.entity.SmsRecord;
import io.github.pactstart.system.entity.SmsTemplate;
import io.github.pactstart.system.facade.dto.SmsSendParamDto;
import io.github.pactstart.system.facade.dto.SmsSendResultDto;
import io.github.pactstart.system.service.SmsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SmsRecordServiceImpl implements SmsRecordService {

    @Autowired
    private SmsRecordMapper smsRecordMapper;

    @Override
    public void save(SmsSendParamDto smsSendParamDto, SmsSendResultDto smsSendResultDto, SmsTemplate smsTemplate) {
        //写短信发送记录到数据库
        SmsRecord smsRecord = new SmsRecord();
        smsRecord.setTemplateId(smsSendParamDto.getTemplateId());
        smsRecord.setPhone(smsSendParamDto.getPhone());
        smsRecord.setContent(DataUtils.formatSS(smsTemplate.getTemplate(), smsSendParamDto.getParams()));
        smsRecord.setParams(JsonUtils.obj2String(smsSendParamDto.getParams()));
        smsRecord.setSuccess(smsSendResultDto.isSuccess());
        smsRecord.setRemark(smsSendResultDto.getFailReason());
        smsRecord.setOperator(ValidUtils.isValid(smsSendParamDto.getOperator()) ? smsSendParamDto.getOperator() : "system");
        smsRecord.setOperatorTime(new Date());
        smsRecord.setOperatorIp(ValidUtils.isValid(smsSendParamDto.getOperateIp()) ? smsSendParamDto.getOperateIp() : "");
        smsRecordMapper.insertSelective(smsRecord);
    }

    @Override
    public PageResultDto<SmsRecordDto> query(SmsRecordQueryDto queryDto) {
        Page<SmsRecord> page = PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize()).doSelectPage(() -> {
            smsRecordMapper.query(queryDto);
        });
        return PageUtils.convert(page, SmsRecordDto.class);
    }

}
