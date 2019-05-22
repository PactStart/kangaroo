package io.github.pactstart.juhe.service.impl;

import io.github.pactstart.juhe.client.JuheOPClient;
import io.github.pactstart.juhe.client.JuheSilkClient;
import io.github.pactstart.juhe.client.JuheVClient;
import io.github.pactstart.juhe.request.JuheBankcardSilkRequest;
import io.github.pactstart.juhe.request.JuheIdcardRequest;
import io.github.pactstart.juhe.request.JuheVerifyBankCard4Request;
import io.github.pactstart.juhe.request.JuheVerifyBankCardRequest;
import io.github.pactstart.juhe.response.JuheBankcardSilkResponse;
import io.github.pactstart.juhe.response.JuheIdcardResponse;
import io.github.pactstart.juhe.response.JuheVerifyBankCard4Response;
import io.github.pactstart.juhe.response.JuheVerifyBankCardResponse;
import io.github.pactstart.juhe.service.JuheService;

public class JuheServiceImpl implements JuheService {

    private JuheOPClient juheOPClient = new JuheOPClient();

    private JuheVClient juheVClient = new JuheVClient();
    ;

    private JuheSilkClient juheSilkClient = new JuheSilkClient();

    @Override
    public JuheIdcardResponse checkIdcard(JuheIdcardRequest request) {
        return juheOPClient.execute(request);
    }

    @Override
    public JuheVerifyBankCardResponse checkBankName(JuheVerifyBankCardRequest request) {
        return juheVClient.execute(request);
    }

    @Override
    public JuheVerifyBankCard4Response checkBankName4(JuheVerifyBankCard4Request request) {
        return juheVClient.execute(request);
    }

    @Override
    public JuheBankcardSilkResponse checkBankcardSilk(JuheBankcardSilkRequest request) {
        return juheSilkClient.execute(request);
    }
}
