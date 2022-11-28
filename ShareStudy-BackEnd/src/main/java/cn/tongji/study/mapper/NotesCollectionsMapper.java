package cn.tongji.study.mapper;

import cn.tongji.study.model.NotesCollections;
import cn.tongji.study.model.NotesCollectionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotesCollectionsMapper {
    long countByExample(NotesCollectionsExample example);

    int deleteByExample(NotesCollectionsExample example);

    int deleteByPrimaryKey(Long collectionId);

    int insert(NotesCollections record);

    int insertSelective(NotesCollections record);

    List<NotesCollections> selectByExample(NotesCollectionsExample example);

    NotesCollections selectByPrimaryKey(Long collectionId);

    int updateByExampleSelective(@Param("record") NotesCollections record, @Param("example") NotesCollectionsExample example);

    int updateByExample(@Param("record") NotesCollections record, @Param("example") NotesCollectionsExample example);

    int updateByPrimaryKeySelective(NotesCollections record);

    int updateByPrimaryKey(NotesCollections record);
}