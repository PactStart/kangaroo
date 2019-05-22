package io.github.pactstart.rong360.openapi;

import io.github.pactstart.rong360.openapi.exception.Rong360ApiException;
import io.github.pactstart.rong360.openapi.request.BaseRequest;
import io.github.pactstart.rong360.openapi.response.BaseResponse;

public interface Rong360Client {

    <T extends BaseResponse> T execute(BaseRequest<T> baseRequest) throws Rong360ApiException;

}
