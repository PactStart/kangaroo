package io.github.pactstart.system.service;

import io.github.pactstart.system.dto.SmsTemplateDto;
import io.github.pactstart.system.entity.SmsTemplate;

import java.util.List;

public interface SmsTemplateService {

    void add(SmsTemplateDto smsTemplateDto);

    List<SmsTemplateDto> getAll();

    SmsTemplate findByTemplateId(String templateId);

    void deleteByTemplateId(String templateId);
}
