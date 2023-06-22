package cn.tongji.study.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.tongji.study.mapper.FriendPrivateMessagesMapper;
import cn.tongji.study.mapper.FriendsMapper;
import cn.tongji.study.model.FriendPrivateMessages;
import cn.tongji.study.model.FriendPrivateMessagesExample;
import cn.tongji.study.model.Friends;
import cn.tongji.study.model.FriendsExample;
import cn.tongji.study.service.FriendMessageService;
import com.github.yitter.idgen.YitIdHelper;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author : 王晨
 * @Date : Created in 20:23 2022/11/18
 */
@Service
public class FriendMessageServiceImpl implements FriendMessageService {

  @Resource
  FriendPrivateMessagesMapper friendPrivateMessagesMapper;

  @Resource
  FriendsMapper friendsMapper;

  @Override
  public FriendPrivateMessages sendMsg(String message, Long receiverId, Integer type) {
    FriendPrivateMessages friendPrivateMessages = new FriendPrivateMessages();
    friendPrivateMessages.setMessage(message);
    friendPrivateMessages.setMessageId(YitIdHelper.nextId());
    friendPrivateMessages.setIsRead(false);
    friendPrivateMessages.setReceiverId(receiverId);
    Long myId = Long.parseLong((String) StpUtil.getLoginId());
    friendPrivateMessages.setSenderId(myId);
    TimeZone time = TimeZone.getTimeZone("Etc/GMT-8");
    TimeZone.setDefault(time);
    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());
    friendPrivateMessages.setCreateTime(timestamp);
    friendPrivateMessages.setType(type);
    friendPrivateMessagesMapper.insert(friendPrivateMessages);
    FriendsExample example = new FriendsExample();
    FriendsExample.Criteria criteria = example.createCriteria();
    criteria.andFriendIdEqualTo(myId).andUserIdEqualTo(receiverId);
    FriendsExample.Criteria or = example.or();
    or.andUserIdEqualTo(myId).andFriendIdEqualTo(receiverId);
    List<Friends> friends = friendsMapper.selectByExampleWithBLOBs(example);
    if (!friends.isEmpty()) {
      if (type == 1) {
        friends.get(0).setLastMessage(message);
      } else if (type == 2) {
        friends.get(0).setLastMessage("[语音]");
      } else if (type == 3) {
        friends.get(0).setLastMessage("[图片]");
      } else {
        friends.get(0).setLastMessage("[文件]");
      }
      friends.get(0).setLastChatTime(timestamp);
      friendsMapper.updateByPrimaryKeyWithBLOBs(friends.get(0));
    }
    return friendPrivateMessages;
  }

  @Override
  public List<FriendPrivateMessages> getMsg(Long receiverId) {
    Long myId = Long.parseLong((String) StpUtil.getLoginId());
    FriendPrivateMessagesExample example = new FriendPrivateMessagesExample();
    FriendPrivateMessagesExample.Criteria criteria = example.createCriteria();
    criteria.andReceiverIdEqualTo(receiverId);
    criteria.andSenderIdEqualTo(myId);
    FriendPrivateMessagesExample.Criteria or = example.or();
    or.andSenderIdEqualTo(receiverId);
    or.andReceiverIdEqualTo(myId);
    List<FriendPrivateMessages> friendPrivateMessages = friendPrivateMessagesMapper.selectByExampleWithBLOBs(
        example);
    friendPrivateMessages.sort((t1, t2) -> t1.getCreateTime().compareTo(t2.getCreateTime()));
    return friendPrivateMessages;
  }

  @Override
  public void readMsg(Long senderId) {
    Long myId = Long.parseLong((String) StpUtil.getLoginId());
    FriendPrivateMessagesExample example = new FriendPrivateMessagesExample();
    FriendPrivateMessagesExample.Criteria criteria = example.createCriteria();
    criteria.andSenderIdEqualTo(senderId);
    criteria.andReceiverIdEqualTo(myId);
    List<FriendPrivateMessages> friendPrivateMessages = friendPrivateMessagesMapper.selectByExample(
        example);
    for (FriendPrivateMessages message : friendPrivateMessages) {
      message.setIsRead(true);
      friendPrivateMessagesMapper.updateByPrimaryKey(message);
    }
  }
}
