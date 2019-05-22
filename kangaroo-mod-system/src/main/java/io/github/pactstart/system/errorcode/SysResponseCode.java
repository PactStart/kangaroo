package io.github.pactstart.system.errorcode;

import io.github.pactstart.biz.common.errorcode.ResponseCode;

public class SysResponseCode {

    public static final ResponseCode SYS_USER_NOT_EXIST = new ResponseCode(1001, "用户不存在");

    public static final ResponseCode SYS_USER_PASSWORD_ERROR = new ResponseCode(1002, "密码错误");

    public static final ResponseCode SYS_USER_FROZEN = new ResponseCode(1003, "账号已冻结，请求联系管理员");
}
