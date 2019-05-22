package io.github.pactstart.service.dispatcher.executor;

import com.alibaba.fastjson.JSON;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.service.dispatcher.annotation.ServiceParam;
import io.github.pactstart.service.dispatcher.exception.ServiceApiException;
import io.github.pactstart.service.dispatcher.request.ServiceApiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Parameter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultMethodParamParser implements MethodParamParser {

    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private static final Logger logger = LoggerFactory.getLogger(DefaultMethodParamParser.class);

    @Override
    public Object parse(Class<?> pType, Parameter parameter, ServiceApiRequest request) {
        String pName = null;
        ServiceParam serviceParam = parameter.getAnnotation(ServiceParam.class);
        if (serviceParam != null) {
            pName = pType.getAnnotation(ServiceParam.class).value();
        }
        Object object = null;
        if (pName == null && !pType.isPrimitive() && isBean(pType)) {
            object = resolveRequestParam(pType, request);
        }
        Valid valid = parameter.getAnnotation(Valid.class);
        if (valid != null) {
            validate(object, null);
        }
        return object;
    }

    public Object resolveRequestParam(Class<?> pType, ServiceApiRequest request) {
        return JSON.parseObject(request.getRequest(), pType);

    }

    protected boolean isBean(Class<?> cls) {
        return !(cls.isPrimitive() || cls == String.class || cls == Boolean.class || cls == Character.class || Number.class.isAssignableFrom(cls) || Date.class
                .isAssignableFrom(cls) || List.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls) || Set.class
                .isAssignableFrom(cls));
    }

    protected void validate(Object params, Class<?>[] groups) {
        Set<ConstraintViolation<Object>> constraintViolations = null;
        if (groups != null) {
            constraintViolations = validator.validate(params, groups);
        } else {
            constraintViolations = validator.validate(params);
        }
        if (constraintViolations != null) {
            for (ConstraintViolation<Object> validation : constraintViolations) {
                throw new ServiceApiException(ResponseCode.INVALID_PARAM, validation.getMessage());
            }
        }
    }
}
