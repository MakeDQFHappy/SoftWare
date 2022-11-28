package cn.tongji.study.mapper;

import cn.tongji.study.model.TagMap;
import cn.tongji.study.model.TagMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagMapMapper {
    long countByExample(TagMapExample example);

    int deleteByExample(TagMapExample example);

    int insert(TagMap record);

    int insertSelective(TagMap record);

    List<TagMap> selectByExample(TagMapExample example);

    int updateByExampleSelective(@Param("record") TagMap record, @Param("example") TagMapExample example);

    int updateByExample(@Param("record") TagMap record, @Param("example") TagMapExample example);
}