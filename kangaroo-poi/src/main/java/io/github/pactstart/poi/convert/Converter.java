package io.github.pactstart.poi.convert;

public interface Converter<S, T> {

    T convert(S source);
}
