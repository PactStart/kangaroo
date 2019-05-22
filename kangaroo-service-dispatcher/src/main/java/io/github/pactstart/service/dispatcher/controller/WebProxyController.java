package io.github.pactstart.service.dispatcher.controller;

import io.github.pactstart.commonutils.JsonUtils;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.service.dispatcher.dispatcher.ServiceDispatcher;
import io.github.pactstart.service.dispatcher.request.WebServiceApiRequest;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public abstract class WebProxyController {

    protected static String getRequestData(HttpServletRequest request) throws IOException {
        String reqContent = null;
        //GET请求从查询字符串中获取参数
        if ("GET" .equals(request.getMethod())) {
            String queryString = request.getQueryString();
            if (ValidUtils.isValid(queryString)) {
                Map<String, String> data = new HashMap<>();
                String[] arr = queryString.split("&");
                for (String item : arr) {
                    String[] param = item.split("=");
                    data.put(param[0], param[1]);
                }
                reqContent = JsonUtils.obj2String(data);
            } else {
                reqContent = "{}";
            }
        } else {
            if ("application/json" .equals(request.getContentType())) {
                StringWriter sw = new StringWriter();
                IOUtils.copy(request.getInputStream(), sw);
                return sw.toString();
            } else {
                reqContent = "{}";
            }
        }
        return reqContent;
    }

    protected void parseHttpServletRequest(WebServiceApiRequest proxyRequest, HttpServletRequest httpServletRequest) throws IOException {
        proxyRequest.setRequest(getRequestData(httpServletRequest));
        proxyRequest.setContentType(httpServletRequest.getContentType());
        proxyRequest.setRequestMethod(httpServletRequest.getMethod());
        proxyRequest.setCmd(getCmd(httpServletRequest));
    }

    protected String getCmd(HttpServletRequest request) {
        return request.getServletPath();
    }

    protected abstract ServiceDispatcher getServiceDispatcher();
}
