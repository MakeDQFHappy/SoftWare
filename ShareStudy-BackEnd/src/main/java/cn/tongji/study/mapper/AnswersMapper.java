package cn.tongji.study.mapper;

import cn.tongji.study.model.Answers;
import cn.tongji.study.model.AnswersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnswersMapper {
    long countByExample(AnswersExample example);

    int deleteByExample(AnswersExample example);

    int deleteByPrimaryKey(Long answerId);

    int insert(Answers record);

    int insertSelective(Answers record);

    List<Answers> selectByExampleWithBLOBs(AnswersExample example);

    List<Answers> selectByExample(AnswersExample example);

    Answers selectByPrimaryKey(Long answerId);

    int updateByExampleSelective(@Param("record") Answers record, @Param("example") AnswersExample example);

    int updateByExampleWithBLOBs(@Param("record") Answers record, @Param("example") AnswersExample example);

    int updateByExample(@Param("record") Answers record, @Param("example") AnswersExample example);

    int updateByPrimaryKeySelective(Answers record);

    int updateByPrimaryKeyWithBLOBs(Answers record);

    int updateByPrimaryKey(Answers record);
}