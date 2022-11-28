package cn.tongji.study.controller;

import cn.tongji.study.dto.AnswerDTO;
import cn.tongji.study.dto.QuestionDTO;
import cn.tongji.study.mapper.QuestionsMapper;
import cn.tongji.study.model.Answers;
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
    @GetMapping("getMyAnswer")
    public ResponseEntity<List<QuestionDTO>> getMyAnswer(){
        try {
            return ResponseEntity.ok(QAservice.getMyAnswer());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @PostMapping("askQuestion")
    public ResponseEntity<Questions>askQuestion(
            @RequestBody String content,
            @RequestParam(value = "header")String header,
            @RequestParam(value = "rewardpoints") Integer rewardpoints
    ){
        try {
            return ResponseEntity.ok(QAservice.askQuestion(content,header,rewardpoints));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @PostMapping("answerQuestion")
    public  ResponseEntity<Answers>answerquestion(
            @RequestBody String content,
            @RequestParam(value = "questionid") Long questionid
    )
    {
        try {
            return ResponseEntity.ok(QAservice.answerQuestion(questionid,content));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @GetMapping("getAnswer")
    public  ResponseEntity<List<AnswerDTO>>getAnswer(
            @RequestParam(value = "questionid") Long questionid
    )
    {
        try {
            return ResponseEntity.ok(QAservice.getAnswer(questionid));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @GetMapping("searchByQuestion")
    public ResponseEntity<List<QuestionDTO>> searchByQuestion(
            @RequestParam(value = "keyword")String keyword
    ){
        try {
            return ResponseEntity.ok(QAservice.searchByQuestion(keyword));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
}
