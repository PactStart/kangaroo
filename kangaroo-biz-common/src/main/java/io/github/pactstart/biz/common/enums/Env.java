package io.github.pactstart.biz.common.enums;

public enum Env {

    local, dev, test, prod;

    private Env valueOfName(String name) {
        Env result = null;
        for (Env env : values()) {
            if (env.name().equals(name)) {
                result = env;
                break;
            }
        }
        return result;
    }
}
