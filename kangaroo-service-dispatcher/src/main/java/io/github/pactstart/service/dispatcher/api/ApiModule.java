package io.github.pactstart.service.dispatcher.api;

import java.util.List;

public class ApiModule {

    private String module;

    private List<ApiInterface> interfaceList;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public List<ApiInterface> getInterfaceList() {
        return interfaceList;
    }

    public void setInterfaceList(List<ApiInterface> interfaceList) {
        this.interfaceList = interfaceList;
    }
}
