package cn.tongji.study.mapper;

import cn.tongji.study.model.AnswerCollections;
import cn.tongji.study.model.AnswerCollectionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnswerCollectionsMapper {
    long countByExample(AnswerCollectionsExample example);

    int deleteByExample(AnswerCollectionsExample example);

    int deleteByPrimaryKey(Long collectionId);

    int insert(AnswerCollections record);

    int insertSelective(AnswerCollections record);

    List<AnswerCollections> selectByExample(AnswerCollectionsExample example);

    AnswerCollections selectByPrimaryKey(Long collectionId);

    int updateByExampleSelective(@Param("record") AnswerCollections record, @Param("example") AnswerCollectionsExample example);

    int updateByExample(@Param("record") AnswerCollections record, @Param("example") AnswerCollectionsExample example);

    int updateByPrimaryKeySelective(AnswerCollections record);

    int updateByPrimaryKey(AnswerCollections record);
}