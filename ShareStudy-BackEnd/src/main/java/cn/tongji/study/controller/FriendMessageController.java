package cn.tongji.study.controller;

import cn.tongji.study.model.FriendPrivateMessages;
import cn.tongji.study.service.FriendMessageService;
import cn.tongji.study.service.OssService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author : 王晨
 * @Date : Created in 20:22 2022/11/18
 */
@RestController
@RequestMapping("api/friendMessage")
public class FriendMessageController {
    @Resource
    OssService ossService;

    @Resource
    FriendMessageService friendMessageService;

    @PostMapping("sendTextMessage")
    public ResponseEntity<FriendPrivateMessages>sendTextMessage(
            @RequestParam(value = "receiverId") Long receiverId,
            @RequestBody String message
    ){
        try {
            return ResponseEntity.ok(friendMessageService.sendMsg(message,receiverId,1));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping(value = "sendFileMessage",headers=("content-type=multipart/*"))
    public ResponseEntity<FriendPrivateMessages>sendFileMessage(
            @RequestParam(value = "receiverId") Long receiverId,
            @RequestPart(value = "file")  MultipartFile file
    ){
        try {
            System.out.println(file.getSize());
            Integer type=10;
            String suffix=file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1];
            System.out.println(suffix);
            if(suffix.equalsIgnoreCase("png")||suffix.equalsIgnoreCase("jpg")||suffix.equalsIgnoreCase("jpeg")){
                type=3;
            }
            else if(suffix.equalsIgnoreCase("pdf")){
                type=4;
            }
            else if(suffix.equalsIgnoreCase("doc")||suffix.equalsIgnoreCase("docx")){
                type=5;
            }
            else if(suffix.equalsIgnoreCase("txt")){
                type=6;
            }
            else if(suffix.equalsIgnoreCase("xls")||suffix.equalsIgnoreCase("xlsx")){
                type=7;
            }
            else if(suffix.equalsIgnoreCase("ppt")||suffix.equalsIgnoreCase("pptx")){
                type=8;
            }
            else if(suffix.equalsIgnoreCase("zip")){
                type=9;
            }
            String url = ossService.uploadFile(file);
            return ResponseEntity.ok(friendMessageService.sendMsg(url,receiverId,type));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("sendAudioMessage")
    public ResponseEntity<FriendPrivateMessages>sendAudioMessage(
            @RequestParam(value = "receiverId") Long receiverId,
            @RequestPart(value = "file")  MultipartFile file
    ){
        try {
            String url=ossService.uploadFile(file);
            return ResponseEntity.ok(friendMessageService.sendMsg(url,receiverId,2));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("getMessage")
    public ResponseEntity<List<FriendPrivateMessages>> getMessage(
            @RequestParam(value = "receiverId") Long receiverId
    ){
        try {
            return ResponseEntity.ok(friendMessageService.getMsg(receiverId));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("readMsg")
    public ResponseEntity<String> readMsg(
            @RequestParam(value = "senderId") Long senderId
    ){
        try {
            friendMessageService.readMsg(senderId);
            return ResponseEntity.ok("ok");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body("exception");
        }
    }


}
