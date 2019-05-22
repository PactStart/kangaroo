package io.github.pactstart.simple.web.framework.encrypt.algorithm;

import io.github.pactstart.simple.web.framework.encrypt.utils.AesEncryptUtils;

public class AesEncryptAlgorithm implements EncryptAlgorithm {

    @Override
    public String encrypt(String content, String encryptKey) throws Exception {
        return AesEncryptUtils.aesEncrypt(content, encryptKey);
    }

    @Override
    public String decrypt(String encryptStr, String decryptKey) throws Exception {
        return AesEncryptUtils.aesDecrypt(encryptStr, decryptKey);
    }
}
