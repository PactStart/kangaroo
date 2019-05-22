package io.github.pactstart.simple.web.framework.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.StringTokenizer;

public class WebUtils {

    public static final String TEXT_TYPE = "text/plain";
    public static final String JSON_TYPE = "application/json";
    public static final String XML_TYPE = "text/xml";
    public static final String HTML_TYPE = "text/html";
    public static final String JS_TYPE = "text/javascript";
    public static final String EXCEL_TYPE = "application/vnd.ms-excel";
    public static final String JPEG_TYPE = "image/jpeg";
    public static final String AUTHENTICATION_HEADER = "Authorization";

    public static String getWebRoot() {
        String root = System.getProperty("webapp.root");
        if (root == null) {
            root = System.getProperty("user.dir");
        }
        return root;
    }

    public static String getRequestPath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        if (contextPath == null) {
            contextPath = "";
        }
        return request.getRequestURI().substring(contextPath.length());
    }

    public static String getRequestUri(HttpServletRequest request) {
        return getRequestURL(request, false);
    }

    public static HttpServletRequest getCurrentRequest() {
        ServletRequestAttributes reqAttrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = reqAttrs.getRequest();
        return request;
    }

    public static String getRequestURL(HttpServletRequest request, boolean encoding) {
        StringBuilder buff = new StringBuilder();
        buff.append(request.getRequestURL());
        String queryString = request.getQueryString();
        if (encoding) {
            try {
                queryString = URLEncoder.encode(queryString, "utf-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        if (queryString != null) {
            buff.append("?").append(queryString);
        }
        return buff.toString();
    }

    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }

    public static String buildURL(String path, String queryString) {
        HttpServletRequest request = WebUtils.getCurrentRequest();
        return buildURL(request, path, queryString);
    }

    public static String buildURL(HttpServletRequest request, String path, String queryString) {
        StringBuffer buffer = request.getRequestURL();
        int index = buffer.indexOf("://");
        index = buffer.indexOf("/", index + 4);
        buffer.delete(index, buffer.length());
        buffer.append(request.getContextPath());
        buffer.append(path);
        if (!StringUtils.isEmpty(queryString)) {
            buffer.append("?").append(queryString);
        }
        return buffer.toString();
    }

    public static void setExpiresHeader(HttpServletResponse response, long expiresSeconds) {
        // Http 1.0 header
        response.setDateHeader("Expires", System.currentTimeMillis() + expiresSeconds * 1000);
        // Http 1.1 header
        response.setHeader("Cache-Control", "private, max-age=" + expiresSeconds);
    }

    public static void setDisableCacheHeader(HttpServletResponse response) {
        // Http 1.0 header
        response.setDateHeader("Expires", 1L);
        response.addHeader("Pragma", "no-cache");
        // Http 1.1 header
        response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
    }

    public static void setLastModifiedHeader(HttpServletResponse response, long lastModifiedDate) {
        response.setDateHeader("Last-Modified", lastModifiedDate);
    }

    public static void setEtag(HttpServletResponse response, String etag) {
        response.setHeader("ETag", etag);
    }

    public static boolean checkIfModifiedSince(HttpServletRequest request, HttpServletResponse response,
                                               long lastModified) {
        long ifModifiedSince = request.getDateHeader("If-Modified-Since");
        if ((ifModifiedSince != -1) && (lastModified < ifModifiedSince + 1000)) {
            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            return false;
        }
        return true;
    }

    public static boolean checkIfNoneMatchEtag(HttpServletRequest request, HttpServletResponse response, String etag) {
        String headerValue = request.getHeader("If-None-Match");
        if (headerValue != null) {
            boolean conditionSatisfied = false;
            if (!"*".equals(headerValue)) {
                StringTokenizer commaTokenizer = new StringTokenizer(headerValue, ",");

                while (!conditionSatisfied && commaTokenizer.hasMoreTokens()) {
                    String currentToken = commaTokenizer.nextToken();
                    if (currentToken.trim().equals(etag)) {
                        conditionSatisfied = true;
                    }
                }
            } else {
                conditionSatisfied = true;
            }

            if (conditionSatisfied) {
                response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                response.setHeader("ETag", etag);
                return false;
            }
        }
        return true;
    }

    public static void setFileDownloadHeader(HttpServletResponse response, String fileName) {
        try {
            String encodedfileName = new String(fileName.getBytes(), "utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
        } catch (UnsupportedEncodingException e) {
        }
    }

    /**
     * 在很多应用下都可能有需要将用户的真实IP记录下来，这时就要获得用户的真实IP地址，在JSP里，获取客户端的IP地
     * 址的方法是：request.getRemoteAddr()，这种方法在大部分情况下都是有效的。但是在通过了Apache,Squid等
     * 反向代理软件就不能获取到客户端的真实IP地址了。
     * 但是在转发请求的HTTP头信息中，增加了X－FORWARDED－FOR信息。用以跟踪原有的客户端IP地址和原来客户端请求的服务器地址。
     *
     * @param request 请求
     * @return 客户端ip
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (!StringUtils.isEmpty(ip)) {
            ip = ip.split(",")[0];
        }
        return ip;
    }

    public static String getUrl(HttpServletRequest request, String path, Object... params) {
        StringBuilder buff = new StringBuilder();
        buff.append("http://");
        buff.append(request.getHeader("host"));
        buff.append(request.getContextPath()).append(path);
        if (params != null && params.length > 0) {
            buff.append("?");
            for (Object obj : params) {
                String name = (String) Array.get(obj, 0);
                String value = (String) Array.get(obj, 1);
                try {
                    value = URLEncoder.encode(value.trim(), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                buff.append(name).append("=").append(value).append("&");
            }
            buff.delete(buff.length() - 1, buff.length());
        }
        return buff.toString();
    }

    public static String getRomoteIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String insertURLParams(String url, String params) {
        String hash = "";
        int index = url.indexOf("#");
        if (index != -1) {
            hash = url.substring(index);
            url = url.substring(0, index);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        if (url.contains("?")) {
            sb.append("&").append(params);
        } else {
            sb.append("?").append(params);
        }
        sb.append(hash);
        return sb.toString();
    }
}
