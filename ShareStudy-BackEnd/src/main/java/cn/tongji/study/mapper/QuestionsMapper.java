package cn.tongji.study.mapper;

import cn.tongji.study.model.Questions;
import cn.tongji.study.model.QuestionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionsMapper {
    long countByExample(QuestionsExample example);

    int deleteByExample(QuestionsExample example);

    int deleteByPrimaryKey(Long questionId);

    int insert(Questions record);

    int insertSelective(Questions record);

    List<Questions> selectByExampleWithBLOBs(QuestionsExample example);

    List<Questions> selectByExample(QuestionsExample example);
    List<Questions>fuzzyQuery(String content);

    Questions selectByPrimaryKey(Long questionId);

    int updateByExampleSelective(@Param("record") Questions record, @Param("example") QuestionsExample example);

    int updateByExampleWithBLOBs(@Param("record") Questions record, @Param("example") QuestionsExample example);

    int updateByExample(@Param("record") Questions record, @Param("example") QuestionsExample example);

    int updateByPrimaryKeySelective(Questions record);

    int updateByPrimaryKeyWithBLOBs(Questions record);

    int updateByPrimaryKey(Questions record);
}