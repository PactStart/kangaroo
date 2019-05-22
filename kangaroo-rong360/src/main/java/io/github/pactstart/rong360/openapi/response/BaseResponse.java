package io.github.pactstart.rong360.openapi.response;

import org.apache.http.HttpResponse;

public interface BaseResponse {

    void process(HttpResponse response) throws Exception;

}