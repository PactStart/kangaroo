package io.github.pactstart.rong360.openapi.request;

import io.github.pactstart.rong360.openapi.response.SendMessageResponse;

import java.util.List;

public class SendMessageRequest extends BaseRequest<SendMessageResponse> {

    /**
     * 构造短信发送请求
     *
     * @param order_nos 订单编号,最多200
     * @param temp_id   短信模板ID
     */
    public SendMessageRequest(List<String> order_nos, String temp_id) {
        this.putBizData("order_nos", order_nos);
        this.putBizData("temp_id", temp_id);
    }

    @Override
    public String getMethod() {
        return "is.api.v3.order.sengmessage";
    }
}
