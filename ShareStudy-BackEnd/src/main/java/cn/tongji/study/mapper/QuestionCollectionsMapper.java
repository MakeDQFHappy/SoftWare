package cn.tongji.study.mapper;

import cn.tongji.study.model.QuestionCollections;
import cn.tongji.study.model.QuestionCollectionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionCollectionsMapper {
    long countByExample(QuestionCollectionsExample example);

    int deleteByExample(QuestionCollectionsExample example);

    int deleteByPrimaryKey(Long collectionId);

    int insert(QuestionCollections record);

    int insertSelective(QuestionCollections record);

    List<QuestionCollections> selectByExample(QuestionCollectionsExample example);

    QuestionCollections selectByPrimaryKey(Long collectionId);

    int updateByExampleSelective(@Param("record") QuestionCollections record, @Param("example") QuestionCollectionsExample example);

    int updateByExample(@Param("record") QuestionCollections record, @Param("example") QuestionCollectionsExample example);

    int updateByPrimaryKeySelective(QuestionCollections record);

    int updateByPrimaryKey(QuestionCollections record);
}