package io.github.pactstart.service.dispatcher.executor;

import io.github.pactstart.service.dispatcher.annotation.ServiceApi;
import io.github.pactstart.service.dispatcher.annotation.ServiceApiOperation;
import io.github.pactstart.service.dispatcher.request.ServiceApiRequest;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class DefaultServiceApiExecutor implements ServiceApiExecutor {

    private Object targetObject;
    private Method targetMethod;
    private Class<?>[] paramTypes;
    private MethodParamParser paramParser;
    private ServiceApi serviceApi;
    private ServiceApiOperation serviceApiOperation;
    private String cmd;


    public DefaultServiceApiExecutor(Object targetObject, Method targetMethod, Class<?>[] paramTypes, MethodParamParser paramParser, ServiceApi serviceApi, ServiceApiOperation serviceApiOperation, String cmd) {
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.paramTypes = paramTypes;
        this.paramParser = paramParser;
        this.serviceApi = serviceApi;
        this.serviceApiOperation = serviceApiOperation;
        this.cmd = cmd;
    }

    @Override
    public Object invoke(ServiceApiRequest request) throws Exception {
        if (paramTypes != null && paramTypes.length != 0) {
            Object[] pTypeValues = new Object[paramTypes.length];

            for (int i = 0; i < paramTypes.length; ++i) {
                Parameter parameter = targetMethod.getParameters()[i];
                pTypeValues[i] = paramParser.parse(paramTypes[i], parameter, request);

            }
            return targetMethod.invoke(targetObject, pTypeValues);

        } else {
            return targetMethod.invoke(targetObject);
        }
    }


    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public ServiceApi getServiceApi() {
        return serviceApi;
    }

    public ServiceApiOperation getServiceApiOperation() {
        return serviceApiOperation;
    }

    public String getCmd() {
        return cmd;
    }
}
