package io.github.pactstart.service.dispatcher.dispatcher;


import io.github.pactstart.service.dispatcher.api.ApiInterface;
import io.github.pactstart.service.dispatcher.api.ApiModule;
import io.github.pactstart.service.dispatcher.request.ServiceApiRequest;
import io.github.pactstart.service.dispatcher.response.ServiceApiResponse;

import java.util.List;
import java.util.Map;

public interface ServiceDispatcher {

    ServiceApiResponse dispatch(ServiceApiRequest request) throws Exception;

    Map<String, ApiModule> getApiModuleMap();

    List<ApiInterface> getApis();
}
