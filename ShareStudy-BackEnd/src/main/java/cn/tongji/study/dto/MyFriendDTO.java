package cn.tongji.study.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author : 王晨
 * @Date : Created in 9:47 2022/11/18
 */
@Data
public class MyFriendDTO {
    Long friendKey;
    Long friendId;
    String lastMessage;
    Date lastChatTime;
    String friendName;
    String sex;
    String friendAvatar;
    Integer age;
    Integer notReadNum;
}
