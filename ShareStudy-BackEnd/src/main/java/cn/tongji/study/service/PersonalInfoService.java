package cn.tongji.study.service;

import org.springframework.stereotype.Service;

/**
 * @Author : 王晨
 * @Date : Created in 19:09 2022/11/26
 */
@Service
public interface PersonalInfoService {
    void updateAvatar(String avatarUrl);

    Integer updateBonusPoints(Integer updateNum);
}
