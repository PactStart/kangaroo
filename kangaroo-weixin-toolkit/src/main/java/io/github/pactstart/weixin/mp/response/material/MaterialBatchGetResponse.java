package io.github.pactstart.weixin.mp.response.material;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.vo.NewsMaterial;
import io.github.pactstart.weixin.mp.vo.NonNewsMaterial;

import java.util.List;

/**
 * Created by Di.Lei on 2017/8/5.
 */
public class MaterialBatchGetResponse extends JsonResponse {

    private int totalCount;

    private int itemCount;

    private List<NewsMaterial> newsMaterialList;

    private List<NonNewsMaterial> nonNewsMaterialList;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.totalCount = jsonObject.getInteger("total_count");
        this.itemCount = jsonObject.getInteger("item_count");
        JSONArray array = jsonObject.getJSONArray("item");
        boolean isNews = false;
        if (array != null && array.size() > 0) {
            isNews = array.getJSONObject(0).getJSONObject("content") != null;
        }
        if (isNews) {
            this.newsMaterialList = JSON.parseArray(array.toJSONString(), NewsMaterial.class);
        } else {
            this.nonNewsMaterialList = JSON.parseArray(array.toJSONString(), NonNewsMaterial.class);
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public List<NewsMaterial> getNewsMaterialList() {
        return newsMaterialList;
    }

    public void setNewsMaterialList(List<NewsMaterial> newsMaterialList) {
        this.newsMaterialList = newsMaterialList;
    }

    public List<NonNewsMaterial> getNonNewsMaterialList() {
        return nonNewsMaterialList;
    }

    public void setNonNewsMaterialList(List<NonNewsMaterial> nonNewsMaterialList) {
        this.nonNewsMaterialList = nonNewsMaterialList;
    }
}
