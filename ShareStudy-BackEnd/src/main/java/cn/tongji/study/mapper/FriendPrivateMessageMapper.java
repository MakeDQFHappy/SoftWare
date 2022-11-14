package cn.tongji.study.mapper;

import cn.tongji.study.model.FriendPrivateMessage;
import cn.tongji.study.model.FriendPrivateMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendPrivateMessageMapper {
    long countByExample(FriendPrivateMessageExample example);

    int deleteByExample(FriendPrivateMessageExample example);

    int deleteByPrimaryKey(Long messageId);

    int insert(FriendPrivateMessage record);

    int insertSelective(FriendPrivateMessage record);

    List<FriendPrivateMessage> selectByExampleWithBLOBs(FriendPrivateMessageExample example);

    List<FriendPrivateMessage> selectByExample(FriendPrivateMessageExample example);

    FriendPrivateMessage selectByPrimaryKey(Long messageId);

    int updateByExampleSelective(@Param("record") FriendPrivateMessage record, @Param("example") FriendPrivateMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") FriendPrivateMessage record, @Param("example") FriendPrivateMessageExample example);

    int updateByExample(@Param("record") FriendPrivateMessage record, @Param("example") FriendPrivateMessageExample example);

    int updateByPrimaryKeySelective(FriendPrivateMessage record);

    int updateByPrimaryKeyWithBLOBs(FriendPrivateMessage record);

    int updateByPrimaryKey(FriendPrivateMessage record);
}