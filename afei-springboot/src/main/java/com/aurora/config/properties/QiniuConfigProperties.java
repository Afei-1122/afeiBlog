package com.aurora.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author aFei
 * 七牛云配置属性
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "upload.qiniu")
public class QiniuConfigProperties {

    /**
     * AccessKey
     */
    private String accessKey;
    /**
     * SecretKey
     */
    private String secretKey;
    /**
     * 存储空间名
     */
    private String bucketName;
    /**
     * 外链地址
     */
    private String url;
    /**
     * 路径
     */
    private String path;
}
