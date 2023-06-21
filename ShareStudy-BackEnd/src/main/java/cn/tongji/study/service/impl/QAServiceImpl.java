package cn.tongji.study.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.tongji.study.dto.AnswerDTO;
import cn.tongji.study.dto.LikeDTO;
import cn.tongji.study.dto.CollectionDTO;
import cn.tongji.study.dto.CommentDTO;
import cn.tongji.study.dto.TagDTO;
import cn.tongji.study.mapper.*;
import cn.tongji.study.model.*;
import cn.tongji.study.dto.QuestionDTO;
import cn.tongji.study.model.QuestionsExample;
import cn.tongji.study.service.QAService;
import com.github.pagehelper.PageHelper;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.stream.events.Comment;
import java.net.http.WebSocket;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class QAServiceImpl implements QAService {
    @Resource
    UsersMapper usersMapper;
    @Resource
    QuestionsMapper questionsMapper;
    @Resource
    LikesMapper likesMapper;
    @Resource
    AnswerCollectionsMapper answerCollectionsMapper;
    @Resource
    TagsMapper tagsMapper;
    @Resource
    TagMapMapper tagMapMapper;
    @Resource
    AnswersMapper answersMapper;
    @Resource
    CommentsMapper commentsMapper;
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
            myQuestionDTO.setCreatetime(question.getCreateTime());
            myQuestionDTO.setHasadoptedanswer(question.getHasAdoptedAnswer());
            myQuestionDTO.setHasanswerer(question.getHasAnswerer());
            myQuestionDTOS.add(myQuestionDTO);
        }
        return myQuestionDTOS;
    }
    @Override
    public List<QuestionDTO> getQuestionById(Long questionid)
    {
        List<QuestionDTO> myQuestionDTOS=new ArrayList<>();
        QuestionsExample example=new QuestionsExample();
        QuestionsExample.Criteria criteria= example.createCriteria();
        criteria.andQuestionIdEqualTo(questionid);
        List<Questions> questions=questionsMapper.selectByExampleWithBLOBs(example);
        for(Questions question: questions)
        {
            QuestionDTO myQuestionDTO=new QuestionDTO();
            myQuestionDTO.setQuestionid(question.getQuestionId());
            myQuestionDTO.setRewardpoints(question.getRewardPoints());
            myQuestionDTO.setQuestionheader(question.getQuestionHeader());
            myQuestionDTO.setQuestioncontent(question.getQuestionContent());
            myQuestionDTO.setQuestionaskerid(question.getQuestionAskerId());
            myQuestionDTO.setCreatetime(question.getCreateTime());
            myQuestionDTO.setHasadoptedanswer(question.getHasAdoptedAnswer());
            myQuestionDTO.setHasanswerer(question.getHasAnswerer());
            myQuestionDTOS.add(myQuestionDTO);
        }
        return myQuestionDTOS;
    }
    @Override
    public List<LikeDTO> getAllAnswerLikes(Long answerid)
    {
        List<LikeDTO> likeDTOS=new ArrayList<>();
        LikesExample example=new LikesExample();
        LikesExample.Criteria criteria=example.createCriteria();
        criteria.andTargetIdEqualTo(answerid);
        List<Likes> likes=likesMapper.selectByExample(example);
        for(Likes like: likes)
        {
            LikeDTO likeDTO=new LikeDTO();
            likeDTO.setLikeid(like.getLikeId());
            likeDTO.setUserid(like.getUserId());
            likeDTO.setTargetid(like.getTargetId());
            likeDTOS.add(likeDTO);
        }
        return likeDTOS;
    }
    @Override
    public List<CommentDTO> getAllAnswerComments(Long answerid)
    {
        List<CommentDTO> commentDTOS=new ArrayList<>();
        CommentsExample example=new CommentsExample();
        CommentsExample.Criteria criteria=example.createCriteria();
        criteria.andTargetIdEqualTo(answerid);
        List<Comments> comments=commentsMapper.selectByExampleWithBLOBs(example);
        for(Comments comment: comments)
        {
            CommentDTO commentDTO=new CommentDTO();
            commentDTO.setCommentid(comment.getCommentId());
            commentDTO.setCommenterid(comment.getCommenterId());
            commentDTO.setCommentcontent(comment.getCommentContent());
            commentDTO.setTargetid(comment.getTargetId());
            Users users= usersMapper.selectByPrimaryKey(comment.getCommenterId());
            commentDTO.setCommentername(users.getUserName());
            commentDTO.setCommenteravatar(users.getUserAvatar());
            commentDTOS.add(commentDTO);
        }
        return commentDTOS;
    }
    @Override
    public List<CollectionDTO> getAllAnswerStars(Long answerid)
    {
        List<CollectionDTO> collectionDTOS=new ArrayList<>();
        AnswerCollectionsExample example=new AnswerCollectionsExample();
        AnswerCollectionsExample.Criteria criteria= example.createCriteria();
        criteria.andAnswerIdEqualTo(answerid);
        List<AnswerCollections> answerCollections=answerCollectionsMapper.selectByExample(example);
        for(AnswerCollections answerCollection: answerCollections)
        {
            CollectionDTO collectionDTO=new CollectionDTO();
            collectionDTO.setCollectionid(answerCollection.getCollectionId());
            collectionDTO.setAnswerid(answerCollection.getAnswerId());
            collectionDTO.setUserid(answerCollection.getUserId());
            collectionDTOS.add(collectionDTO);
        }
        return collectionDTOS;
    }
    @Override
    public List<QuestionDTO> searchByQuestion(String content)
    {
        List<QuestionDTO> myQuestionDTOS=new ArrayList<>();
        //获取个人ID
        Long myId= Long.parseLong((String) StpUtil.getLoginId());
        QuestionsExample example=new QuestionsExample();
        QuestionsExample.Criteria criteria= example.createCriteria();
        criteria.andQuestionHeaderLike('%'+content+'%');
        List<Questions> questions=questionsMapper.selectByExampleWithBLOBs(example);
        for(Questions question: questions) {
            QuestionDTO myQuestionDTO = new QuestionDTO();
            myQuestionDTO.setQuestionid(question.getQuestionId());
            myQuestionDTO.setRewardpoints(question.getRewardPoints());
            myQuestionDTO.setQuestionheader(question.getQuestionHeader());
            myQuestionDTO.setQuestioncontent(question.getQuestionContent());
            myQuestionDTO.setQuestionaskerid(question.getQuestionAskerId());
            myQuestionDTO.setCreatetime(question.getCreateTime());
            myQuestionDTO.setHasadoptedanswer(question.getHasAdoptedAnswer());
            myQuestionDTO.setHasanswerer(question.getHasAnswerer());
            myQuestionDTOS.add(myQuestionDTO);
        }
        return myQuestionDTOS;
    }
    @Override
    public List<QuestionDTO> getMyAnswer()
    {
        List<QuestionDTO> myQuestionDTOS=new ArrayList<>();
        //获取个人ID
        Long myId= Long.parseLong((String) StpUtil.getLoginId());
        AnswersExample example=new AnswersExample();
        AnswersExample.Criteria criteria=example.createCriteria();
        criteria.andAnswererIdEqualTo(myId);
        List<Answers> answers=answersMapper.selectByExampleWithBLOBs(example);
        for(Answers answer:answers)
        {
            QuestionsExample example1=new QuestionsExample();
            QuestionsExample.Criteria criteria1= example1.createCriteria();
            criteria1.andQuestionIdEqualTo(answer.getQuestionId());
            List<Questions> questions=questionsMapper.selectByExampleWithBLOBs(example1);
            for(Questions question: questions) {
                QuestionDTO myQuestionDTO = new QuestionDTO();
                myQuestionDTO.setQuestionid(question.getQuestionId());
                myQuestionDTO.setRewardpoints(question.getRewardPoints());
                myQuestionDTO.setQuestionheader(question.getQuestionHeader());
                myQuestionDTO.setQuestioncontent(question.getQuestionContent());
                myQuestionDTO.setQuestionaskerid(question.getQuestionAskerId());
                myQuestionDTO.setCreatetime(question.getCreateTime());
                myQuestionDTO.setHasanswerer(true);
                myQuestionDTO.setHasadoptedanswer(question.getHasAdoptedAnswer());
                if(!myQuestionDTOS.contains(myQuestionDTO)){
                myQuestionDTOS.add(myQuestionDTO);}
            }
        }
        return myQuestionDTOS;
    }
    @Override
    public List<QuestionDTO> getMyCollection()
    {
        List<QuestionDTO> myQuestionDTOS=new ArrayList<>();
        Long myId= Long.parseLong((String) StpUtil.getLoginId());
        AnswerCollectionsExample example2=new AnswerCollectionsExample();
        AnswerCollectionsExample.Criteria criteria2= example2.createCriteria();
        criteria2.andUserIdEqualTo(myId);
        List<AnswerCollections> answerCollections=answerCollectionsMapper.selectByExample(example2);
        List<Answers> answers=new ArrayList<>();
        for(AnswerCollections answerCollection:answerCollections)
        {
            answers.add(answersMapper.selectByPrimaryKey(answerCollection.getAnswerId()));
        }
        for(Answers answer:answers)
        {
            QuestionsExample example1=new QuestionsExample();
            QuestionsExample.Criteria criteria1= example1.createCriteria();
            criteria1.andQuestionIdEqualTo(answer.getQuestionId());
            List<Questions> questions=questionsMapper.selectByExampleWithBLOBs(example1);
            for(Questions question: questions) {
                QuestionDTO myQuestionDTO = new QuestionDTO();
                myQuestionDTO.setQuestionid(question.getQuestionId());
                myQuestionDTO.setRewardpoints(question.getRewardPoints());
                myQuestionDTO.setQuestionheader(question.getQuestionHeader());
                myQuestionDTO.setQuestioncontent(question.getQuestionContent());
                myQuestionDTO.setQuestionaskerid(question.getQuestionAskerId());
                myQuestionDTO.setCreatetime(question.getCreateTime());
                myQuestionDTO.setHasanswerer(true);
                myQuestionDTO.setHasadoptedanswer(question.getHasAdoptedAnswer());
                if(!myQuestionDTOS.contains(myQuestionDTO)){
                    myQuestionDTOS.add(myQuestionDTO);}
            }
        }
        return myQuestionDTOS;
    }
    @Override
    public List<QuestionDTO> getRecommend()
    {
        List<QuestionDTO> myQuestionDTOS=new ArrayList<>();
        QuestionsExample example=new QuestionsExample();
        QuestionsExample.Criteria criteria= example.createCriteria();
        criteria.andCreateTimeIsNotNull();
        example.setOrderByClause ("create_time desc");
        List<Questions> questions=questionsMapper.selectByExampleWithBLOBs(example);
        for(Questions question: questions)
        {
            QuestionDTO myQuestionDTO=new QuestionDTO();
            myQuestionDTO.setQuestionid(question.getQuestionId());
            myQuestionDTO.setRewardpoints(question.getRewardPoints());
            myQuestionDTO.setQuestionheader(question.getQuestionHeader());
            myQuestionDTO.setQuestioncontent(question.getQuestionContent());
            myQuestionDTO.setQuestionaskerid(question.getQuestionAskerId());
            myQuestionDTO.setCreatetime(question.getCreateTime());
            myQuestionDTO.setHasadoptedanswer(question.getHasAdoptedAnswer());
            myQuestionDTO.setHasanswerer(question.getHasAnswerer());
            myQuestionDTOS.add(myQuestionDTO);
        }
        return myQuestionDTOS;
    }
    @Override
    public Questions askQuestion(String content,String header,Integer rewardpoints,String tag1,String tag2,String tag3){
        Questions questions=new Questions();
        questions.setQuestionHeader(header);
        questions.setRewardPoints(rewardpoints);
        questions.setQuestionId(YitIdHelper.nextId());
        questions.setQuestionContent(content);
        Long myId=Long.parseLong((String) StpUtil.getLoginId());
        questions.setQuestionAskerId(myId);
        TimeZone time=TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone.setDefault(time);
        Date date = new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        questions.setCreateTime(timestamp);
        questions.setHasAdoptedAnswer(false);
        questions.setHasAnswerer(false);
        if(tag1!="")
        {

            Tags tags=new Tags();
            tags.setValue(tag1);
            tags.setTagId(YitIdHelper.nextId());
            tagsMapper.insert(tags);
            TagMap tagMap=new TagMap();
            tagMap.setTagId(tags.getTagId());
            tagMap.setTargetId(questions.getQuestionId());
            tagMapMapper.insert(tagMap);
        }
        if(tag2!="")
        {
            Tags tags=new Tags();
            tags.setValue(tag2);
            tags.setTagId(YitIdHelper.nextId());
            tagsMapper.insert(tags);
            TagMap tagMap=new TagMap();
            tagMap.setTagId(tags.getTagId());
            tagMap.setTargetId(questions.getQuestionId());
            tagMapMapper.insert(tagMap);
        }
        if(tag3!="")
        {
            Tags tags=new Tags();
            tags.setValue(tag3);
            tags.setTagId(YitIdHelper.nextId());
            tagsMapper.insert(tags);
            TagMap tagMap=new TagMap();
            tagMap.setTagId(tags.getTagId());
            tagMap.setTargetId(questions.getQuestionId());
            tagMapMapper.insert(tagMap);
        }
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
        Questions questions=questionsMapper.selectByPrimaryKey(questionid);
        questions.setHasAnswerer(true);
        questionsMapper.updateByPrimaryKeyWithBLOBs(questions);
        answers.setAdopted(false);
        answers.setAnswerContent(content);
        TimeZone time=TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone.setDefault(time);
        Date date = new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        answers.setCreateTime(timestamp);
        answers.setHasComment(false);
        answersMapper.insert(answers);
        return  answers;
    }
    @Override
    public Answers adoptanswer(Long answerid)
    {
        Answers answers=answersMapper.selectByPrimaryKey(answerid);
        answers.setAdopted(true);
        answersMapper.updateByPrimaryKey(answers);
        Questions questions=questionsMapper.selectByPrimaryKey(answers.getQuestionId());
        questions.setHasAdoptedAnswer(true);
        questionsMapper.updateByPrimaryKeyWithBLOBs(questions);
        return  answers;
    }
    @Override
    public Comments makeComment(Long answerid,String content)
    {
        Answers answers=answersMapper.selectByPrimaryKey(answerid);
        answers.setHasComment(true);
        answersMapper.updateByPrimaryKey(answers);
        Comments comments=new Comments();
        comments.setCommentId(YitIdHelper.nextId());
        Long myId=Long.parseLong((String) StpUtil.getLoginId());
        comments.setCommenterId(myId);
        comments.setCommentContent(content);
        comments.setTargetId(answerid);
        commentsMapper.insert(comments);
        return  comments;
    }
    @Override
    public List<CollectionDTO> clickStar(Long answerid)
    {
        AnswerCollections answerCollections=new AnswerCollections();
        Long myId=Long.parseLong((String) StpUtil.getLoginId());
        answerCollections.setCollectionId(YitIdHelper.nextId());
        answerCollections.setAnswerId(answerid);
        answerCollections.setUserId(myId);
        answerCollectionsMapper.insert(answerCollections);
        List<CollectionDTO> collectionDTOS=getAllAnswerStars(answerid);
        return collectionDTOS;
    }
    @Override
    public Boolean clickStarTest(Long userid,Long answerid)
    {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(userid);
        List<Users> users = usersMapper.selectByExampleWithBLOBs(example);
        if(users.size()==0){
            return false;
        }
        AnswersExample example1=new AnswersExample();
        AnswersExample.Criteria criteria1=example1.createCriteria();
        criteria1.andAnswerIdEqualTo(answerid);
        List<Answers> answers = answersMapper.selectByExampleWithBLOBs(example1);
        if(answers.size()==0){
            return false;
        }
        AnswerCollections answerCollections=new AnswerCollections();
        Long myId=userid;
        answerCollections.setCollectionId(YitIdHelper.nextId());
        answerCollections.setAnswerId(answerid);
        answerCollections.setUserId(myId);
        answerCollectionsMapper.insert(answerCollections);
        return true;
    }
    @Override
    public List<LikeDTO> clickLike(Long answerid)
    {
        Likes likes=new Likes();
        Long myId=Long.parseLong((String) StpUtil.getLoginId());
        likes.setLikeId(YitIdHelper.nextId());
        likes.setTargetId(answerid);
        likes.setUserId(myId);
        likesMapper.insert(likes);
        List<LikeDTO> likeDTOS=getAllAnswerLikes(answerid);
        return likeDTOS;
    }
    @Override
    public Boolean clickLikeTest(Long userid,Long answerid)
    {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(userid);
        List<Users> users = usersMapper.selectByExampleWithBLOBs(example);
        if(users.size()==0){
            return false;
        }
        AnswersExample example1=new AnswersExample();
        AnswersExample.Criteria criteria1=example1.createCriteria();
        criteria1.andAnswerIdEqualTo(answerid);
        List<Answers> answers = answersMapper.selectByExampleWithBLOBs(example1);
        if(answers.size()==0){
            return false;
        }
        Likes likes=new Likes();
        Long myId=userid;
        likes.setLikeId(YitIdHelper.nextId());
        likes.setTargetId(answerid);
        likes.setUserId(myId);
        likesMapper.insert(likes);
        return true;
    }
    @Override
    public List<CollectionDTO> undoStar(Long answerid)
    {
        AnswerCollections answerCollections=new AnswerCollections();
        Long myId=Long.parseLong((String) StpUtil.getLoginId());
        AnswerCollectionsExample example=new AnswerCollectionsExample();
        AnswerCollectionsExample.Criteria criteria=example.createCriteria();
        criteria.andAnswerIdEqualTo(answerid).andUserIdEqualTo(myId);
        answerCollectionsMapper.deleteByExample(example);
        List<CollectionDTO> collectionDTOS=getAllAnswerStars(answerid);
        return collectionDTOS;
    }
    @Override
    public List<LikeDTO> undoLike(Long answerid)
    {
        Likes likes=new Likes();
        Long myId=Long.parseLong((String) StpUtil.getLoginId());
        LikesExample example=new LikesExample();
        LikesExample.Criteria criteria=example.createCriteria();
        criteria.andTargetIdEqualTo(answerid).andUserIdEqualTo(myId);
        likes.setTargetId(answerid);
        likes.setUserId(myId);
        likesMapper.deleteByExample(example);
        List<LikeDTO> likeDTOS=getAllAnswerLikes(answerid);
        return likeDTOS;
    }
    @Override
    public List<AnswerDTO>getAnswer(Long questionid)
    {
        List<AnswerDTO> answerDTOS=new ArrayList<>();
        AnswersExample example=new AnswersExample();
        AnswersExample.Criteria criteria= example.createCriteria();
        criteria.andQuestionIdEqualTo(questionid);
        Long myId=Long.parseLong((String) StpUtil.getLoginId());
        PageHelper.startPage(1,5);
        List<Answers> answers=answersMapper.selectByExampleWithBLOBs(example);
        for(Answers answer:answers)
        {
            AnswerDTO answerDTO=new AnswerDTO();
            answerDTO.setAdopted(answer.getAdopted());
            answerDTO.setQuestionid(answer.getQuestionId());
            if(answer.getAnswerContent().length()<=100) {
                answerDTO.setAnswercontent(answer.getAnswerContent());
            }
            else {
                answerDTO.setAnswercontent(answer.getAnswerContent().substring(0,99));
            }
            answerDTO.setAnswerid(answer.getAnswerId());
            answerDTO.setAnswererid(answer.getAnswererId());
            answerDTO.setCreatetime(answer.getCreateTime());
            Users users = usersMapper.selectByPrimaryKey(answerDTO.getAnswererid());
            answerDTO.setAnswerername(users.getUserName());
            answerDTO.setAnswereravatar(users.getUserAvatar());
            List<LikeDTO> likeDTOS=getAllAnswerLikes(answer.getAnswerId());
            for(LikeDTO likeDTO:likeDTOS)
            {
                if(likeDTO.getUserid().equals(myId))
                {
                    answerDTO.setIsliked(true);
                    break;
                }
            }
            answerDTO.setLikenum(likeDTOS.size());
            List<CollectionDTO> collectionDTOS=getAllAnswerStars(answer.getAnswerId());
            for(CollectionDTO collectionDTO:collectionDTOS)
            {
                if(collectionDTO.getUserid().equals(myId))
                {
                    answerDTO.setIsStared(true);
                    break;
                }
            }
            answerDTO.setStarnum(collectionDTOS.size());
            List<CommentDTO> commentDTOS=getAllAnswerComments(answer.getAnswerId());
            if(commentDTOS.size()!=0)
            {
                answerDTO.setHascomment(true);
            }
            else {
                answerDTO.setHascomment(false);
            }
            answerDTO.setCommentnum(commentDTOS.size());
            answerDTOS.add(answerDTO);
        }
        return answerDTOS;
    }
    @Override
    public AnswerDTO getAnswerById(Long answerid)
    {
        Answers answer=answersMapper.selectByPrimaryKey(answerid);
        Long myId=Long.parseLong((String) StpUtil.getLoginId());
        AnswerDTO answerDTO=new AnswerDTO();
        answerDTO.setAdopted(answer.getAdopted());
        answerDTO.setQuestionid(answer.getQuestionId());
        answerDTO.setAnswercontent(answer.getAnswerContent());
        answerDTO.setAnswerid(answer.getAnswerId());
        answerDTO.setAnswererid(answer.getAnswererId());
        answerDTO.setCreatetime(answer.getCreateTime());
        Users users = usersMapper.selectByPrimaryKey(answerDTO.getAnswererid());
        answerDTO.setAnswerername(users.getUserName());
        answerDTO.setAnswereravatar(users.getUserAvatar());
        List<LikeDTO> likeDTOS=getAllAnswerLikes(answer.getAnswerId());
        for(LikeDTO likeDTO:likeDTOS)
        {
            if(likeDTO.getUserid().equals(myId))
            {
                answerDTO.setIsliked(true);
                break;
            }
        }
        answerDTO.setLikenum(likeDTOS.size());
        List<CollectionDTO> collectionDTOS=getAllAnswerStars(answer.getAnswerId());
        for(CollectionDTO collectionDTO:collectionDTOS)
        {
            if(collectionDTO.getUserid().equals(myId))
            {
                answerDTO.setIsStared(true);
                break;
            }
        }
            answerDTO.setStarnum(collectionDTOS.size());
            List<CommentDTO> commentDTOS=getAllAnswerComments(answer.getAnswerId());
            if(commentDTOS.size()!=0)
            {
                answerDTO.setHascomment(true);
            }
            else {
                answerDTO.setHascomment(false);
            }
            answerDTO.setCommentnum(commentDTOS.size());
        return answerDTO;
    }
    @Override
    public List<TagDTO>getTags(Long questionid)
    {
        List<TagDTO> tagDTOS=new ArrayList<>();
        TagMapExample example=new TagMapExample();
        TagMapExample.Criteria criteria=example.createCriteria();
        criteria.andTargetIdEqualTo(questionid);
        List<TagMap> tagMaps=tagMapMapper.selectByExample(example);
        for(TagMap tagMap:tagMaps) {
            Tags tags = tagsMapper.selectByPrimaryKey(tagMap.getTagId());
            TagDTO tagDTO=new TagDTO();
            tagDTO.setValue(tags.getValue());
            tagDTO.setTagid(tags.getTagId());
            tagDTOS.add(tagDTO);
        }
        return tagDTOS;
    }
}
