package io.github.pactstart.simple.web.framework.externs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RequestCompleteCallbackService {

    void callback(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex, boolean isServletRequestWrapperEnabled) throws Exception;
}
