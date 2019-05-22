package io.github.pactstart.juhe.service;

import io.github.pactstart.juhe.request.JuheBankcardSilkRequest;
import io.github.pactstart.juhe.request.JuheIdcardRequest;
import io.github.pactstart.juhe.request.JuheVerifyBankCard4Request;
import io.github.pactstart.juhe.request.JuheVerifyBankCardRequest;
import io.github.pactstart.juhe.response.JuheBankcardSilkResponse;
import io.github.pactstart.juhe.response.JuheIdcardResponse;
import io.github.pactstart.juhe.response.JuheVerifyBankCard4Response;
import io.github.pactstart.juhe.response.JuheVerifyBankCardResponse;

public interface JuheService {
    /**
     * 身份证实名认证
     *
     * @param request
     * @return
     */
    JuheIdcardResponse checkIdcard(JuheIdcardRequest request);

    /**
     * 姓名和银行卡校验
     *
     * @param request
     * @return
     */

    JuheVerifyBankCardResponse checkBankName(JuheVerifyBankCardRequest request);

    /**
     * 银行卡四元素校验
     *
     * @param request
     * @return
     */
    JuheVerifyBankCard4Response checkBankName4(JuheVerifyBankCard4Request request);

    /**
     * 校验银行卡类型
     *
     * @param request
     * @return
     */
    JuheBankcardSilkResponse checkBankcardSilk(JuheBankcardSilkRequest request);
}
