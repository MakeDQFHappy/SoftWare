package cn.tongji.study.service;

import cn.tongji.study.dto.AnswerDTO;
import cn.tongji.study.dto.LikeDTO;
import cn.tongji.study.dto.QuestionDTO;
import cn.tongji.study.dto.TagDTO;
import cn.tongji.study.model.Answers;
import cn.tongji.study.model.Likes;
import cn.tongji.study.model.Questions;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface QAService {
    List<QuestionDTO> getMyQuestion();
    List<QuestionDTO> searchByQuestion(String content);
    List<QuestionDTO> getMyAnswer();
    Questions askQuestion(String content,String header,Integer rewardpoints,String tag1,String tag2,String tag3);
    List<AnswerDTO>getAnswer(Long questionid);
    Answers answerQuestion(Long questionid,String content);
    List<TagDTO> getTags(Long questionid);
    Answers adoptanswer(Long answerid);
    @Cacheable(key="#answerid", unless = "#result==null",value="answer_like")
    List<LikeDTO> getAllAnswerLikes(Long answerid);
    @CachePut(key="#answerid",value="answer_like")
    List<LikeDTO> clickLike(Long answerid);
    @CachePut(key="#answerid",value="answer_like")
    List<LikeDTO> undoLike(Long answerid);

}
