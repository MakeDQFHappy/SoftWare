package cn.tongji.study.controller;

import cn.tongji.study.dto.UserInfoDTO;
import cn.tongji.study.service.OssService;
import cn.tongji.study.service.PersonalInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("uploadImage")
    public ResponseEntity<Map<String,Object>>uploadImage(
            @RequestPart MultipartFile file
    ){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String image = ossService.uploadFile(file);
            map.put("url",image);
            return ResponseEntity.ok(map);
        }catch (Exception e){
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("updateBonusPoints")
    public ResponseEntity<Integer>updateBonusPoints(
            @RequestParam("changeNum") Integer changeNum
    ){
        try {
            return ResponseEntity.ok(personalInfoService.updateBonusPoints(changeNum));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("getUserInfo")
    public ResponseEntity<UserInfoDTO>getUserInfo(
            @RequestParam("userId") Long userId
    ){
        try {
            return ResponseEntity.ok(personalInfoService.getUserInfo(userId));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PutMapping("updateUserInfo")
    public ResponseEntity<String>updateUserInfo(
            @RequestBody Map<String,Object> data
    ){
        System.out.println(data);
        Long userId=Long.parseLong((String)data.get("userId"));
        String userName= (String) data.get("userName");
        String sex=(String)data.get("sex");
        Integer age= Integer.parseInt((String)data.get("age"));
        try {
            if(!personalInfoService.updateUserInfo(userId,userName,age,sex)){
                return ResponseEntity.status(403).body(null);
            }
            return ResponseEntity.ok("更改用户信息成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
}
