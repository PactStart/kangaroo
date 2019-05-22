package io.github.pactstart.simple.web.framework.encrypt.springboot.autoconfigure;

import com.google.common.collect.Lists;
import io.github.pactstart.simple.web.framework.encrypt.springboot.annotation.Encrypt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Slf4j
public class EncryptApiScanner implements ApplicationContextAware {

    public static List<String> encryptUriList = Lists.newArrayList();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(RestController.class);
        initData(beanMap);
        beanMap = applicationContext.getBeansWithAnnotation(Controller.class);
        initData(beanMap);
    }

    private void initData(Map<String, Object> beanMap) {
        if (beanMap != null) {
            for (Object bean : beanMap.values()) {
                Class<?> clz = bean.getClass();
                Method[] methods = clz.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Encrypt.class)) {
                        // 注解中的URI优先级高
                        String uri = method.getAnnotation(Encrypt.class).value();
                        if (!StringUtils.hasText(uri)) {
                            uri = getApiUri(clz, method);
                        }
                        encryptUriList.add(uri);
                    }
                }
            }
        }
    }

    private String getApiUri(Class<?> clz, Method method) {
        String methodType = "";
        StringBuilder uri = new StringBuilder();

        if (clz.isAnnotationPresent(RequestMapping.class)) {
            uri.append(formatUri(clz.getAnnotation(RequestMapping.class).value()[0]));
        }

        if (method.isAnnotationPresent(RequestMapping.class)) {
            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
            RequestMethod m = requestMapping.method()[0];
            methodType = m.name().toLowerCase();
            uri.append(formatUri(requestMapping.value()[0]));
        } else if (method.isAnnotationPresent(GetMapping.class)) {
            methodType = "get";
            uri.append(formatUri(method.getAnnotation(GetMapping.class).value()[0]));
        } else if (method.isAnnotationPresent(PostMapping.class)) {
            methodType = "post";
            uri.append(formatUri(method.getAnnotation(PostMapping.class).value()[0]));
        } else if (method.isAnnotationPresent(PutMapping.class)) {
            methodType = "put";
            uri.append(formatUri(method.getAnnotation(PutMapping.class).value()[0]));
        } else if (method.isAnnotationPresent(DeleteMapping.class)) {
            methodType = "delete";
            uri.append(formatUri(method.getAnnotation(DeleteMapping.class).value()[0]));
        }
        return methodType + uri.toString();
    }

    private String formatUri(String uri) {
        if (uri.startsWith("/")) {
            return uri;
        }
        return "/" + uri;
    }
}
