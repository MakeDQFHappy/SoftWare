package cn.tongji.study.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author : 王晨
 * @Date : Created in 16:43 2022/11/18
 */
@Data
public class ReceiveFriendReqDTO {
    Long applicationId;
    Long friendId;
    String friendName;
    String sex;
    String friendAvatar;
    Integer age;
    String introduction;
    Short status;
    Date createTime;
}
