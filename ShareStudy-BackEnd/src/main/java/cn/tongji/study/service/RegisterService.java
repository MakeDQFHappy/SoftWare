package cn.tongji.study.service;

import cn.tongji.study.dto.RegisterDTO;
import org.springframework.stereotype.Service;

/**
 * @Author : 王晨
 * @Date : Created in 14:56 2022/11/2
 */
@Service
public interface RegisterService {
    Boolean academicExist(String academicNumber);
    String sendEmail(String toEmail);
    Boolean verifyAcademicNumber(String academicNumber,String name);

    Boolean insertUser(RegisterDTO registerDTO);

}
