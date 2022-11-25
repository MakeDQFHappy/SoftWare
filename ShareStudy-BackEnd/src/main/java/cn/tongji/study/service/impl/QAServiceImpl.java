package cn.tongji.study.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.tongji.study.dto.AnswerDTO;
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
            myQuestionDTO.setQuestionaskerid(myId);
            AnswersExample example1=new AnswersExample();
            AnswersExample.Criteria criteria1=example1.createCriteria();
            criteria1.andQuestionIdEqualTo(question.getQuestionId());
            List<Answers> answers=answersMapper.selectByExampleWithBLOBs(example1);
            if(answers.isEmpty())
                myQuestionDTO.setHasanswerer(false);
            else
                myQuestionDTO.setHasanswerer(true);
            myQuestionDTOS.add(myQuestionDTO);
        }
        return myQuestionDTOS;
    }
    @Override
    public Questions askQuestion(String content,String header,Integer rewardpoints){
        Questions questions=new Questions();
        questions.setQuestionHeader(header);
        questions.setRewardPoints(rewardpoints);
        questions.setQuestionId(YitIdHelper.nextId());
        questions.setQuestionContent(content);
        Long myId=Long.parseLong((String) StpUtil.getLoginId());
        questions.setQuestionAskerId(myId);
        questionsMapper.insert(questions);
        return questions;
    }
    @Override
    public Answers answerQuestion(Long questionid,String content)
    {
        Answers answers=new Answers();
        Long myId=Long.parseLong((String) StpUtil.getLoginId());
        answers.setAnswererId(myId);
        answers.setAnswerId(YitIdHelper.nextId());
        answers.setQuestionId(questionid);
        answers.setAdopted(false);
        answers.setAnswerContent(content);
        answersMapper.insert(answers);
        return  answers;
    }
    @Override
    public List<AnswerDTO>getAnswer(Long questionid)
    {
        List<AnswerDTO> answerDTOS=new ArrayList<>();
        AnswersExample example=new AnswersExample();
        AnswersExample.Criteria criteria= example.createCriteria();
        criteria.andQuestionIdEqualTo(questionid);
        List<Answers> answers=answersMapper.selectByExampleWithBLOBs(example);
        for(Answers answer:answers)
        {
            AnswerDTO answerDTO=new AnswerDTO();
            answerDTO.setAdopted(answer.getAdopted());
            answerDTO.setQuestionid(answer.getQuestionId());
            answerDTO.setAnswercontent(answer.getAnswerContent());
            answerDTO.setAnswerid(answer.getAnswererId());
            answerDTO.setAnswererid(answer.getAnswererId());
            Users users = usersMapper.selectByPrimaryKey(answerDTO.getAnswererid());
            answerDTO.setAnswerername(users.getUserName());
            answerDTO.setAnswereravatar(users.getUserAvatar());
            answerDTOS.add(answerDTO);
        }
        return answerDTOS;
    }
}
