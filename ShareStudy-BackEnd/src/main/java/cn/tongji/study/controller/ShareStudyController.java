package cn.tongji.study.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/**
 * @Author : 王晨
 * @Date : Created in 23:25 2022/12/21
 */
@RestController
@RequestMapping("api/share")
public class ShareStudyController {

    @Resource
    RestTemplate restTemplate;

    @GetMapping("getAllNotes")
    public ResponseEntity<Object> getAllNotes(
            @RequestParam(value = "page") Integer page
    ){
        try {
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://1.15.47.174:8000/get_all_notes?userID={1}&page={2}", Object.class,myId,page);
            Object body=forEntity.getBody();
            return ResponseEntity.ok(body);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("getUserNotes")
    public ResponseEntity<Object> getUserNotes(
            @RequestParam(value = "page") Integer page
    ){
        try {
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://1.15.47.174:8000/get_user_notes?userID={1}&page={2}", Object.class,myId,page);
            Object body=forEntity.getBody();
            return ResponseEntity.ok(body);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("getUserCollections")
    public ResponseEntity<Object> getUserCollections(
            @RequestParam(value = "page") Integer page
    ){
        try {
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://1.15.47.174:8000/get_user_collections?userID={1}&page={2}", Object.class,myId,page);
            Object body=forEntity.getBody();
            return ResponseEntity.ok(body);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("searchNotes")
    public ResponseEntity<Object> searchNotes(
            @RequestParam(value = "pattern") String pattern
    ){
        try {
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://1.15.47.174:8000/search_notes?userID={1}&pattern={2}", Object.class,myId,pattern);
            Object body=forEntity.getBody();
            return ResponseEntity.ok(body);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("getComments")
    public ResponseEntity<Object> getComments(
            @RequestParam(value = "noteID") Long noteID
    ){
        try {
            ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://1.15.47.174:8000/get_comments?noteID={1}", Object.class,noteID);
            Object body=forEntity.getBody();
            return ResponseEntity.ok(body);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("download")
    public ResponseEntity<Object> download(
            @RequestParam(value = "noteID") Long noteID
    ){
        try {
            ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://1.15.47.174:8000/download?noteID={1}", Object.class,noteID);
            Object body=forEntity.getBody();
            return ResponseEntity.ok(body);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("getLikesInfo")
    public ResponseEntity<Object> getLikesInfo(
            @RequestParam(value = "noteID") Long noteID,
            @RequestParam(value = "targetID") Long targetID
    ){
        try {
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://1.15.47.174:8000/get_likes_info?noteID={1}&userID={2}&targetID={3}", Object.class,noteID,myId,targetID);
            Object body=forEntity.getBody();
            return ResponseEntity.ok(body);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("getCollectionsInfo")
    public ResponseEntity<Object> getCollectionsInfo(
            @RequestParam(value = "noteID") Long noteID,
            @RequestParam(value = "targetID") Long targetID
    ){
        try {
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://1.15.47.174:8000/get_collections_info?noteID={1}&userID={2}&targetID={3}", Object.class,noteID,myId,targetID);
            Object body=forEntity.getBody();
            return ResponseEntity.ok(body);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("testPicture")
    public ResponseEntity<Object> testPicture(
            @RequestBody String base64
    ){
        try {
            String url = "http://1.15.47.174:8000/test_picture";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap map = new LinkedMultiValueMap();
            map.add("content",base64);
            HttpEntity requestBody = new HttpEntity(map, headers);
            ResponseEntity<String> objectResponseEntity = restTemplate.postForEntity(url, requestBody, String.class);

            System.out.println(objectResponseEntity.getBody());
            return ResponseEntity.ok(objectResponseEntity.getBody());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("chargePoints")
    public ResponseEntity<Object> chargePoints(
            @RequestBody Map<String,Object> mp
    ){
        try {
            String url = "http://1.15.47.174:8000/chargePoints";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            MultiValueMap map = new LinkedMultiValueMap();
            map.add("buyerID",myId);
            map.add("sellerID",mp.get("sellerID"));
            map.add("noteID",mp.get("noteID"));
            map.add("points",mp.get("points"));
            HttpEntity requestBody = new HttpEntity(map, headers);
            ResponseEntity<String> objectResponseEntity = restTemplate.postForEntity(url, requestBody, String.class);

            System.out.println(objectResponseEntity.getBody());
            return ResponseEntity.ok(objectResponseEntity.getBody());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("upload")
    public ResponseEntity<Object> upload(
            @RequestBody Map<String,Object> mp
    ){
        try {
            String url = "http://1.15.47.174:8000/upload";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap map = new LinkedMultiValueMap();
            map.add("title",mp.get("title"));
            map.add("content",mp.get("content"));
            map.add("sharerID",mp.get("shareID"));
            map.add("points",mp.get("points"));
            System.out.println(mp.get("tags").getClass());
            ArrayList<String> al=new ArrayList<>();
            al=(ArrayList<String>) mp.get("tags");
            System.out.println(al);
            for (String a:al) {
                map.add("tags",a);
            }
            System.out.println(map.get("tags"));
            HttpEntity requestBody = new HttpEntity(map, headers);
            ResponseEntity<String> objectResponseEntity = restTemplate.postForEntity(url, requestBody, String.class);

            System.out.println(objectResponseEntity.getBody());
            return ResponseEntity.ok(objectResponseEntity.getBody());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("makeComment")
    public ResponseEntity<Object> makeComment(
            @RequestBody Map<String,Object> mp
    ){
        try {
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            String url = "http://1.15.47.174:8000/make_comment";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap map = new LinkedMultiValueMap();
            map.add("targetID",mp.get("targetID"));
            map.add("content",mp.get("content"));
            map.add("userID",myId);
            HttpEntity requestBody = new HttpEntity(map, headers);
            ResponseEntity<String> objectResponseEntity = restTemplate.postForEntity(url, requestBody, String.class);

            System.out.println(objectResponseEntity.getBody());
            return ResponseEntity.ok(objectResponseEntity.getBody());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("like")
    public ResponseEntity<Object> like(
            @RequestBody Map<String,Object> mp
    ){
        try {
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            String url = "http://1.15.47.174:8000/like";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap map = new LinkedMultiValueMap();
            map.add("targetID",mp.get("targetID"));
            map.add("userID",myId);
            HttpEntity requestBody = new HttpEntity(map, headers);
            ResponseEntity<String> objectResponseEntity = restTemplate.postForEntity(url, requestBody, String.class);

            System.out.println(objectResponseEntity.getBody());
            return ResponseEntity.ok(objectResponseEntity.getBody());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("cancelLike")
    public ResponseEntity<Object> cancelLike(
            @RequestBody Map<String,Object> mp
    ){
        try {
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            String url = "http://1.15.47.174:8000/cancel_like";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap map = new LinkedMultiValueMap();
            map.add("targetID",mp.get("targetID"));
            map.add("userID",myId);
            HttpEntity requestBody = new HttpEntity(map, headers);
            ResponseEntity<String> objectResponseEntity = restTemplate.postForEntity(url, requestBody, String.class);

            System.out.println(objectResponseEntity.getBody());
            return ResponseEntity.ok(objectResponseEntity.getBody());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("collect")
    public ResponseEntity<Object> collect(
            @RequestBody Map<String,Object> mp
    ){
        try {
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            String url = "http://1.15.47.174:8000/collect";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap map = new LinkedMultiValueMap();
            map.add("targetID",mp.get("targetID"));
            map.add("userID",myId);
            HttpEntity requestBody = new HttpEntity(map, headers);
            ResponseEntity<String> objectResponseEntity = restTemplate.postForEntity(url, requestBody, String.class);

            System.out.println(objectResponseEntity.getBody());
            return ResponseEntity.ok(objectResponseEntity.getBody());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("cancelCollect")
    public ResponseEntity<Object> cancelCollect(
            @RequestBody Map<String,Object> mp
    ){
        try {
            Object loginId = StpUtil.getLoginId();
            Long myId=Long.parseLong((String)loginId);
            String url = "http://1.15.47.174:8000/cancel_collect";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap map = new LinkedMultiValueMap();
            map.add("targetID",mp.get("targetID"));
            map.add("userID",myId);
            HttpEntity requestBody = new HttpEntity(map, headers);
            ResponseEntity<String> objectResponseEntity = restTemplate.postForEntity(url, requestBody, String.class);

            System.out.println(objectResponseEntity.getBody());
            return ResponseEntity.ok(objectResponseEntity.getBody());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
}
