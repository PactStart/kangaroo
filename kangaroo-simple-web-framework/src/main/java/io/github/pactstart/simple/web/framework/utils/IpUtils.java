package io.github.pactstart.simple.web.framework.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;

public class IpUtils {

    private static final String UNKNOWN = "unknown";

    private IpUtils() {
        throw new IllegalAccessError("Utility class");
    }

    public static List<String> getInet4AddressList()
            throws SocketException {
        List ipList = new ArrayList();
        Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            Enumeration addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                ip = (InetAddress) addresses.nextElement();
                if ((ip != null) && ((ip instanceof Inet4Address)) && (!"127.0.0.1".equals(ip.getHostAddress()))) {
                    ipList.add(ip.getHostAddress());
                }
            }
        }
        return ipList;
    }

    public static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        ip = request.getHeader("Proxy-Client-IP");
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        ip = request.getHeader("WL-Proxy-Client-IP");
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        ip = request.getHeader("HTTP_X_FORWARDED");
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        ip = request.getHeader("HTTP_CLIENT_IP");
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        ip = request.getHeader("HTTP_FORWARDED_FOR");
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        ip = request.getHeader("HTTP_FORWARDED");
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        ip = request.getHeader("HTTP_VIA");
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        ip = request.getHeader("REMOTE_ADDR");
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        ip = request.getRemoteAddr();
        if ((StringUtils.isNotEmpty(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
            if ("0:0:0:0:0:0:0:1".equals(ip)) {
                ip = "127.0.0.1";
            }
            return new StringTokenizer(ip, ",").nextToken().trim();
        }

        return null;
    }
}