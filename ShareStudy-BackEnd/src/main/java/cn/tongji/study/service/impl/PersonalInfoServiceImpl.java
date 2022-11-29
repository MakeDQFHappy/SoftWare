package cn.tongji.study.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.tongji.study.mapper.UsersMapper;
import cn.tongji.study.model.Users;
import cn.tongji.study.service.PersonalInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author : 王晨
 * @Date : Created in 19:09 2022/11/26
 */
@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {


    @Resource
    UsersMapper usersMapper;

    @Override
    public void updateAvatar(String avatarUrl) {
        Long myId=Long.parseLong((String)StpUtil.getLoginId());
        Users users = usersMapper.selectByPrimaryKey(myId);
        users.setUserAvatar(avatarUrl);
        usersMapper.updateByPrimaryKeyWithBLOBs(users);
    }

    @Override
    public Integer updateBonusPoints(Integer updateNum) {
        Long myId=Long.parseLong((String)StpUtil.getLoginId());
        Users users = usersMapper.selectByPrimaryKey(myId);
        Integer res=users.getBonusPoints()+updateNum;
        users.setBonusPoints(res);
        usersMapper.updateByPrimaryKey(users);
        return res;
    }
}
