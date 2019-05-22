package io.github.pactstart.pay.pipay.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderQueryResponse {

    private String resultCode;

    private String processorResponseCode;

    private String amount;

    private String currency;

    private String processorID;

    public boolean isSuccess() {
        return "0000".equals(resultCode);
    }
}
