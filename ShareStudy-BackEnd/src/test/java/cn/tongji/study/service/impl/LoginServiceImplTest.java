package cn.tongji.study.service.impl;

import cn.tongji.study.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import cn.tongji.study.ShareStudyBackEndApplication;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(
        classes = ShareStudyBackEndApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)


class LoginServiceImplTest {
    @Autowired
    LoginService loginService;
    @Test
    void academicLogin() {
        System.out.println(loginService.academicLogin("2050001","123456"));
    }

    @Test
    void emailLogin() {
    }

    @Test
    void checkFirst() {
    }
}