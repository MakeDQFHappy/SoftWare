package cn.tongji.study.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.tongji.study.dto.MyFriendDTO;
import cn.tongji.study.dto.ReceiveFriendReqDTO;
import cn.tongji.study.dto.SearchUserDTO;
import cn.tongji.study.mapper.*;
import cn.tongji.study.model.*;
import cn.tongji.study.service.FriendService;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

/**
 * @Author : 王晨
 * @Date : Created in 21:46 2022/11/15
 */
@Service
public class FriendServiceImpl implements FriendService {
    @Resource
    FriendApplicationsMapper friendApplicationsMapper;

    @Resource
    FriendsMapper friendsMapper;


    @Resource
    FriendPrivateMessagesMapper friendPrivateMessagesMapper;


    @Resource
    UsersMapper usersMapper;

    @Override
    public void sendFriendRequest(String introduction,Long receiverId) {
        //如果已经发送过好友请求,就重设介绍
        FriendApplicationsExample example=new FriendApplicationsExample();
        FriendApplicationsExample.Criteria criteria=example.createCriteria();
        criteria.andApplicantIdEqualTo(Long.parseLong((String)StpUtil.getLoginId()))
                .andReceiverIdEqualTo(receiverId)
                .andStatusEqualTo((short)0);
        List<FriendApplications> friendApplications = friendApplicationsMapper.selectByExample(example);
        if(!friendApplications.isEmpty()){
            friendApplications.get(0).setIntroduction(introduction);
            TimeZone time=TimeZone.getTimeZone("Etc/GMT-8");
            TimeZone.setDefault(time);
            Date date = new Date();
            Timestamp timestamp=new Timestamp(date.getTime());
            friendApplications.get(0).setCreateTime(timestamp);
            return;
        }
        //发送好友请求
        FriendApplications friendApplication=new FriendApplications();
        friendApplication.setApplicationId(YitIdHelper.nextId());
        friendApplication.setApplicantId(Long.parseLong((String)StpUtil.getLoginId()));
        friendApplication.setStatus((short) 0);
        friendApplication.setReceiverId(receiverId);
        friendApplication.setIntroduction(introduction);
        TimeZone time=TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone.setDefault(time);
        Date date = new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        friendApplication.setCreateTime(timestamp);
        friendApplicationsMapper.insert(friendApplication);
    }

    @Override
    public List<ReceiveFriendReqDTO> getFriendRequest() {
        FriendApplicationsExample example=new FriendApplicationsExample();
        FriendApplicationsExample.Criteria criteria=example.createCriteria();
        criteria.andReceiverIdEqualTo(Long.parseLong((String)StpUtil.getLoginId()));
        criteria.andStatusEqualTo((short) 0);
        List<FriendApplications> friendApplications = friendApplicationsMapper.selectByExample(example);
        List<ReceiveFriendReqDTO> friendReqDTOS=new ArrayList<>();
        for (FriendApplications friendApplication: friendApplications) {
            Long applicantId = friendApplication.getApplicantId();
            Users users = usersMapper.selectByPrimaryKey(applicantId);
            ReceiveFriendReqDTO receiveFriendReqDTO=new ReceiveFriendReqDTO();
            receiveFriendReqDTO.setFriendAvatar(users.getUserAvatar());
            receiveFriendReqDTO.setFriendName(users.getUserName());
            receiveFriendReqDTO.setIntroduction(friendApplication.getIntroduction());
            receiveFriendReqDTO.setCreateTime(friendApplication.getCreateTime());
            receiveFriendReqDTO.setAge(users.getBirthYear());
            receiveFriendReqDTO.setSex(users.getSex());
            receiveFriendReqDTO.setApplicationId(friendApplication.getApplicationId());
            receiveFriendReqDTO.setFriendId(applicantId);
            friendReqDTOS.add(receiveFriendReqDTO);
        }
        return friendReqDTOS;
    }

    @Override
    public List<ReceiveFriendReqDTO> getMyRequest() {
        Long myId=Long.parseLong((String)StpUtil.getLoginId());
        FriendApplicationsExample example=new FriendApplicationsExample();
        FriendApplicationsExample.Criteria criteria=example.createCriteria();
        criteria.andApplicantIdEqualTo(myId);
        List<FriendApplications> friendApplications = friendApplicationsMapper.selectByExample(example);
        List<ReceiveFriendReqDTO> receiveFriendReqDTOS=new ArrayList<>();
        for (FriendApplications friendApplication:friendApplications) {
            Users users = usersMapper.selectByPrimaryKey(friendApplication.getReceiverId());
            ReceiveFriendReqDTO receiveFriendReqDTO=new ReceiveFriendReqDTO();
            receiveFriendReqDTO.setFriendAvatar(users.getUserAvatar());
            receiveFriendReqDTO.setFriendName(users.getUserName());
            receiveFriendReqDTO.setCreateTime(friendApplication.getCreateTime());
            receiveFriendReqDTO.setAge(users.getBirthYear());
            receiveFriendReqDTO.setFriendId(users.getUserId());
            receiveFriendReqDTO.setSex(users.getSex());
            receiveFriendReqDTO.setIntroduction(friendApplication.getIntroduction());
            receiveFriendReqDTO.setApplicationId(friendApplication.getApplicationId());
            receiveFriendReqDTO.setStatus(friendApplication.getStatus());
            receiveFriendReqDTOS.add(receiveFriendReqDTO);
        }
        return receiveFriendReqDTOS;
    }

    @Override
    public void agreeFriendRequest(Long applicationId) {
        FriendApplications friendApplication = friendApplicationsMapper.selectByPrimaryKey(applicationId);
        Friends friend=new Friends();
        friend.setUserId(friendApplication.getApplicantId());
        friend.setFriendId(friendApplication.getReceiverId());
        friend.setFriendKey(YitIdHelper.nextId());
        friendsMapper.insert(friend);
        friendApplication.setStatus((short)1);
        friendApplicationsMapper.updateByPrimaryKey(friendApplication);
    }

    @Override
    public void rejectFriendRequest(Long applicationId) {
        FriendApplications friendApplication=friendApplicationsMapper.selectByPrimaryKey(applicationId);
        friendApplication.setStatus((short)2);
        friendApplicationsMapper.updateByPrimaryKey(friendApplication);
    }

    @Override
    public List<SearchUserDTO> searchUser(String searchInfo) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria=example.createCriteria();
        criteria.andUserNameLike("%"+searchInfo+"%");
        if(searchInfo.length()>=5){
            UsersExample.Criteria criteria1 = example.or();
        }
        List<Users> users = usersMapper.selectByExampleWithBLOBs(example);
        List<SearchUserDTO> searchUserDTOS = new ArrayList<>();
        List<Long> myFriendsId = getMyFriendsId();
        Long myId=Long.parseLong((String)StpUtil.getLoginId());
        for (Users user:users) {
            if(!myFriendsId.contains(user.getUserId())&&!user.getUserId().equals(myId)){
                SearchUserDTO searchUserDTO=new SearchUserDTO();
                searchUserDTO.setUserName(user.getUserName());
                searchUserDTO.setSex(user.getSex());
                searchUserDTO.setAge(user.getBirthYear());
                searchUserDTO.setUserAvatar(user.getUserAvatar());
                searchUserDTO.setUserId(user.getUserId());
                searchUserDTOS.add(searchUserDTO);
            }
        }
        return searchUserDTOS;
    }

    public List<Long> getMyFriendsId(){
        Long myId= Long.parseLong((String)StpUtil.getLoginId());
        FriendsExample example=new FriendsExample();
        FriendsExample.Criteria criteria=example.createCriteria();
        criteria.andFriendIdEqualTo(myId);
        FriendsExample.Criteria criteria1=example.or();
        criteria1.andUserIdEqualTo(myId);
        List<Friends> friends = friendsMapper.selectByExampleWithBLOBs(example);
        List<Long> friendsId=new ArrayList<>();
        for (Friends friend: friends) {
            Long friendId= friend.getFriendId().equals(myId)?friend.getUserId():friend.getFriendId();
            friendsId.add(friendId);
        }
        return  friendsId;
    }

    public Integer countNotRead(Long myId,Long senderId){
        FriendPrivateMessagesExample example=new FriendPrivateMessagesExample();
        FriendPrivateMessagesExample.Criteria criteria=example.createCriteria();
        criteria.andSenderIdEqualTo(senderId);
        criteria.andReceiverIdEqualTo(myId);
        criteria.andIsReadEqualTo(false);
        List<FriendPrivateMessages> friendPrivateMessages = friendPrivateMessagesMapper.selectByExample(example);
        return friendPrivateMessages.size();
    }
    @Override
    public List<MyFriendDTO> getMyFriend() {
        List<MyFriendDTO>myFriendDTOS=new ArrayList<>();
        Long myId= Long.parseLong((String)StpUtil.getLoginId());
        FriendsExample example=new FriendsExample();
        FriendsExample.Criteria criteria=example.createCriteria();
        criteria.andFriendIdEqualTo(myId);
        FriendsExample.Criteria criteria1=example.or();
        criteria1.andUserIdEqualTo(myId);
        List<Friends> friends = friendsMapper.selectByExampleWithBLOBs(example);
        for (Friends friend: friends) {
            Long friendId= friend.getFriendId().equals(myId)?friend.getUserId():friend.getFriendId();
            MyFriendDTO myFriendDTO=new MyFriendDTO();
            Users users = usersMapper.selectByPrimaryKey(friendId);
            myFriendDTO.setFriendId(friendId);
            myFriendDTO.setLastMessage(friend.getLastMessage());
            myFriendDTO.setFriendName(users.getUserName());
            myFriendDTO.setFriendAvatar(users.getUserAvatar());
            myFriendDTO.setFriendKey(friend.getFriendKey());
            myFriendDTO.setAge(users.getBirthYear());
            myFriendDTO.setSex(users.getSex());
            myFriendDTO.setLastChatTime(friend.getLastChatTime());
            myFriendDTO.setNotReadNum(countNotRead(myId,friendId));
            myFriendDTOS.add(myFriendDTO);
        }
        return myFriendDTOS;
    }

    @Override
    public void removeFriend(Long friendKey) {
        friendsMapper.deleteByPrimaryKey(friendKey);
    }

    @Override
    public Boolean checkFriend(Long friendId) {
        List<Long> myFriendsId = getMyFriendsId();
        return myFriendsId.contains(friendId);
    }

    @Override
    public void deleteRequest(Long applicationId) {
        friendApplicationsMapper.deleteByPrimaryKey(applicationId);
    }
}
