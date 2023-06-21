package cn.tongji.study.controller;

import cn.tongji.study.dto.*;
import cn.tongji.study.mapper.QuestionsMapper;
import cn.tongji.study.model.*;
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
    @GetMapping("getRecommend")
    public ResponseEntity<List<QuestionDTO>> getRecommend(){
        try {
            return ResponseEntity.ok(QAservice.getRecommend());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @GetMapping("getQuestionById")
    public ResponseEntity<List<QuestionDTO>> getQuestionById(
            @RequestParam(value = "questionid") Long questionid
    ){
        try {
            return ResponseEntity.ok(QAservice.getQuestionById(questionid));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @GetMapping("getMyCollection")
    public ResponseEntity<List<QuestionDTO>> getMyCollection(){
        try {
            return ResponseEntity.ok(QAservice.getMyCollection());
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
            @RequestParam(value = "rewardpoints") Integer rewardpoints,
            @RequestParam(value="inputtag1")String tag1,
            @RequestParam(value="inputtag2")String tag2,
            @RequestParam(value="inputtag3")String tag3
    ){
        try {
            return ResponseEntity.ok(QAservice.askQuestion(content,header,rewardpoints,tag1,tag2,tag3));
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
    @PostMapping("clickLikeTset")
    public  ResponseEntity<String>clickLikeTest(
            @RequestParam(value = "userid") Long userid,
            @RequestParam(value = "answerid") Long answerid
    )
    {
        try {
            if (QAservice.clickLikeTest(userid,answerid)==false)
                return ResponseEntity.status(402).body("fail");
            else
                return ResponseEntity.status(200).body("success");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @PostMapping("clickLike")
    public  ResponseEntity<List<LikeDTO>>clickLike(
            @RequestParam(value = "answerid") Long answerid
    )
    {
        try {
            return ResponseEntity.ok(QAservice.clickLike(answerid));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @PostMapping("undoLike")
    public  ResponseEntity<List<LikeDTO>>undoLike(
            @RequestParam(value = "answerid") Long answerid
    )
    {
        try {
            return ResponseEntity.ok(QAservice.undoLike(answerid));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @PostMapping("clickStar")
    public  ResponseEntity<List<CollectionDTO>>clickStar(
            @RequestParam(value = "answerid") Long answerid
    )
    {
        try {
            return ResponseEntity.ok(QAservice.clickStar(answerid));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @PostMapping("clickStarTest")
    public  ResponseEntity<String>clickStarTest(
            @RequestParam(value = "userid") Long userid,
            @RequestParam(value = "answerid") Long answerid
    )
    {
        try {
            if (QAservice.clickStarTest(userid,answerid)==false)
                return ResponseEntity.status(402).body("fail");
            else
                return ResponseEntity.status(200).body("success");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @PostMapping("undoStar")
    public  ResponseEntity<List<CollectionDTO>>undoStar(
            @RequestParam(value = "answerid") Long answerid
    )
    {
        try {
            return ResponseEntity.ok(QAservice.undoStar(answerid));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @PostMapping("adoptanswer")
    public  ResponseEntity<Answers>adoptanswer(
            @RequestParam(value = "answerid") Long answerid
    )
    {
        try {
            return ResponseEntity.ok(QAservice.adoptanswer(answerid));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @PostMapping("makeComment")
    public  ResponseEntity<Comments>makeComment(
            @RequestBody String content,
            @RequestParam(value = "answerid") Long answerid
    )
    {
        try {
            return ResponseEntity.ok(QAservice.makeComment(answerid,content));
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
    @GetMapping("getAnswerById")
    public  ResponseEntity<AnswerDTO>getAnswerById(
            @RequestParam(value = "answerid") Long answerid
    )
    {
        try {
            return ResponseEntity.ok(QAservice.getAnswerById(answerid));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @GetMapping("getAnswerComments")
    public  ResponseEntity<List<CommentDTO>>getAllAnswerComments(
            @RequestParam(value = "answerid") Long answerid
    )
    {
        try {
            return ResponseEntity.ok(QAservice.getAllAnswerComments(answerid));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @GetMapping("getTags")
    public  ResponseEntity<List<TagDTO>>getTags(
            @RequestParam(value = "questionid") Long questionid
    )
    {
        try {
            return ResponseEntity.ok(QAservice.getTags(questionid));
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
