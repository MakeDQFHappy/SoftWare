package cn.tongji.study.service;

import cn.tongji.study.dto.LoginDTO;
import org.springframework.stereotype.Service;

/**
 * @Author : 王晨
 * @Date : Created in 11:59 2022/11/15
 */
@Service
public interface LoginService {
    LoginDTO checkLogin(Long userId);
}
