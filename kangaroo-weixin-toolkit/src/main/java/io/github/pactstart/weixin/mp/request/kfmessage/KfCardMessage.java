package io.github.pactstart.weixin.mp.request.kfmessage;

import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.DefaultJsonResponse;
import io.github.pactstart.weixin.mp.enums.KfMessageType;

/**
 * 特别注意客服消息接口投放卡券仅支持非自定义Code码和导入code模式的卡券的卡券
 * Created by Di.Lei on 2017/8/2.
 */
public class KfCardMessage extends KfMessageRequest<DefaultJsonResponse> {

    private String cardId;

    @Override
    public KfMessageType getMsgType() {
        return KfMessageType.wxcard;
    }

    @Override
    public JSONObject getContent() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("card_id", cardId);
        return jsonObject;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
