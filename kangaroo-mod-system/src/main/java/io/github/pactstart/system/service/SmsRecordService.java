package io.github.pactstart.system.service;

import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.system.dto.SmsRecordDto;
import io.github.pactstart.system.dto.SmsRecordQueryDto;
import io.github.pactstart.system.entity.SmsTemplate;
import io.github.pactstart.system.facade.dto.SmsSendParamDto;
import io.github.pactstart.system.facade.dto.SmsSendResultDto;

public interface SmsRecordService {
    /**
     * 保存短信发送记录
     *
     * @param smsSendParamDto
     * @param smsSendResultDto
     * @param smsTemplate
     */
    void save(SmsSendParamDto smsSendParamDto, SmsSendResultDto smsSendResultDto, SmsTemplate smsTemplate);

    /**
     * 查询短信发送记录
     */
    PageResultDto<SmsRecordDto> query(SmsRecordQueryDto queryDto);
}
