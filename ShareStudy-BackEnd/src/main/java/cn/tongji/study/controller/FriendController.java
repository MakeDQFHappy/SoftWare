package cn.tongji.study.controller;

import cn.tongji.study.dto.MyFriendDTO;
import cn.tongji.study.dto.ReceiveFriendReqDTO;
import cn.tongji.study.dto.SearchUserDTO;
import cn.tongji.study.model.FriendApplications;
import cn.tongji.study.service.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author : 王晨
 * @Date : Created in 21:56 2022/11/17
 */
@RestController
@RequestMapping("api/friend")
public class FriendController {
    @Resource
    FriendService friendService;

    @PostMapping("sendReq")
    public ResponseEntity<String> sendFriendReq(
            @RequestParam(value = "receiverId") Long receiverId,
            @RequestParam(value = "introduction") String introduction
    ){
        try {
            if(friendService.checkFriend(receiverId)){
                return ResponseEntity.status(301).body("已经是好友");
            }
            friendService.sendFriendRequest(introduction,receiverId);
            return ResponseEntity.ok("发送成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body("发送失败");
        }
    }

    @GetMapping("getReq")
    public ResponseEntity<List<ReceiveFriendReqDTO>> getFriendReq(){
        try {
            return ResponseEntity.ok(friendService.getFriendRequest());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("deleteReq")
    public ResponseEntity<String> deleteReq(
            @RequestParam(value = "applicationId") Long applicationId
    ){
        try {
            friendService.deleteRequest(applicationId);
            return ResponseEntity.ok("ok");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body("exception");
        }
    }

    @GetMapping("getMyReq")
    public ResponseEntity<List<ReceiveFriendReqDTO>> getMyReq(){
        try {
            return ResponseEntity.ok(friendService.getMyRequest());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("agreeReq")
    public ResponseEntity<String> agreeFriendReq(
            @RequestParam(value = "applicationId") Long applicationId
    ){
        try {
            friendService.agreeFriendRequest(applicationId);
            return ResponseEntity.ok("ok");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body("exception");
        }
    }

    @PostMapping("reject")
    public ResponseEntity<String> rejectFriendReq(
            @RequestParam(value = "applicationId") Long applicationId
    ){
        try {
            friendService.rejectFriendRequest(applicationId);
            return ResponseEntity.ok("ok");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body("exception");
        }
    }

    @GetMapping("searchUser")
    public ResponseEntity<List<SearchUserDTO>> searchUser(
            @RequestParam(value = "searchInfo") String searchInfo
    ){
        if(searchInfo.equals("")){
            return ResponseEntity.status(402).body(null);
        }
        try {
            return ResponseEntity.ok(friendService.searchUser(searchInfo));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("recommandFriends")
    public ResponseEntity<List<SearchUserDTO>> recommandFriends(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){
        try {
            return ResponseEntity.ok(friendService.recommandFriends(page,size));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("getMyFriends")
    public ResponseEntity<List<MyFriendDTO>> getMyFriends(){
        try {
            return ResponseEntity.ok(friendService.getMyFriend());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("removeFriend")
    public ResponseEntity<String> removeFriend(
            @RequestParam(value = "friendKey") Long friendKey
    ){
        try {
            friendService.removeFriend(friendKey);
            return ResponseEntity.ok("ok");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body("exception");
        }
    }
}
