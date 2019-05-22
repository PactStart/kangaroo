package io.github.pactstart.biz.common.utils;

import io.github.pactstart.biz.common.enums.Env;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static Environment environment;

    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextHolder.applicationContext = applicationContext;
        SpringContextHolder.environment = applicationContext.getEnvironment();
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     * @param name bean的名称
     * @param <T> bean的类型
     * @return bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.如果有多个Bean符合Class, 取出第一个.
     * @param requiredType 指定类型
     * @param <T> 泛型类型
     * @return 指定类型的bean
     */
    public static <T> T getBean(Class<T> requiredType) {
        checkApplicationContext();
        return applicationContext.getBean(requiredType);
    }

    /**
     * 判断当前bean容器中是否包含指定名称的bean
     *
     * @param name bean的名称
     * @return true包含false不包含
     */
    public static boolean containsBean(String name) {
        checkApplicationContext();
        return applicationContext.containsBean(name);
    }

    /**
     * 根据类型获取容器中实例的集合
     *
     * @param requiredType 指定类型
     * @param <T> 泛型类型
     * @return 指定类型的对象
     */
    public static <T> Map<String, T> getBeans(Class<T> requiredType) {
        checkApplicationContext();
        return applicationContext.getBeansOfType(requiredType);
    }

    /**
     * 清除applicationContext静态变量.
     */
    public static void cleanApplicationContext() {
        applicationContext = null;
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicationContext未注入");
        }
    }

    public static Environment getEnvironment() {
        return environment;
    }

    public static Env getCurrentEnv() {
        return Env.valueOf(environment.getActiveProfiles()[0]);
    }

}
