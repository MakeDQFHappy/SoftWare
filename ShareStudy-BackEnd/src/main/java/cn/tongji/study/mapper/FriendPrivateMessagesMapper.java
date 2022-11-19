package cn.tongji.study.mapper;

import cn.tongji.study.model.FriendPrivateMessages;
import cn.tongji.study.model.FriendPrivateMessagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendPrivateMessagesMapper {
    long countByExample(FriendPrivateMessagesExample example);

    int deleteByExample(FriendPrivateMessagesExample example);

    int deleteByPrimaryKey(Long messageId);

    int insert(FriendPrivateMessages record);

    int insertSelective(FriendPrivateMessages record);

    List<FriendPrivateMessages> selectByExampleWithBLOBs(FriendPrivateMessagesExample example);

    List<FriendPrivateMessages> selectByExample(FriendPrivateMessagesExample example);

    FriendPrivateMessages selectByPrimaryKey(Long messageId);

    int updateByExampleSelective(@Param("record") FriendPrivateMessages record, @Param("example") FriendPrivateMessagesExample example);

    int updateByExampleWithBLOBs(@Param("record") FriendPrivateMessages record, @Param("example") FriendPrivateMessagesExample example);

    int updateByExample(@Param("record") FriendPrivateMessages record, @Param("example") FriendPrivateMessagesExample example);

    int updateByPrimaryKeySelective(FriendPrivateMessages record);

    int updateByPrimaryKeyWithBLOBs(FriendPrivateMessages record);

    int updateByPrimaryKey(FriendPrivateMessages record);
}