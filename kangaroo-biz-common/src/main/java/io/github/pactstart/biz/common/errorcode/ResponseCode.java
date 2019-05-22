package io.github.pactstart.biz.common.errorcode;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class ResponseCode implements Serializable {

    // 成功
    public static final ResponseCode SUCCESS = new ResponseCode(0, "成功");
    // 系统异常
    public static final ResponseCode SYSTEM_ERROR = new ResponseCode(100001, "系统异常");
    // 参数不合法
    public static final ResponseCode INVALID_PARAM = new ResponseCode(100002, "参数不合法");
    // 超时
    public static final ResponseCode TIME_OUT = new ResponseCode(100003, "系统内部访问超时");
    // json 字符串不合法
    public static final ResponseCode INVALID_JSON_STRING = new ResponseCode(100004, "不合法的json串");
    // 资源存在
    public static final ResponseCode RESOURCE_EXISTS = new ResponseCode(100005, "资源已经存在");
    // 资源不存在
    public static final ResponseCode RESOURCE_NOT_EXISTS = new ResponseCode(100006, "资源不存在");
    // 不支持的操作
    public static final ResponseCode NON_SUPPORTED_OPER = new ResponseCode(100007, "不支持的操作");
    // 无权操作
    public static final ResponseCode NO_PERMISSION = new ResponseCode(100008, "没有权限操作");
    //会话过期
    public static final ResponseCode SESSION_EXPIRED = new ResponseCode(100009, "会话已过期，请重新登陆");
    //请求方式不合法
    public static final ResponseCode REQUEST_METHOD_NOT_SUPPORTED = new ResponseCode(100010, "不支持的请求方式");
    //请求数据格式不合法
    public static final ResponseCode MEDIA_TYPE_NOT_SUPPORTED = new ResponseCode(100011, "不支持的数据类型");
    //访问频繁
    public static final ResponseCode REQUEST_FREQUENCY_TOO_FAST = new ResponseCode(100012, "访问频繁");
    //请求头缺失
    public static final ResponseCode LACK_NECESSARY_REQUEST_HEADER = new ResponseCode(100013, "缺失必要的请求头");
    //未登录
    public static final ResponseCode NOT_YET_LOGIN = new ResponseCode(1000014, "登录已失效，请重新登录");
    //请求接口不存在
    public static final ResponseCode REQUEST_URL_NOT_FOUND = new ResponseCode(1000015, "请求接口不存在");
    //请求数据不合法
    public static final ResponseCode REQUEST_DATA_NOT_VALID = new ResponseCode(1000016, "请求数据不合法");
    //请求来源不合法
    public static final ResponseCode REQUEST_SOURCE_NOT_ALLOWED = new ResponseCode(1000017, "请求来源不合法");
    //数据过期，需要重新刷新
    public static final ResponseCode DATA_EXPIRED_NEED_REFRESH = new ResponseCode(100018, "数据状态已过期，需要重新刷新");
    //请求已过期
    public static final ResponseCode REQUEST_EXPIRED = new ResponseCode(100019, "请求已过期");
    //签名不合法
    public static final ResponseCode SIGN_INVALID = new ResponseCode(100020, "签名不合法");

    private int code;

    private String msg;

    private Object data;

    public ResponseCode() {
    }

    public ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseCode(ResponseCode responseCode, String msg) {
        this.code = responseCode.getCode();
        this.msg = msg;
    }

    public static ResponseCode buildResponse(Object data) {
        ResponseCode responseCode = new ResponseCode(SUCCESS.getCode(), "请求成功");
        responseCode.setData(data);
        return responseCode;
    }

    public boolean isSuccess() {
        return code == SUCCESS.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}