package cn.tongji.study.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author : 王晨
 * @Date : Created in 9:48 2022/11/18
 */
@Data
public class SearchUserDTO {
    Long userId;
    String userName;
    String sex;
    String userAvatar;
    Integer age;
}
