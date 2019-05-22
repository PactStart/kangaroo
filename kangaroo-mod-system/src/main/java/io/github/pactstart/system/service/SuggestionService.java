package io.github.pactstart.system.service;

import io.github.pactstart.biz.common.dto.PageResultDto;
import io.github.pactstart.system.dto.SuggestionDto;
import io.github.pactstart.system.dto.SuggestionQueryDto;

public interface SuggestionService {

    void add(SuggestionDto suggestionDto);

    PageResultDto<SuggestionDto> query(SuggestionQueryDto suggestionQueryDto);

    void handle(SuggestionDto suggestionDto);
}
