package io.github.pactstart.rong360.openapi.request;

import io.github.pactstart.rong360.openapi.response.ImageGetResponse;

/**
 * 获取图片内容请求
 */
public class ImageGetRequest extends BaseRequest<ImageGetResponse> {

    public ImageGetRequest(String order_no, String token) {
        this.putBizData("order_no", order_no);
        this.putBizData("token", token);
    }

    @Override
    public String getMethod() {
        return "tjy.image.api.fetch";
    }
}
