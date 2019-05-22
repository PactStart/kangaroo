package io.github.pactstart.service.dispatcher.executor;

import io.github.pactstart.service.dispatcher.request.ServiceApiRequest;

import java.lang.reflect.Parameter;

public interface MethodParamParser {

    Object parse(Class<?> pType, Parameter parameter, ServiceApiRequest request);
}
