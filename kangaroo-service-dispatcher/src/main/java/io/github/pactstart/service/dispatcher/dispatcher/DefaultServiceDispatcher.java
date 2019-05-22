package io.github.pactstart.service.dispatcher.dispatcher;

import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.service.dispatcher.annotation.ServiceApiOperation;
import io.github.pactstart.service.dispatcher.enums.ContentType;
import io.github.pactstart.service.dispatcher.enums.RequestMethod;
import io.github.pactstart.service.dispatcher.exception.ServiceApiException;
import io.github.pactstart.service.dispatcher.executor.DefaultMethodParamParser;
import io.github.pactstart.service.dispatcher.executor.MethodParamParser;
import io.github.pactstart.service.dispatcher.executor.ServiceApiExecutor;
import io.github.pactstart.service.dispatcher.request.ServiceApiRequest;
import io.github.pactstart.service.dispatcher.request.WebServiceApiRequest;
import io.github.pactstart.service.dispatcher.response.ServiceApiResponse;

public class DefaultServiceDispatcher extends AbstractServiceDispatcher {

    @Override
    protected String getGroup() {
        return "";
    }

    @Override
    protected MethodParamParser initMethodParamParser() {
        return new DefaultMethodParamParser();
    }

    @Override
    protected boolean preHandle(ServiceApiRequest request, ServiceApiResponse response, ServiceApiExecutor executor) {
        boolean allow = true;
        if (executor == null) {
            response.setResult(ResponseCode.RESOURCE_NOT_EXISTS);
            allow = false;
        }
        if (allow && isWebEnvironment() && request instanceof WebServiceApiRequest) {
            allow = checkRequestForWebEnvironment(request, response, executor);
        }
        return allow;
    }

    @Override
    protected void postHandle(ServiceApiRequest request, ServiceApiResponse response, ServiceApiExecutor executor, Object result) throws Exception {

    }

    @Override
    protected void afterCompletion(ServiceApiRequest request, ServiceApiResponse response, ServiceApiExecutor executor, Exception ex) throws Exception {
        if (ex != null) {
            if (ex instanceof ServiceApiException) {
                ServiceApiException exception = (ServiceApiException) ex;
                response.setResult(exception.getResponseCode());
            } else {
                throw ex;
            }
        }
    }


    protected boolean checkRequestForWebEnvironment(ServiceApiRequest request, ServiceApiResponse response, ServiceApiExecutor executor) {
        boolean allow = true;
        WebServiceApiRequest webServiceApiRequest = (WebServiceApiRequest) request;
        ServiceApiOperation serviceApiOperation = executor.getServiceApiOperation();

        RequestMethod requestMethod = RequestMethod.valueOf(webServiceApiRequest.getRequestMethod());
        if (!isRequestMethodSupport(requestMethod, serviceApiOperation)) {
            response.setResult(ResponseCode.REQUEST_METHOD_NOT_SUPPORTED);
            allow = false;
        }

        if (requestMethod != RequestMethod.GET) {
            String contentType = webServiceApiRequest.getContentType();
            if (contentType == null || !isContentTypeSupport(contentType, serviceApiOperation)) {
                response.setResult(ResponseCode.MEDIA_TYPE_NOT_SUPPORTED);
                allow = false;
            }
        }
        return allow;
    }

    protected boolean isRequestMethodSupport(RequestMethod requestMethod, ServiceApiOperation serviceApiOperation) {
        boolean isSupport = false;
        if (ValidUtils.isValid(serviceApiOperation.method())) {
            for (RequestMethod supportMethod : serviceApiOperation.method()) {
                if (supportMethod == requestMethod) {
                    isSupport = true;
                    break;
                }
            }
        } else {
            isSupport = true;
        }
        return isSupport;
    }

    protected boolean isContentTypeSupport(String contentType, ServiceApiOperation serviceApiOperation) {
        boolean isSupport = false;
        if (ValidUtils.isValid(serviceApiOperation.consumes())) {
            ContentType actualContentType = ContentType.valueOfName(contentType);
            for (ContentType supportContentType : serviceApiOperation.consumes()) {
                if (actualContentType == supportContentType) {
                    isSupport = true;
                    break;
                }
            }
        } else {
            isSupport = true;
        }
        return isSupport;
    }
}
