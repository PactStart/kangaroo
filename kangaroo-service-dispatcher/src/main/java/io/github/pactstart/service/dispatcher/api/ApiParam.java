package io.github.pactstart.service.dispatcher.api;

import com.google.common.collect.Lists;

import java.util.List;

public class ApiParam {

    private String paramName;

    private String paramType;

    private List<ApiParam> paramList = Lists.newArrayList();

    private List<String> constraintList = Lists.newArrayList();

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public List<ApiParam> getParamList() {
        return paramList;
    }

    public void setParamList(List<ApiParam> paramList) {
        this.paramList = paramList;
    }

    public List<String> getConstraintList() {
        return constraintList;
    }

    public void setConstraintList(List<String> constraintList) {
        this.constraintList = constraintList;
    }
}
