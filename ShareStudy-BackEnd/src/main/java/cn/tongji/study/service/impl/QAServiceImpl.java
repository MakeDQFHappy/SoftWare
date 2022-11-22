package cn.tongji.study.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.tongji.study.model.*;
import cn.tongji.study.dto.QuestionDTO;
import cn.tongji.study.mapper.AnswersMapper;
import cn.tongji.study.mapper.QuestionsMapper;
import cn.tongji.study.mapper.UsersMapper;
import cn.tongji.study.model.QuestionsExample;
import cn.tongji.study.service.QAService;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class QAServiceImpl implements QAService {
    @Resource
    UsersMapper usersMapper;
    @Resource
    QuestionsMapper questionsMapper;
    @Resource
    AnswersMapper answersMapper;
    @Override
    public List<QuestionDTO> getMyQuestion()
    {
        List<QuestionDTO> myQuestionDTOS=new ArrayList<>();
        //获取个人ID
        Long myId= Long.parseLong((String) StpUtil.getLoginId());
        QuestionsExample example=new QuestionsExample();
        QuestionsExample.Criteria criteria= example.createCriteria();
        criteria.andQuestionAskerIdEqualTo(myId);
        List<Questions> questions=questionsMapper.selectByExampleWithBLOBs(example);
        for(Questions question: questions)
        {
            QuestionDTO myQuestionDTO=new QuestionDTO();
            myQuestionDTO.setQuestionid(question.getQuestionId());
            myQuestionDTO.setRewardpoints(question.getRewardPoints());
            myQuestionDTO.setQuestionheader(question.getQuestionHeader());
            myQuestionDTO.setQuestioncontent(question.getQuestionContent());
            myQuestionDTOS.add(myQuestionDTO);
        }
        return myQuestionDTOS;
    }
    @Override
    public Questions askQuestion(String content){
        Questions questions=new Questions();
        questions.setQuestionId(YitIdHelper.nextId());
        questions.setQuestionContent(content);
        Long myId=Long.parseLong((String) StpUtil.getLoginId());
        questions.setQuestionAskerId(myId);
        questionsMapper.insert(questions);
        return questions;
    }
}
