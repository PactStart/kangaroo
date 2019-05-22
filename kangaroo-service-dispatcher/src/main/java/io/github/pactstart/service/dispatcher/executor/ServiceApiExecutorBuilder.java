package io.github.pactstart.service.dispatcher.executor;

import io.github.pactstart.service.dispatcher.annotation.ServiceApi;
import io.github.pactstart.service.dispatcher.annotation.ServiceApiOperation;

import java.lang.reflect.Method;

public class ServiceApiExecutorBuilder {

    public static ServiceApiExecutor build(final Object targetObject, final Method targetMethod, final Class<?>[] pTypes, MethodParamParser paramParser,
                                           ServiceApi serviceApi, ServiceApiOperation serviceApiOperation, String cmd) {
        return new DefaultServiceApiExecutor(targetObject, targetMethod, pTypes, paramParser, serviceApi, serviceApiOperation, cmd);
    }
}
