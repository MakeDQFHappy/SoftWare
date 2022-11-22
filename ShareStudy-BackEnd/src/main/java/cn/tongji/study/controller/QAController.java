package cn.tongji.study.controller;

import cn.tongji.study.dto.QuestionDTO;
import cn.tongji.study.mapper.QuestionsMapper;
import cn.tongji.study.model.FriendPrivateMessages;
import cn.tongji.study.model.Questions;
import cn.tongji.study.service.OssService;
import cn.tongji.study.service.QAService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/QA")
public class QAController {
    @Resource
    QAService QAservice;
    @Resource
    OssService ossService;
    @GetMapping("getMyQuestion")
    public ResponseEntity<List<QuestionDTO>> getMyQuestion(){
        try {
            return ResponseEntity.ok(QAservice.getMyQuestion());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @PostMapping("askQuestion")
    public ResponseEntity<Questions>askQuestion(
            @RequestBody String content
    ){
        try {
            return ResponseEntity.ok(QAservice.askQuestion(content));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
}
