package cn.tongji.study.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.tongji.study.dto.LoginDTO;
import cn.tongji.study.mapper.UsersMapper;
import cn.tongji.study.model.Users;
import cn.tongji.study.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author : 王晨
 * @Date : Created in 12:00 2022/11/15
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UsersMapper usersMapper;

    @Override
    public LoginDTO checkLogin(Long userId) {
        Users users = usersMapper.selectByPrimaryKey(userId);
        if(users != null){
            StpUtil.login(userId);
            LoginDTO loginDTO=new LoginDTO();
            loginDTO.setUserToken(StpUtil.getTokenValue());
            loginDTO.setUserId(Long.parseLong((String)StpUtil.getLoginId()));
            loginDTO.setUserAvatar(users.getUserAvatar());
            return loginDTO;
        }
        return null;
    }
}
