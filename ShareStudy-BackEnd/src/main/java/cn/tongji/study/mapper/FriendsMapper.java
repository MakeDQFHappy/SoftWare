package cn.tongji.study.mapper;

import cn.tongji.study.model.Friends;
import cn.tongji.study.model.FriendsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendsMapper {
    long countByExample(FriendsExample example);

    int deleteByExample(FriendsExample example);

    int deleteByPrimaryKey(Long friendKey);

    int insert(Friends record);

    int insertSelective(Friends record);

    List<Friends> selectByExampleWithBLOBs(FriendsExample example);

    List<Friends> selectByExample(FriendsExample example);

    Friends selectByPrimaryKey(Long friendKey);

    int updateByExampleSelective(@Param("record") Friends record, @Param("example") FriendsExample example);

    int updateByExampleWithBLOBs(@Param("record") Friends record, @Param("example") FriendsExample example);

    int updateByExample(@Param("record") Friends record, @Param("example") FriendsExample example);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKeyWithBLOBs(Friends record);

    int updateByPrimaryKey(Friends record);
}