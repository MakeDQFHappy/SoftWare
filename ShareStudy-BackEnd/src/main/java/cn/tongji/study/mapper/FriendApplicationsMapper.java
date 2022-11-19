package cn.tongji.study.mapper;

import cn.tongji.study.model.FriendApplications;
import cn.tongji.study.model.FriendApplicationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendApplicationsMapper {
    long countByExample(FriendApplicationsExample example);

    int deleteByExample(FriendApplicationsExample example);

    int deleteByPrimaryKey(Long applicationId);

    int insert(FriendApplications record);

    int insertSelective(FriendApplications record);

    List<FriendApplications> selectByExample(FriendApplicationsExample example);

    FriendApplications selectByPrimaryKey(Long applicationId);

    int updateByExampleSelective(@Param("record") FriendApplications record, @Param("example") FriendApplicationsExample example);

    int updateByExample(@Param("record") FriendApplications record, @Param("example") FriendApplicationsExample example);

    int updateByPrimaryKeySelective(FriendApplications record);

    int updateByPrimaryKey(FriendApplications record);
}