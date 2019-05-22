package io.github.pactstart.weixin.open.response.auth;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;

import java.util.Arrays;

public class ComponentGetAuthorizerInfoResponse extends JsonResponse {

    /**
     * 授权方昵称
     */
    private String nickName;
    /**
     * 授权方头像
     */
    private String headImg;
    /**
     * 授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
     */
    private int serviceTypeInfoId;
    /**
     * 授权方认证类型，-1代表未认证，0代表微信认证，
     * 1代表新浪微博认证，2代表腾讯微博认证，
     * 3代表已资质认证通过但还未通过名称认证，
     * 4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，
     * 5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
     */
    private int verifyTypeInfoId;
    /**
     * 授权方公众号的原始ID
     */
    private String userName;
    /**
     * 授权方公众号所设置的微信号，可能为空
     */
    private String alias;
    /**
     * 是否开通微信门店功能
     */
    private boolean isOpenStore;
    /**
     * 是否开通微信扫商品功能
     */
    private boolean isOpenScan;
    /**
     * 是否开通微信支付功能
     */
    private boolean isOpenPay;
    /**
     * 是否开通微信卡券功能
     */
    private boolean isOpenCard;
    /**
     * 是否开通微信摇一摇功能
     */
    private boolean isOpenShake;

    /**
     * 账号介绍
     */
    private String signature;

    private String miniProgramInfo;

    /**
     * 授权方appid
     */
    private String appId;

    /**
     * 二维码图片的URL，开发者最好自行也进行保存
     */
    private String qrcodeUrl;
    /**
     * 公众号授权给开发者的权限集列表，ID为1到15时分别代表：
     * 1消息管理权限、2用户管理权限、3帐号服务权限、4网页服务权限、5微信小店权限
     * 6微信多客服权限、7群发与通知权限、8微信卡券权限、9微信扫一扫权限、10微信连WIFI权限
     * 11素材管理权限、12微信摇周边权限、13微信门店权限、14微信支付权限、15自定义菜单权限
     */
    private int[] funcIds;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        //基本信息
        JSONObject authorizerNode = jsonObject.getJSONObject("authorizer_info");
        this.nickName = authorizerNode.getString("nick_name");
        this.headImg = authorizerNode.getString("head_img");
        this.serviceTypeInfoId = authorizerNode.getJSONObject("service_type_info").getInteger("id");
        this.verifyTypeInfoId = authorizerNode.getJSONObject("verify_type_info").getInteger("id");
        this.userName = authorizerNode.getString("user_name");
        this.alias = authorizerNode.getString("alias");
        //功能开通情况
        JSONObject businessNode = authorizerNode.getJSONObject("business_info");
        this.isOpenStore = businessNode.getInteger("open_store") == 1;
        this.isOpenScan = businessNode.getInteger("open_scan") == 1;
        this.isOpenPay = businessNode.getInteger("open_pay") == 1;
        this.isOpenCard = businessNode.getInteger("open_card") == 1;
        this.isOpenShake = businessNode.getInteger("open_shake") == 1;
        //二维码
        this.qrcodeUrl = authorizerNode.getString("qrcode_url");
        this.signature = authorizerNode.getString("signature");
        //小程序独有
        if (authorizerNode.containsKey("MiniProgramInfo")) {
            this.miniProgramInfo = authorizerNode.getString("MiniProgramInfo");
        }
        //授权信息
        JSONObject authorizationNode = jsonObject.getJSONObject("authorization_info");
        this.appId = authorizationNode.getString("authorizer_appid");
        JSONArray funcNode = authorizationNode.getJSONArray("func_info");
        this.funcIds = new int[funcNode.size()];
        for (int i = 0; i < funcNode.size(); i++) {
            int funcId = funcNode.getJSONObject(i).getJSONObject("funcscope_category").getInteger("id");
            this.funcIds[i] = funcId;
        }
        Arrays.sort(this.funcIds);
    }

    public String getNickName() {
        return nickName;
    }


    public String getHeadImg() {
        return headImg;
    }


    public int getServiceTypeInfoId() {
        return serviceTypeInfoId;
    }


    public int getVerifyTypeInfoId() {
        return verifyTypeInfoId;
    }


    public String getUserName() {
        return userName;
    }


    public String getAlias() {
        return alias;
    }


    public boolean isOpenStore() {
        return isOpenStore;
    }


    public boolean isOpenScan() {
        return isOpenScan;
    }


    public boolean isOpenPay() {
        return isOpenPay;
    }


    public boolean isOpenCard() {
        return isOpenCard;
    }


    public boolean isOpenShake() {
        return isOpenShake;
    }


    public String getAppId() {
        return appId;
    }


    public String getQrcodeUrl() {
        return qrcodeUrl;
    }


    public int[] getFuncIds() {
        return funcIds;
    }


}
