package cn.tongji.study.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.tongji.study.dto.UserInfoDTO;
import cn.tongji.study.mapper.UsersMapper;
import cn.tongji.study.model.Users;
import cn.tongji.study.service.PersonalInfoService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

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
    Long myId = Long.parseLong((String) StpUtil.getLoginId());
    Users users = usersMapper.selectByPrimaryKey(myId);
    users.setUserAvatar(avatarUrl);
    usersMapper.updateByPrimaryKeyWithBLOBs(users);
  }

  @Override
  public Integer updateBonusPoints(Integer updateNum) {
    Long myId = Long.parseLong((String) StpUtil.getLoginId());
    Users users = usersMapper.selectByPrimaryKey(myId);
    Integer res = users.getBonusPoints() + updateNum;
    users.setBonusPoints(res);
    usersMapper.updateByPrimaryKey(users);
    return res;
  }

  @Override
  public UserInfoDTO getUserInfo(Long userId) {
    Users users = usersMapper.selectByPrimaryKey(userId);
    UserInfoDTO userInfoDTO = new UserInfoDTO();
    userInfoDTO.setUserName(users.getUserName());
    userInfoDTO.setAge(users.getBirthYear());
    userInfoDTO.setSex(users.getSex());
    userInfoDTO.setUserAvatar(users.getUserAvatar());
    userInfoDTO.setBonusPoints(users.getBonusPoints());
    return userInfoDTO;
  }

  @Override
  public Boolean updateUserInfo(String userName, Integer age, String sex) {
    if (userName == null || age == null || sex == null) {
      return false;
    }
    if (userName.length() > 20) {
      return false;
    }
    Long myId = Long.parseLong((String) StpUtil.getLoginId());
    Users users = usersMapper.selectByPrimaryKey(myId);
    users.setUserName(userName);
    users.setBirthYear(age);
    users.setSex(sex);
    usersMapper.updateByPrimaryKey(users);
    return true;
  }

  @Override
  public Boolean updateUserInfo(Long userId, String userName, Integer birthyear, String sex) {
    if (userName == null || birthyear == null || sex == null) {
      return false;
    }
    if (userName.length() > 20) {
      return false;
    }
    if (birthyear > 2023 || birthyear < 1900) {
      return false;
    }
    if (!sex.equals("男") && !sex.equals("女")) {
      return false;
    }
    Users users = usersMapper.selectByPrimaryKey(userId);
    users.setUserName(userName);
    users.setBirthYear(birthyear);
    users.setSex(sex);
    usersMapper.updateByPrimaryKey(users);
    return true;
  }
}
