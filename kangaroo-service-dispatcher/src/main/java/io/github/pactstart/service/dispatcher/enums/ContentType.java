package io.github.pactstart.service.dispatcher.enums;

public enum ContentType {

    APPLICATION_JSON("application/json");

//    MULTIPART_FORM_DATA("mutipart/param-data"),
//
//    X_WWW_FORM_URLENCODED("application/x-www-param-urlencoded");

    private String name;

    ContentType(String name) {
        this.name = name;
    }

    public static ContentType valueOfName(String value) {
        ContentType target = null;
        for (ContentType contentType : values()) {
            if (contentType.getName().equals(value)) {
                target = contentType;
                break;
            }
        }
        return target;
    }

    public String getName() {
        return name;
    }
}
