package io.github.pactstart.juhe.client;

import io.github.pactstart.http.HttpClient;

public class JuheSilkClient extends HttpClient {
    @Override
    public String getUrlRoot() {
        return "http://bankcardsilk.api.juhe.cn";
    }
}
