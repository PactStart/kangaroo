package io.github.pactstart.simple.web.framework.encrypt.algorithm;

public interface EncryptAlgorithm {

    /**
     * 加密
     *
     * @param content    待加密的内容
     * @param encryptKey 加密key
     * @return 加密后的内容
     * @throws Exception 异常
     */
    String encrypt(String content, String encryptKey) throws Exception;

    /**
     * 解密
     *
     * @param encryptStr 待解密内容
     * @param decryptKey 解密key
     * @return 解密后的内容
     * @throws Exception 异常
     */
    String decrypt(String encryptStr, String decryptKey) throws Exception;

}
