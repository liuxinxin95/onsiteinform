package com.cpy.onsiteinform.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * @author Carl
 * @ClassName UploadUtil 腾讯云上传文件
 * @Description
 * @date 2019-11-13 21:30
 **/
public class UploadUtil {

    private static String url = "https://onsiteimage.wangdamei.com/";

    public static String upload(MultipartFile file) {
        File localFile = null;
        try {
            localFile = File.createTempFile("temp", null);
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDKURAfxbqUu52mI5fVBdrrdATYQ4XHnY3";
        String secretKey = "LQEl47uQimcEcleGcgU1HGyPZT5RWKrB";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        //存储桶名称，格式：BucketName-APPID
        String bucketName = "onsiteinform-1252452432";
        String key = "image/" + System.currentTimeMillis() + ".png";
        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        // 指定要上传到 COS 上的路径
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        String etag = putObjectResult.getETag();
        String rtValue = url + key;
        cosClient.shutdown();
        return rtValue;
    }

//    public static void main(String[] args) {
//        File file = new File("tools/TreeUtil.java");
//        String upload = UploadUtil.upload(file);
//        System.out.println(upload);
//    }
}
