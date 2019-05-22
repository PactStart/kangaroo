package io.github.pactstart.service.dispatcher.api;

import java.util.List;

public class ApiTree {

    private String group;

    private List<ApiModule> moduleList;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<ApiModule> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<ApiModule> moduleList) {
        this.moduleList = moduleList;
    }
}
