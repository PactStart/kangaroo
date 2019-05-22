package io.github.pactstart.service.dispatcher.executor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.pactstart.commonutils.ReflectionUtils;
import io.github.pactstart.commonutils.ValidUtils;
import io.github.pactstart.service.dispatcher.annotation.ServiceApi;
import io.github.pactstart.service.dispatcher.annotation.ServiceApiOperation;
import io.github.pactstart.service.dispatcher.api.ApiInterface;
import io.github.pactstart.service.dispatcher.api.ApiParam;
import io.github.pactstart.service.dispatcher.enums.RequestMethod;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceApiExecutorHolder {

    private static final Logger logger = LoggerFactory.getLogger(ServiceApiExecutorHolder.class);

    private static final Map<String, ServiceApiExecutor> CLIENT_API_EXECUTOR_MAP = new ConcurrentHashMap();
    private static Map<String, String> javaType2JsType = Maps.newHashMap();

    static {
        javaType2JsType.put("String", "string");
        javaType2JsType.put("Integer", "int");
        javaType2JsType.put("Long", "int");
        javaType2JsType.put("Float", "float");
        javaType2JsType.put("Double", "float");
        javaType2JsType.put("Boolean", "bool");
    }

    private static void add(String cmd, ServiceApiExecutor executor) {
        CLIENT_API_EXECUTOR_MAP.put(cmd, executor);
    }

    public static ServiceApiExecutor getClientApiExecutor(String cmd) {
        return CLIENT_API_EXECUTOR_MAP.get(cmd);
    }

    public static List<ApiInterface> addServiceBean(Object bean, Class clazz, ServiceApi serviceApi, String prefixCmd, MethodParamParser paramParser) {
        List<ApiInterface> apiInterfaceList = Lists.newArrayList();
        Method[] methods = clazz.getMethods();
        if (!ValidUtils.isValid(methods)) {
            return apiInterfaceList;
        }
        for (Method method : methods) {
            if (!method.isAnnotationPresent(ServiceApiOperation.class)) {
                continue;
            }
            ServiceApiOperation serviceApiOperation = method.getAnnotation(ServiceApiOperation.class);
            for (String value : serviceApiOperation.value()) {
                String cmd = "/" .concat(prefixCmd).concat("/").concat(value).replaceAll("/{2}+", "/");

                add(cmd, ServiceApiExecutorBuilder.build(bean, method, method.getParameterTypes(), paramParser, serviceApi, serviceApiOperation, cmd));

                logger.info("cmd:{},class:{},method:{}", cmd, clazz.getSimpleName(), method.getName());

                ApiInterface apiInterface = new ApiInterface();
                apiInterface.setCmd(cmd);
                apiInterface.setMethods(getSupportedMethod(serviceApiOperation));
                apiInterface.setNotes(serviceApiOperation.notes());

                for (Class pClazz : method.getParameterTypes()) {
                    if (ReflectionUtils.isComplexType(clazz)) {
                        apiInterface.setParamList(parseClass(pClazz));
                        break;
                    }
                }
                apiInterfaceList.add(apiInterface);
            }
        }
        return apiInterfaceList;
    }

    private static List<ApiParam> parseClass(Class clazz) {
        List<ApiParam> apiParamList = Lists.newArrayList();
        Field[] allDeclaredFields = ReflectionUtils.getAllDeclaredFields(clazz);
        for (Field field : allDeclaredFields) {
            ApiParam apiParam = new ApiParam();
            apiParam.setParamName(field.getName());
            if (ReflectionUtils.isComplexType(field.getType())) {
                if (field.getType().isArray()) {
                    apiParam.setParamType("object[]");
                    List<ApiParam> subApiParamList = parseClass(field.getType().getComponentType());
                    apiParam.setParamList(subApiParamList);
                } else if (field.getType() == List.class) {
                    apiParam.setParamType("object[]");
                    List<ApiParam> subApiParamList = parseClass(field.getGenericType().getClass());
                    apiParam.setParamList(subApiParamList);
                } else {
                    apiParam.setParamType("object");
                }
            } else {
                if (field.getType().isArray()) {
                    apiParam.setParamType(javaType2JsType.get(field.getType().getComponentType().getSimpleName()) + "[]");
                } else {
                    apiParam.setParamType(javaType2JsType.get(field.getType().getSimpleName()));
                }
            }
            apiParam.setConstraintList(parseJSR303Annotation(field));
            apiParamList.add(apiParam);
        }
        return apiParamList;
    }

    private static List<String> parseJSR303Annotation(Field field) {
        List<String> constraintList = Lists.newArrayList();
        if (field.isAnnotationPresent(NotNull.class)) {
            constraintList.add("必传，不能为空");
        }
        if (field.isAnnotationPresent(Length.class)) {
            Length length = field.getAnnotation(Length.class);
            constraintList.add("最小长度:" + length.min() + ",最大长度：" + length.max());
        }
        if (field.isAnnotationPresent(NotBlank.class)) {
            constraintList.add("必传，不能为空字符串");
        }
        if (field.isAnnotationPresent(Min.class)) {
            Min min = field.getAnnotation(Min.class);
            constraintList.add("最小值: " + min.value());
        }
        if (field.isAnnotationPresent(Max.class)) {
            Max max = field.getAnnotation(Max.class);
            constraintList.add("最大值: " + max.value());
        }
        if (field.isAnnotationPresent(URL.class)) {
            constraintList.add("URL格式");
        }
        if (field.isAnnotationPresent(Email.class)) {
            constraintList.add("Email格式");
        }
        return constraintList;
    }

    private static String getSupportedMethod(ServiceApiOperation serviceApiOperation) {
        RequestMethod[] supportedMethods = ValidUtils.isValid(serviceApiOperation.method()) ? serviceApiOperation.method() : RequestMethod.values();
        String methodNames = "";
        for (RequestMethod requestMethod : supportedMethods) {
            methodNames = methodNames + requestMethod.name() + ",";
        }
        return methodNames.substring(0, methodNames.lastIndexOf(","));
    }


}
