package io.github.pactstart.juhe.client;

import io.github.pactstart.http.HttpClient;

public class JuheOPClient extends HttpClient {
    @Override
    public String getUrlRoot() {
        return "http://op.juhe.cn";
    }
}
