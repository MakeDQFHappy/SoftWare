package cn.tongji.study.controller;

import cn.tongji.study.service.OssService;
import cn.tongji.study.service.PersonalInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Author : 王晨
 * @Date : Created in 19:09 2022/11/26
 */
@RestController
@RequestMapping("api/personalInfo")
public class PersonalInfoController {
    @Resource
    OssService ossService;

    @Resource
    PersonalInfoService personalInfoService;

    @PostMapping("updateAvatar")
    public ResponseEntity<String>updateAvatar(
            @RequestParam("oldAvatar") String oldAvatar,
            @RequestPart MultipartFile file
    ){
        try {
            String newAvatar = ossService.uploadFile(file);
            personalInfoService.updateAvatar(newAvatar);
            ossService.deleteFile(oldAvatar);
            return ResponseEntity.ok(newAvatar);
        }catch (Exception e){
            return ResponseEntity.status(401).body("更换头像失败");
        }


    }
}
