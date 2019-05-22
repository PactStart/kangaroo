package io.github.pactstart.pay.alipay.request;

import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppPayRequest {

    private String appId;

    private String method = "alipay.trade.app.pay";

    private String format = "JSON";

    private String charset = "utf-8";

    private String signType = "RSA2";

    private String sign;

    private String timestamp;

    private String version = "1.0";

    private String notifyUrl;

    private String bizContent;

    private AppPayRequest(String appId, String notifyUrl, String bizContent) {
        this.appId = appId;
        this.notifyUrl = notifyUrl;
        this.bizContent = bizContent;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public String getOriginalStr() {
        String originalStr = new StringBuilder()
                .append("app_id=").append(appId).append("&")
                .append("biz_content=").append(bizContent).append("&")
                .append("charset=").append(charset).append("&")
                .append("format=").append(format).append("&")
                .append("method=").append(method).append("&")
                .append("notify_url=").append(notifyUrl).append("&")
                .append("sign_type=").append(signType).append("&")
                .append("timestamp=").append(timestamp).append("&")
                .append("version=").append(version).toString();
        return originalStr;
    }

    public String getEncodedStr() throws UnsupportedEncodingException {
        String originalStr = new StringBuilder()
                .append("app_id=").append(URLEncoder.encode(appId, charset)).append("&")
                .append("biz_content=").append(URLEncoder.encode(bizContent, charset)).append("&")
                .append("charset=").append(URLEncoder.encode(charset, charset)).append("&")
                .append("format=").append(URLEncoder.encode(format, charset)).append("&")
                .append("method=").append(URLEncoder.encode(method, charset)).append("&")
                .append("notify_url=").append(URLEncoder.encode(notifyUrl, charset)).append("&")
                .append("sign_type=").append(URLEncoder.encode(signType, charset)).append("&")
                .append("timestamp=").append(URLEncoder.encode(timestamp, charset)).append("&")
                .append("version=").append(URLEncoder.encode(version, charset)).append("&")
                .append("sign=").append(URLEncoder.encode(sign, charset)).toString();
        return originalStr;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public static class ExtendParams {

        private String sysServiceProviderId;
        private String needBuyerRealnamed;
        private String transMemo;
        private String hbFqNum;
        private String hbFqSellerPercent;

        private ExtendParams() {

        }

        public String getSysServiceProviderId() {
            return sysServiceProviderId;
        }

        public void setSysServiceProviderId(String sysServiceProviderId) {
            this.sysServiceProviderId = sysServiceProviderId;
        }

        public String getNeedBuyerRealnamed() {
            return needBuyerRealnamed;
        }

        public void setNeedBuyerRealnamed(String needBuyerRealnamed) {
            this.needBuyerRealnamed = needBuyerRealnamed;
        }

        public String getTransMemo() {
            return transMemo;
        }

        public void setTransMemo(String transMemo) {
            this.transMemo = transMemo;
        }

        public String getHbFqNum() {
            return hbFqNum;
        }

        public void setHbFqNum(String hbFqNum) {
            this.hbFqNum = hbFqNum;
        }

        public String getHbFqSellerPercent() {
            return hbFqSellerPercent;
        }

        public void setHbFqSellerPercent(String hbFqSellerPercent) {
            this.hbFqSellerPercent = hbFqSellerPercent;
        }

        public static class ExtendParamsBuilder {

            private String sysServiceProviderId;
            private String needBuyerRealnamed;
            private String transMemo;
            private String hbFqNum;
            private String hbFqSellerPercent;

            /**
             * 系统商编号，该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
             *
             * @param sysServiceProviderId 系统商编号
             * @return ExtendParamsBuilder
             */
            public ExtendParamsBuilder setSysServiceProviderId(String sysServiceProviderId) {
                this.sysServiceProviderId = sysServiceProviderId;
                return this;
            }

            /**
             * 是否发起实名校验
             * T：发起 F：不发起
             *
             * @param needBuyerRealnamed 是否发起实名校验
             * @return ExtendParamsBuilder
             */
            public ExtendParamsBuilder setNeedBuyerRealnamed(String needBuyerRealnamed) {
                this.needBuyerRealnamed = needBuyerRealnamed;
                return this;
            }

            /**
             * 账务备注
             * 注：该字段显示在离线账单的账务备注中
             *
             * @param trandsMemo 账务备注
             * @return ExtendParamsBuilder
             */
            public ExtendParamsBuilder setTransMemo(String trandsMemo) {
                this.transMemo = trandsMemo;
                return this;
            }

            /**
             * 花呗分期数（目前仅支持3、6、12）
             * 注：使用该参数需要仔细阅读“花呗分期接入文档”
             *
             * @param hbFqNum 花呗分期数
             * @return ExtendParamsBuilder
             */
            public ExtendParamsBuilder setHbFqNum(String hbFqNum) {
                this.hbFqNum = hbFqNum;
                return this;
            }

            /**
             * 卖家承担收费比例，商家承担手续费传入100，用户承担手续费传入0，仅支持传入100、0两种，其他比例暂不支持
             * 注：使用该参数需要仔细阅读“花呗分期接入文档”
             *
             * @param hbFqSellerPercent 卖家承担收费比例
             * @return ExtendParamsBuilder
             */
            public ExtendParamsBuilder setHbFqSellerPercent(String hbFqSellerPercent) {
                this.hbFqSellerPercent = hbFqSellerPercent;
                return this;
            }
        }
    }

    public static class AppPayRequestBuilder {
        //--------------------公共参数,必填--------------------
        private String appId;
        private String notifyUrl;
        //--------------------业务参数,必填--------------------
        private String subject;
        private String outTradeNo;
        private String totalAmount;
        private String productCode = "QUICK_MSECURITY_PAY";
        //--------------------业务参数，非必填--------------------
        private String timeoutExpress;
        private String body;
        private String goodsType;
        private String passbackParams;
        private String promoParams;
        private ExtendParams extendParams;
        private String enablePayChannels;
        private String disablePayChannels;
        private String storeId;

        /**
         * 设置支付宝分配给开发者的应用ID
         *
         * @param appId 应用ID
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setAppId(String appId) {
            this.appId = appId;
            return this;
        }

        /**
         * 设置支付宝服务器主动通知商户服务器里指定的页面http/https路径。建议商户使用https
         *
         * @param notifyUrl 支付宝服务器主动通知商户服务器里指定的页面http/https路径
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
            return this;
        }

        /**
         * 设置商品的标题/交易标题/订单标题/订单关键字等。
         *
         * @param subject 商品的标题
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        /**
         * 设置商户网站唯一订单号
         *
         * @param outTradeNo 户网站唯一订单号
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }

        /**
         * 设置订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
         *
         * @param totalAmount 订单总金额，单位为元，精确到小数点后两位
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        /**
         * 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
         * 该参数数值不接受小数点， 如 1.5h，可转换为 90m。注：若为空，则默认为15d。
         *
         * @param timeoutExpress 该笔订单允许的最晚付款时间
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setTimeoutExpress(String timeoutExpress) {
            this.timeoutExpress = timeoutExpress;
            return this;
        }

        /**
         * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
         *
         * @param body 对一笔交易的具体描述信息
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        /**
         * 商品主类型：0—虚拟类商品，1—实物类商品
         * 注：虚拟类商品不支持使用花呗渠道
         *
         * @param goodsType 商品主类型
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setGoodsType(String goodsType) {
            this.goodsType = goodsType;
            return this;
        }

        /**
         * 公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝
         *
         * @param passbackParams 公用回传参数
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setPassbackParams(String passbackParams) {
            this.passbackParams = passbackParams;
            return this;
        }

        /**
         * 优惠参数
         * 注：仅与支付宝协商后可用公用回传参数
         *
         * @param promoParams 优惠参数
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setPromoParams(String promoParams) {
            this.promoParams = promoParams;
            return this;
        }

        /**
         * 业务扩展参数
         *
         * @param extendParams 业务扩展参数
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setExtendParams(ExtendParams extendParams) {
            this.extendParams = extendParams;
            return this;
        }

        /**
         * 可用渠道，用户只能在指定渠道范围内支付当有多个渠道时用“,”分隔
         * 注：与disable_pay_channels互斥
         *
         * @param enablePayChannels 可用渠道
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setEnablePayChannels(String enablePayChannels) {
            this.enablePayChannels = enablePayChannels;
            return this;
        }

        /**
         * 禁用渠道，用户不可用指定渠道支付当有多个渠道时用“,”分隔
         * 注：与enable_pay_channels互斥
         *
         * @param disablePayChannels 禁用渠道
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setDisablePayChannels(String disablePayChannels) {
            this.disablePayChannels = disablePayChannels;
            return this;
        }

        /**
         * 商户门店编号。该参数用于请求参数中以区分各门店，非必传项。
         *
         * @param storeId 商户门店编号
         * @return AppPayRequestBuilder
         */
        public AppPayRequestBuilder setStoreId(String storeId) {
            this.storeId = storeId;
            return this;
        }

        public AppPayRequest build() {
            JSONObject bizContent = new JSONObject();
            bizContent.put("body", body);
            bizContent.put("subject", subject);
            bizContent.put("out_trade_no", outTradeNo);
            bizContent.put("total_amount", totalAmount);
            bizContent.put("timeout_express", timeoutExpress);
            bizContent.put("product_code", productCode);
            bizContent.put("goods_type", goodsType);
            bizContent.put("passback_params", passbackParams);
            bizContent.put("promo_params", promoParams);
            if (extendParams != null) {
                JSONObject extendParamsJSONObject = new JSONObject();
                extendParamsJSONObject.put("sys_service_provider_id", extendParams.getSysServiceProviderId());
                extendParamsJSONObject.put("needBuyerRealnamed", extendParams.getNeedBuyerRealnamed());
                extendParamsJSONObject.put("TRANS_MEMO", extendParams.getTransMemo());
                extendParamsJSONObject.put("hb_fq_num", extendParams.getHbFqNum());
                extendParamsJSONObject.put("hb_fq_seller_percent", extendParams.getHbFqSellerPercent());

                bizContent.put("extend_params", extendParamsJSONObject.toString());
            }
            bizContent.put("enable_pay_channels", enablePayChannels);
            bizContent.put("disable_pay_channels", disablePayChannels);
            bizContent.put("store_id", storeId);

            return new AppPayRequest(appId, notifyUrl, bizContent.toString());
        }
    }

}
