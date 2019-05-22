package io.github.pactstart.service.dispatcher.request;

import java.io.Serializable;

public class ServiceApiRequest implements Serializable {

    private String cmd;

    private String request;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
