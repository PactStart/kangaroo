package io.github.pactstart.service.dispatcher.api;

import com.google.common.collect.Lists;

import java.util.List;

public class ApiInterface {

    private String group;

    private String module;

    private String cmd;

    private String methods;

    private String notes;

    private List<ApiParam> paramList = Lists.newArrayList();

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<ApiParam> getParamList() {
        return paramList;
    }

    public void setParamList(List<ApiParam> paramList) {
        this.paramList = paramList;
    }
}
