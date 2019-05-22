package io.github.pactstart.weixin.mp.response.autoreply;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.vo.AutoReply;
import io.github.pactstart.weixin.mp.vo.KeyWordReply;
import io.github.pactstart.weixin.mp.vo.Reply;

/**
 * Created by Di.Lei on 2017/8/3.
 */
public class AutoReplyInfoGetResponse extends JsonResponse {

    private AutoReply autoReply;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.autoReply = new AutoReply();
        autoReply.setOpenAddFriendReply(jsonObject.getInteger("is_add_friend_reply_open") == 1);
        autoReply.setOpenAutoReply(jsonObject.getInteger("is_autoreply_open") == 1);
        JSONObject fa = jsonObject.getJSONObject("add_friend_autoreply_info");
        if (fa != null) {
            autoReply.setAddFriendReplyInfo(fa.toJavaObject(Reply.class));
        }
        JSONObject da = jsonObject.getJSONObject("message_default_autoreply_info");
        if (da != null) {
            autoReply.setDefaultAutoReplyInfo(da.toJavaObject(Reply.class));
        }
        JSONObject ka = jsonObject.getJSONObject("keyword_autoreply_info");
        if (ka != null) {
            autoReply.setKeyWordReplyInfoList(JSON.parseArray(ka.getJSONArray("list").toJSONString(), KeyWordReply.class));
        }
    }

    public AutoReply getAutoReply() {
        return autoReply;
    }

    public void setAutoReply(AutoReply autoReply) {
        this.autoReply = autoReply;
    }
}
