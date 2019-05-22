package io.github.pactstart.weixin.mp.response.kfaccount;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.vo.KfAccount;

import java.util.List;

/**
 * Created by Di.Lei on 2017/8/2.
 */
public class KfAccountResponse extends JsonResponse {

    private List<KfAccount> kfAccountList;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        JSONArray arr = jsonObject.getJSONArray("kf_list");
        this.kfAccountList = JSONObject.parseArray(arr.toJSONString(), KfAccount.class);
    }

    public List<KfAccount> getKfAccountList() {
        return kfAccountList;
    }

    public void setKfAccountList(List<KfAccount> kfAccountList) {
        this.kfAccountList = kfAccountList;
    }
}
