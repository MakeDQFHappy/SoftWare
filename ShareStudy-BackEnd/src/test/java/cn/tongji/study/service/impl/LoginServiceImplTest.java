package cn.tongji.study.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import cn.tongji.study.ShareStudyBackEndApplication;
import cn.tongji.study.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = ShareStudyBackEndApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class LoginServiceImplTest {

  @Autowired
  LoginService loginService;

  @Test
  void testLoginService_academicLogin_01() {
    assertNotNull(loginService.academicLogin("2050001", "123456"));
  }

  @Test
  void testLoginService_academicLogin_02() {
    assertNull(loginService.academicLogin("2050001", ""));
  }

  @Test
  void testLoginService_academicLogin_03() {
    assertNull(loginService.academicLogin("2050001", "654321"));
  }

  @Test
  void testLoginService_academicLogin_04() {
    assertNull(loginService.academicLogin("1954321", "123456"));
  }

  @Test
  void testLoginService_academicLogin_05() {
    assertNull(loginService.academicLogin("", "123456"));
  }
}