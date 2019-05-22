package io.github.pactstart.simple.web.framework.filter;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.utils.SpringContextHolder;
import io.github.pactstart.commonutils.JsonUtils;
import io.github.pactstart.simple.web.framework.auth.AuthenticationInfo;
import io.github.pactstart.simple.web.framework.auth.AuthorizationService;
import io.github.pactstart.simple.web.framework.common.RequestHolder;
import io.github.pactstart.simple.web.framework.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class AclControlFilter implements Filter {

    private static Set<String> exclusionUrlSet = Sets.newConcurrentHashSet();

    private static String authUrl = "";

    private static AntPathMatcher matcher = new AntPathMatcher();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String exclusionUrls = filterConfig.getInitParameter("exclusionUrls");
        List<String> exclusionUrlList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(exclusionUrls);
        exclusionUrlSet = Sets.newConcurrentHashSet(exclusionUrlList);
        authUrl = filterConfig.getInitParameter("authUrl");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        Map requestMap = request.getParameterMap();

        if (exclusionUrlSet.stream().anyMatch((url) -> matcher.match(url, servletPath))) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        AuthenticationInfo authenticationInfo = RequestHolder.getAuthenticationInfo();
        if (authenticationInfo == null) {
            log.warn("someone visit {}, but no login, parameter:{}", servletPath, JsonUtils.obj2String(requestMap));
            noAuth(request, response);
            return;
        }
        AuthorizationService authorizationService = SpringContextHolder.getBean(AuthorizationService.class);
        if (!authorizationService.canAccess(authenticationInfo, servletPath)) {
            log.info("{} visit {}, parameter:{}", authenticationInfo.getUserName(), servletPath, JsonUtils.obj2String(requestMap));
            noAuth(request, response);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    private void noAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String servletPath = request.getServletPath();
        if (servletPath.endsWith(".json")) {
            ResponseUtils.outputJson(response, new ResponseCode(ResponseCode.NO_PERMISSION, "没有访问权限，如需要访问，请联系管理员"));
            return;
        } else {
            ResponseUtils.clientRedirect(authUrl, response);
            return;
        }
    }


    @Override
    public void destroy() {

    }
}
