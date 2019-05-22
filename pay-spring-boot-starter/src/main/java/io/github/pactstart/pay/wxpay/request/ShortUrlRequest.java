package io.github.pactstart.pay.wxpay.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Getter
@Setter
public class ShortUrlRequest {

    /**
     * 需要转换的URL，签名用原串，传输需URLencode
     */
    @NotNull(message = "URL链接long_url不能为空")
    private String long_url;

    public ShortUrlRequest(String long_url) throws UnsupportedEncodingException {
        this.long_url = URLEncoder.encode(long_url, "utf-8");
    }
}
