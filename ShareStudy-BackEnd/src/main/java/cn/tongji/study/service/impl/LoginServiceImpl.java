package cn.tongji.study.service.impl;

import cn.tongji.study.mapper.UsersMapper;
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
    public Boolean checkLogin(Long userId) {
        if(usersMapper.selectByPrimaryKey(userId)!=null){
            return true;
        }
        return false;
    }
}
