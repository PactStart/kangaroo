package io.github.pactstart.simple.web.framework.fastjson;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import io.github.pactstart.biz.common.errorcode.ResponseCode;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotWritableException;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.UiConfiguration;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@ConditionalOnClass({FastJsonHttpMessageConverter.class})
@ConditionalOnProperty(
        name = {"spring.http.converters.preferred-json-mapper"},
        havingValue = "fastjson",
        matchIfMissing = true
)
public class FastJson2HttpMessageConverterConfiguration {

    @Bean
    @ConditionalOnMissingBean({FastJsonHttpMessageConverter.class})
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter() {
            @Override
            protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
                if (obj == null) {
                    super.writeInternal(ResponseCode.buildResponse(null), outputMessage);
                } else if (obj instanceof ResponseCode) {
                    super.writeInternal(obj, outputMessage);
                } else if (obj instanceof String) {
                    // 字符串的不再做一次封装
                    String text = (String) obj;
                    OutputStream out = outputMessage.getBody();
                    byte[] bytes = text.getBytes(this.getFastJsonConfig().getCharset());
                    out.write(bytes);
                } else if (isSwagger(obj)) {
                    if (obj instanceof Json) {
                        Json json = (Json) obj;
                        OutputStream out = outputMessage.getBody();
                        byte[] bytes = json.value().getBytes(this.getFastJsonConfig().getCharset());
                        out.write(bytes);
                    } else {
                        super.writeInternal(obj, outputMessage);
                    }
                } else {
                    if (obj instanceof LinkedHashMap) {
                        Map map = (Map) obj;
//                        {
//                            "timestamp": 1528018383392,
//                                "status": 404,
//                                "error": "Not Found",
//                                "message": "No message available",
//                                "path": "/sys/user/xx.json"
//                        }
                        if (map.containsKey("status") && map.containsKey("timestamp") && map.containsKey("error")
                                && map.containsKey("message") && map.containsKey("path")) {
                            HttpStatus status = HttpStatus.valueOf(Integer.valueOf(map.get("status").toString()));
                            if (status == HttpStatus.NOT_FOUND) {
                                super.writeInternal(ResponseCode.REQUEST_URL_NOT_FOUND, outputMessage);
                                return;
                            }
                            if (status == HttpStatus.BAD_REQUEST) {
                                super.writeInternal(ResponseCode.REQUEST_DATA_NOT_VALID, outputMessage);
                                return;
                            }
                            if (status == HttpStatus.INTERNAL_SERVER_ERROR) {
                                super.writeInternal(ResponseCode.SYSTEM_ERROR, outputMessage);
                                return;
                            }
                        }
                    }
                    super.writeInternal(ResponseCode.buildResponse(obj), outputMessage);
                }
            }
        };

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat,
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty
        );
        converter.setFastJsonConfig(fastJsonConfig);
        return converter;
    }

    private boolean isSwagger(Object obj) {
        if (obj instanceof UiConfiguration || obj instanceof Json) {
            return true;
        } else if (obj instanceof ArrayList) {
            ArrayList list = (ArrayList) obj;
            return list.size() > 0 && list.get(0) instanceof SwaggerResource;
        } else {
            return false;
        }
    }
}