package com.aurora.strategy.impl;

import com.aurora.config.properties.QiniuConfigProperties;
import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service("qiniuUploadStrategyImpl")
public class QiniuUploadStrategyImpl extends AbstractUploadStrategyImpl {

    @Autowired
    private QiniuConfigProperties qiniuProperties;

    @Override
    public Boolean exists(String filePath) {
        // 七牛云没有判断文件是否存在的sdk
        return false;
    }

    @SneakyThrows
    @Override
    public void upload(String path, String fileName, InputStream inputStream) {
        // zone0华东区域,zone1是华北区域,zone2是华南区域
        Configuration cfg = new Configuration(Region.region1());
        UploadManager uploadManager = new UploadManager(cfg);
        // 生成上传凭证，然后准备上传
        Auth auth = Auth.create(qiniuProperties.getAccessKey(), qiniuProperties.getSecretKey());
        String uploadToken =auth.uploadToken(qiniuProperties.getBucketName());
        // key默认为文件的hash值，前面加上文件夹名即可上传文件到桶里指定的文件夹里
        Response response = uploadManager.put(inputStream, path+fileName, uploadToken, null, null);
        // 解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        qiniuProperties.setPath(putRet.key);
    }

    @Override
    public String getFileAccessUrl(String filePath) {
        return qiniuProperties.getUrl() + qiniuProperties.getPath();
    }

}
