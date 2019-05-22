package io.github.pactstart.simple.web.framework.encrypt.springboot.annotation;

import java.lang.annotation.*;

/**
 * 加密注解
 * <p>加了此注解的接口将进行数据加密操作<p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Encrypt {

    String value() default "";

}
