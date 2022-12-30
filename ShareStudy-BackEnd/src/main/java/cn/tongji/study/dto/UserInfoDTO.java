package cn.tongji.study.dto;

import lombok.Data;

/**
 * @Author : 王晨
 * @Date : Created in 21:52 2022/11/30
 */
@Data
public class UserInfoDTO {
    String userAvatar;
    String userName;
    String sex;
    Integer age;
    Integer bonusPoints;
}
