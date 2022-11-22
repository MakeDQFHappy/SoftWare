package cn.tongji.study.service;

import cn.tongji.study.dto.QuestionDTO;
import cn.tongji.study.model.Questions;

import java.util.List;

public interface QAService {
    List<QuestionDTO> getMyQuestion();
    Questions askQuestion(String content);
}
