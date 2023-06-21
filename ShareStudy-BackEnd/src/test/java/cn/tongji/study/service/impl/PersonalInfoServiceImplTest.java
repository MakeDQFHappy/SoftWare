package cn.tongji.study.service.impl;

import cn.tongji.study.service.PersonalInfoService;
import org.junit.jupiter.api.Test;
import cn.tongji.study.ShareStudyBackEndApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(
        classes = ShareStudyBackEndApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class PersonalInfoServiceImplTest {
    @Autowired
    PersonalInfoService personalInfoService;
    @Test
    void updateAvatar() {
    }

    @Test
    void updateBonusPoints() {
    }
    @Test
    void getUserInfoTest() {
        System.out.println(personalInfoService.getUserInfo(1l));
    }
}