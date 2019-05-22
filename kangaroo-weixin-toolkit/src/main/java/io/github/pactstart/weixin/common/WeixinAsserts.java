package io.github.pactstart.weixin.common;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Rex.Lei on 2017/7/27.
 */
public class WeixinAsserts {

    public static void check(final boolean expression, final String message) {
        if (expression) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void check(final boolean expression, final String message, final Object... args) {
        if (expression) {
            throw new IllegalArgumentException(String.format(message, args));
        }
    }

    public static void check(final boolean expression, final String message, final Object arg) {
        if (expression) {
            throw new IllegalArgumentException(String.format(message, arg));
        }
    }

    public static void notNull(final Object object, final String name) {
        if (object == null) {
            throw new IllegalArgumentException(name + " is null");
        }
    }

    public static void notEmpty(final CharSequence s, final String name) {
        if (StringUtils.isEmpty(s)) {
            throw new IllegalArgumentException(name + " is empty");
        }
    }

    public static void notBlank(final CharSequence s, final String name) {
        if (StringUtils.isBlank(s)) {
            throw new IllegalArgumentException(name + " is blank");
        }
    }
}
