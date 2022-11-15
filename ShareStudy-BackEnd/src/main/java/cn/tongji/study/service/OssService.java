package cn.tongji.study.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author : 王晨
 * @Date : Created in 21:21 2022/11/14
 */
public interface OssService {
    String uploadFile(MultipartFile file);
}
