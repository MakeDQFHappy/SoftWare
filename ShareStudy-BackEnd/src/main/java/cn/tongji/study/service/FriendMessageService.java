package cn.tongji.study.service;

import cn.tongji.study.model.FriendPrivateMessages;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author : 王晨
 * @Date : Created in 20:23 2022/11/18
 */
@Service
public interface FriendMessageService {
    FriendPrivateMessages sendMsg(String message,Long receiverId,Integer type);

    List<FriendPrivateMessages> getMsg(Long receiverId);
}
