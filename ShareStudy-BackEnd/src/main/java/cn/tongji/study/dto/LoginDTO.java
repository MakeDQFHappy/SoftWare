package cn.tongji.study.dto;

import lombok.Data;

/**
 * @Author : 王晨
 * @Date : Created in 0:31 2022/11/20
 */
@Data
public class LoginDTO {
    Long userId;
    String userAvatar;
    String userToken;
    String userName;
    String sex;
    Integer age;
    Integer bonusPoints;
    Short userType;
}
