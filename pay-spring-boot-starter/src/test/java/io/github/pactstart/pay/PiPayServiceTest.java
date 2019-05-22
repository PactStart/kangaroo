package io.github.pactstart.pay;

import io.github.pactstart.commonutils.JsonUtils;
import io.github.pactstart.pay.pipay.PiPayService;
import io.github.pactstart.pay.pipay.autoconfigure.PiPayConfig;
import io.github.pactstart.pay.pipay.request.PagePayRequest;
import io.github.pactstart.pay.pipay.response.OrderQueryResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PiPayServiceTest {

    private PiPayService piPayService;

    //    @Before
    public void init() throws Exception {
        PiPayConfig piPayConfig = new PiPayConfig();
        piPayConfig.setMid("102265");
        piPayConfig.setSid("5109");
        piPayConfig.setDid("7464");
        piPayConfig.setCurrency("USD");
        piPayConfig.setTransactionUrl("https://onlinepayment-test.pipay.com/starttransaction");
        piPayConfig.setVerifyUrl("https://onlinepayment-test.pipay.com/rest-api/verifyTransaction");
        piPayService = new PiPayService(piPayConfig);
    }

    //    @Test
    public void testGetFormStr() {
        Map<String, String> extPrams = new HashMap<>();
        extPrams.put("unifiedOrderNo", UUID.randomUUID().toString().replace("-", ""));
        PagePayRequest pagePayRequest = PagePayRequest.builder().orderid(UUID.randomUUID().toString().replace("-", ""))
                .orderAmount("1.10").orderDesc("测试订单").cancelSeconds(600).extParams(extPrams).build();
        String formStr = piPayService.getFormStr(pagePayRequest);
        System.out.println(formStr);
    }

    //    @Test
    public void testQueryOrder() throws Exception {
        long start = System.currentTimeMillis();
        OrderQueryResponse orderQueryResponse = piPayService.orderQuery("211048246890308702208", null);
        System.out.println(JsonUtils.obj2String(orderQueryResponse));
        System.out.println(System.currentTimeMillis() - start);
    }
}
