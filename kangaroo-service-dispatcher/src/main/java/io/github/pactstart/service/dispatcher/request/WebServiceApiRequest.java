package io.github.pactstart.service.dispatcher.request;

public class WebServiceApiRequest extends ServiceApiRequest {

    private String contentType;

    private String requestMethod;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }
}
