package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.Suggestion;

import java.util.List;

public interface SuggestionMapper extends MyMapper<Suggestion> {

    List<Suggestion> query(Object object);

}