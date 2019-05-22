package io.github.pactstart.juhe.client;

import io.github.pactstart.http.HttpClient;

public class JuheVClient extends HttpClient {
    @Override
    public String getUrlRoot() {
        return "http://v.juhe.cn";
    }
}
