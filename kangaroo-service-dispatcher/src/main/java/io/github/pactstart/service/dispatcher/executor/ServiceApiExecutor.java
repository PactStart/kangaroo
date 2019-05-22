package io.github.pactstart.service.dispatcher.executor;

import io.github.pactstart.service.dispatcher.annotation.ServiceApi;
import io.github.pactstart.service.dispatcher.annotation.ServiceApiOperation;
import io.github.pactstart.service.dispatcher.request.ServiceApiRequest;

public interface ServiceApiExecutor {

    Object invoke(ServiceApiRequest request) throws Exception;

    Class<?>[] getParamTypes();

    ServiceApi getServiceApi();

    ServiceApiOperation getServiceApiOperation();

    String getCmd();

}
