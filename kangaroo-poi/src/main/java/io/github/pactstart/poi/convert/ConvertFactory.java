package io.github.pactstart.poi.convert;

import java.util.HashMap;
import java.util.Map;

public class ConvertFactory {

    private static final Map<Class<? extends Converter<?, ?>>, Converter<?, ?>> converters = new HashMap<Class<? extends Converter<?, ?>>, Converter<?, ?>>();

    @SuppressWarnings("unchecked")
    public static <S, T> Converter<S, T> getConverter(Class<? extends Converter<?, ?>> clazz) {
        try {
            Converter<?, ?> converter = converters.get(clazz);
            if (converter == null) {
                converter = clazz.newInstance();
                converters.put(clazz, converter);
            }
            return (Converter<S, T>) converter;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object convert(Class<? extends Converter<?, ?>> clazz, Object value) {
        Converter<Object, Object> converter = getConverter(clazz);
        return converter.convert(value);
    }
}
