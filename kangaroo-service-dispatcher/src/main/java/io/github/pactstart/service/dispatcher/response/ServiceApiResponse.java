package io.github.pactstart.service.dispatcher.response;

import java.io.Serializable;

public class ServiceApiResponse implements Serializable {

    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
