package io.github.pactstart.simple.web.framework.interceptor;

import io.github.pactstart.biz.common.utils.SpringContextHolder;
import io.github.pactstart.simple.web.framework.common.RequestHolder;
import io.github.pactstart.simple.web.framework.externs.RequestCompleteCallbackService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpInterceptor extends HandlerInterceptorAdapter {

    public static final String START_TIME = "requestStartTime";

    private boolean servletRequestWrapperEnabled = false;

    public HttpInterceptor(boolean servletRequestWrapperEnabled) {
        this.servletRequestWrapperEnabled = servletRequestWrapperEnabled;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestCompleteCallbackService bean = SpringContextHolder.getBean(RequestCompleteCallbackService.class);
        if (bean != null) {
            bean.callback(request, response, handler, ex, servletRequestWrapperEnabled);
        }
        removeThreadLocalInfo();
    }

    public void removeThreadLocalInfo() {
        RequestHolder.remove();
    }

}
