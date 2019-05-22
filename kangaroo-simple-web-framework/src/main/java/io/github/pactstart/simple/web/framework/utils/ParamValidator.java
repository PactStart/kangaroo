package io.github.pactstart.simple.web.framework.utils;

import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import org.springframework.validation.BindingResult;

public class ParamValidator {

    public static void validate(BindingResult br) {
        if (br.hasErrors()) {
            throw new ApplicationException(ResponseCode.INVALID_PARAM, br.getFieldError().getDefaultMessage());
        }
    }
}
