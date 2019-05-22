package io.github.pactstart.simple.web.framework.handler;

import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object jsonErrorHandler(HttpServletRequest req, Exception e) {
        logger.error("服务器错误", e);
        req.setAttribute("ex", e);
        return ResponseCode.SYSTEM_ERROR;
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Object jsonErrorHandler(HttpServletRequest req, HttpRequestMethodNotSupportedException e) {
        ResponseCode responseCode = ResponseCode.REQUEST_METHOD_NOT_SUPPORTED;
        responseCode.setMsg(e.getMessage());
        return responseCode;
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public Object jsonErrorHandler(HttpServletRequest req, HttpMediaTypeNotSupportedException e) {
        ResponseCode responseCode = ResponseCode.MEDIA_TYPE_NOT_SUPPORTED;
        responseCode.setMsg(e.getMessage());
        return responseCode;
    }

    @ExceptionHandler(value = ApplicationException.class)
    @ResponseBody
    public Object jsonErrorHandler(HttpServletRequest req, ApplicationException e) {
        if (e.getSourceException() != null) {
            logger.error("", e.getSourceException());
        }
        return e.getResponseCode();
    }

}