package io.github.pactstart.simple.web.framework.filter;

import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.simple.web.framework.enums.RequestSource;
import io.github.pactstart.simple.web.framework.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class RequestSourceFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getServletPath().endsWith(".json") && !RequestMethod.OPTIONS.name().equals(request.getMethod())
                && RequestSource.valueOfName(((HttpServletRequest) servletRequest).getHeader("device")) == null) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            ResponseUtils.outputJson(httpServletResponse, ResponseCode.REQUEST_SOURCE_NOT_ALLOWED);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
