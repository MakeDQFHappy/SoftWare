package cn.tongji.study.service;

import cn.tongji.study.dto.AnswerDTO;
import cn.tongji.study.dto.QuestionDTO;
import cn.tongji.study.model.Answers;
import cn.tongji.study.model.Questions;

import java.util.List;

public interface QAService {
    List<QuestionDTO> getMyQuestion();
    Questions askQuestion(String content,String header,Integer rewardpoints);
    List<AnswerDTO>getAnswer(Long questionid);
    Answers answerQuestion(Long questionid,String content);

}
