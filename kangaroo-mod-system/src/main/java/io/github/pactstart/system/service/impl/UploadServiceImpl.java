package io.github.pactstart.system.service.impl;

import io.github.pactstart.biz.common.errorcode.ResponseCode;
import io.github.pactstart.biz.common.exception.ApplicationException;
import io.github.pactstart.biz.common.utils.BeanMapUtils;
import io.github.pactstart.biz.common.utils.SpringContextHolder;
import io.github.pactstart.oss.autoconfigure.OssClient;
import io.github.pactstart.oss.autoconfigure.OssConfig;
import io.github.pactstart.oss.autoconfigure.PostPolicyResponse;
import io.github.pactstart.sts.autoconfigure.StsClient;
import io.github.pactstart.sts.autoconfigure.StsResponse;
import io.github.pactstart.system.dto.UploadPathDto;
import io.github.pactstart.system.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;

@Slf4j
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private OssConfig ossConfig;

    @Autowired
    private OssClient ossClient;

    @Override
    public Map<String, Object> getOssSecurityToken(UploadPathDto uploadPathDto) {
        StsClient stsClient = (StsClient) SpringContextHolder.getBean("STS_oss");
        StsResponse stsResponse = null;
        try {
            stsResponse = stsClient.acquireToken();
        } catch (Exception e) {
            log.error("获取oss token失败", e);
            throw new ApplicationException(ResponseCode.SYSTEM_ERROR);
        }
        Map<String, Object> data = BeanMapUtils.beanToMap(stsResponse);
        data.put("endPoint", ossConfig.getEndPoint());
        data.put("bucket", ossConfig.getBucket());
        data.put("path", uploadPathDto.getPath());
        return data;
    }

    @Override
    public PostPolicyResponse getPostPolicy(UploadPathDto uploadPathDto) throws Exception {
        return ossClient.getPostPolicy(uploadPathDto.getPath());
    }

    @Override
    public String uploadFile(String key, InputStream inputStream) {
        return ossClient.uploadFile(key, inputStream);
    }
}
