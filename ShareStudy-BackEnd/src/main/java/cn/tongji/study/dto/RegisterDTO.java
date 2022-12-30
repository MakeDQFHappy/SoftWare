package cn.tongji.study.dto;

import lombok.Data;

/**
 * @Author : 王晨
 * @Date : Created in 16:45 2022/12/6
 */
@Data
public class RegisterDTO {
    String userName;
    String email;
    String sex;
    String academicNumber;
    Integer birthYear;
    String password;
    String realName;
}
