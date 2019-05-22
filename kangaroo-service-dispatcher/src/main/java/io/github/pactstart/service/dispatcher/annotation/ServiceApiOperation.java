package io.github.pactstart.service.dispatcher.annotation;

import io.github.pactstart.service.dispatcher.enums.ContentType;
import io.github.pactstart.service.dispatcher.enums.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.METHOD})
@Retention(RUNTIME)
public @interface ServiceApiOperation {

    /**
     * 接口地址
     *
     * @return
     */
    String[] value();

    /**
     * 请求方式，web环境下才起作用
     *
     * @return
     */
    RequestMethod[] method() default {};

    /**
     * 请求内容格式，web环境下才起作用
     *
     * @return
     */
    ContentType[] consumes() default {};

    /**
     * 接口描述
     *
     * @return
     */
    String notes() default "";

    /**
     * 访问权限控制
     *
     * @return
     */
    String[] acls() default {};

    /**
     * 请求速率控制
     *
     * @return
     */
    String[] rateLimits() default {};

}
