package io.github.pactstart.simple.web.framework.encrypt.springboot.annotation;

import io.github.pactstart.simple.web.framework.encrypt.springboot.autoconfigure.EncryptAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({EncryptAutoConfiguration.class})
public @interface EnableEncrypt {

}
