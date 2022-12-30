package cn.tongji.study.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.tongji.study.dto.LoginDTO;
import cn.tongji.study.mapper.UsersMapper;
import cn.tongji.study.model.Users;
import cn.tongji.study.model.UsersExample;
import cn.tongji.study.service.LoginService;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @Author : 王晨
 * @Date : Created in 12:00 2022/11/15
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UsersMapper usersMapper;

    @Override
    public LoginDTO academicLogin(String academicNum,String password) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria=example.createCriteria();
        criteria.andAcademicNumberEqualTo(academicNum);
        criteria.andPasswordEqualTo(password);
        List<Users> users = usersMapper.selectByExampleWithBLOBs(example);
        if(users.size()==0){
            return null;
        }
        StpUtil.login(users.get(0).getUserId());
        TimeZone time=TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone.setDefault(time);
        Date date = new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        LoginDTO loginDTO=new LoginDTO();
        if(users.get(0).getLastLoginTime()==null||checkFirst(timestamp,users.get(0).getLastLoginTime())){
            loginDTO.setIsFirst(true);
        }
        else{
            loginDTO.setIsFirst(false);
        }
        users.get(0).setLastLoginTime(timestamp);
        usersMapper.updateByPrimaryKey(users.get(0));
        loginDTO.setUserAvatar(users.get(0).getUserAvatar());
        loginDTO.setUserId(users.get(0).getUserId());
        loginDTO.setUserToken(StpUtil.getTokenValue());
        loginDTO.setAge(users.get(0).getBirthYear());
        loginDTO.setSex(users.get(0).getSex());
        loginDTO.setBonusPoints(users.get(0).getBonusPoints());
        loginDTO.setUserName(users.get(0).getUserName());
        loginDTO.setUserType(users.get(0).getUserType());
        return loginDTO;
    }

    public Boolean checkFirst(Timestamp nowDate, Date lastDate){
        SimpleDateFormat sdfLogin = new SimpleDateFormat("yyyy-MM-dd");
        String now = sdfLogin.format(nowDate);
        String last = sdfLogin.format(lastDate);
        return !now.equals(last);
    }
}
