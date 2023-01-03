package cn.tongji.study.service;

import cn.tongji.study.dto.MyFriendDTO;
import cn.tongji.study.dto.ReceiveFriendReqDTO;
import cn.tongji.study.dto.SearchUserDTO;
import cn.tongji.study.model.FriendApplications;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : 王晨
 * @Date : Created in 21:46 2022/11/15
 */
@Service
public interface FriendService {
    void sendFriendRequest(String introduction,Long receiverId);

    List<ReceiveFriendReqDTO> getFriendRequest();

    List<ReceiveFriendReqDTO> getMyRequest();

    void agreeFriendRequest(Long applicationId);

    void rejectFriendRequest(Long applicationId);

    List<SearchUserDTO> searchUser(String searchInfo);

    List<SearchUserDTO> recommandFriends(int page,int size);

    List<MyFriendDTO> getMyFriend();

    void removeFriend(Long friendKey);

    Boolean checkFriend(Long friendId);

    void deleteRequest(Long applicationId);

}
