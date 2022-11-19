package cn.tongji.study.mapper;

import cn.tongji.study.model.Likes;
import cn.tongji.study.model.LikesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LikesMapper {
    long countByExample(LikesExample example);

    int deleteByExample(LikesExample example);

    int deleteByPrimaryKey(Long likeId);

    int insert(Likes record);

    int insertSelective(Likes record);

    List<Likes> selectByExample(LikesExample example);

    Likes selectByPrimaryKey(Long likeId);

    int updateByExampleSelective(@Param("record") Likes record, @Param("example") LikesExample example);

    int updateByExample(@Param("record") Likes record, @Param("example") LikesExample example);

    int updateByPrimaryKeySelective(Likes record);

    int updateByPrimaryKey(Likes record);
}