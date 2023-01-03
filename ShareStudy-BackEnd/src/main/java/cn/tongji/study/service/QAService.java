package cn.tongji.study.service;

import cn.tongji.study.dto.*;
import cn.tongji.study.model.Answers;
import cn.tongji.study.model.Comments;
import cn.tongji.study.model.Likes;
import cn.tongji.study.model.Questions;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface QAService {
    List<QuestionDTO> getMyQuestion();
    List<QuestionDTO> getQuestionById(Long questionid);
    List<QuestionDTO> searchByQuestion(String content);
    List<QuestionDTO> getMyAnswer();
    List<QuestionDTO> getMyCollection();
    List<QuestionDTO> getRecommend();
    Questions askQuestion(String content,String header,Integer rewardpoints,String tag1,String tag2,String tag3);
    List<AnswerDTO>getAnswer(Long questionid);
    AnswerDTO getAnswerById(Long answerid);
    Answers answerQuestion(Long questionid,String content);
    List<TagDTO> getTags(Long questionid);
    Answers adoptanswer(Long answerid);
    Comments makeComment(Long answerid,String content);
    @Cacheable(key="'like'+#answerid", unless = "#result==null",value="answer_like")
    List<LikeDTO> getAllAnswerLikes(Long answerid);
    @CachePut(key="'like'+#answerid",value="answer_like")
    List<LikeDTO> clickLike(Long answerid);
    @CachePut(key="'like'+#answerid",value="answer_like")
    List<LikeDTO> undoLike(Long answerid);
    @Cacheable(key="'star'+#answerid", unless = "#result==null",value="answer_star")
    List<CollectionDTO> getAllAnswerStars(Long answerid);
    @CachePut(key="'star'+#answerid",value="answer_star")
    List<CollectionDTO> clickStar(Long answerid);
    @CachePut(key="'star'+#answerid",value="answer_star")
    List<CollectionDTO> undoStar(Long answerid);
//    @Cacheable(key="'comment'+#answerid", unless = "#result==null",value="answer_comment")
    List<CommentDTO> getAllAnswerComments(Long answerid);
}
