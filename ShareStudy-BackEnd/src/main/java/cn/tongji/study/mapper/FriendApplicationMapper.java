package cn.tongji.study.mapper;

import cn.tongji.study.model.FriendApplication;
import cn.tongji.study.model.FriendApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendApplicationMapper {
    long countByExample(FriendApplicationExample example);

    int deleteByExample(FriendApplicationExample example);

    int deleteByPrimaryKey(Long applicationId);

    int insert(FriendApplication record);

    int insertSelective(FriendApplication record);

    List<FriendApplication> selectByExample(FriendApplicationExample example);

    FriendApplication selectByPrimaryKey(Long applicationId);

    int updateByExampleSelective(@Param("record") FriendApplication record, @Param("example") FriendApplicationExample example);

    int updateByExample(@Param("record") FriendApplication record, @Param("example") FriendApplicationExample example);

    int updateByPrimaryKeySelective(FriendApplication record);

    int updateByPrimaryKey(FriendApplication record);
}