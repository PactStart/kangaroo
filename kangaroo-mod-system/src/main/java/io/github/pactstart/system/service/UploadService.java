package io.github.pactstart.system.service;

import io.github.pactstart.oss.autoconfigure.PostPolicyResponse;
import io.github.pactstart.system.dto.UploadPathDto;

import java.io.InputStream;
import java.util.Map;


public interface UploadService {
    /**
     * 获取上传凭证
     *
     * @param uploadPathDto
     * @return
     */
    Map<String, Object> getOssSecurityToken(UploadPathDto uploadPathDto);

    /**
     * 获取web直传policy
     *
     * @param uploadPathDto
     * @return
     */
    PostPolicyResponse getPostPolicy(UploadPathDto uploadPathDto) throws Exception;

    /**
     * 上传文件
     *
     * @param key
     * @param inputStream
     * @return
     */
    String uploadFile(String key, InputStream inputStream);
}
