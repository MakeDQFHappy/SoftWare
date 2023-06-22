package cn.tongji.study.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cn.tongji.study.ShareStudyBackEndApplication;
import cn.tongji.study.service.PersonalInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = ShareStudyBackEndApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class PersonalInfoServiceImplTest {

  @Autowired
  PersonalInfoService personalInfoService;

  @Test
  void testPersonalInfoService_updateUserInfo_01() {
    assertTrue(personalInfoService.updateUserInfo(371393115791429L, "原神启动", 2002, "男"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_02() {
    assertFalse(personalInfoService.updateUserInfo(371393115791429L, "//超过20个字的用户名", 1800,
        "武装直升机"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_03() {
    assertFalse(personalInfoService.updateUserInfo(371393115791429L, "哈希", 2077, null));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_04() {
    assertFalse(personalInfoService.updateUserInfo(371393115791429L, null, null, "女"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_05() {
    assertFalse(personalInfoService.updateUserInfo(111L, "原神启动", 1800, null));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_06() {
    assertFalse(
        personalInfoService.updateUserInfo(111L, "//超过20个字的用户名xxxxxxxxxxxxxxx", 2002,
            "女"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_07() {
    assertFalse(personalInfoService.updateUserInfo(111L, "哈希", null, "男"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_08() {
    assertFalse(personalInfoService.updateUserInfo(111L, null, 2077, "武装直升机"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_09() {
    assertFalse(personalInfoService.updateUserInfo(null, "原神启动", 2077, "女"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_10() {
    assertFalse(
        personalInfoService.updateUserInfo(null, "//超过20个字的用户名xxxxxxxxxxxx", null, null));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_11() {
    assertFalse(personalInfoService.updateUserInfo(null, "哈希", 2002, "武装直升机"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_12() {
    assertFalse(personalInfoService.updateUserInfo(null, null, 1800, "男"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_13() {
    assertFalse(
        personalInfoService.updateUserInfo(371393115791429L, "原神启动", null, "武装直升机"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_14() {
    assertFalse(
        personalInfoService.updateUserInfo(371393115791429L, "//超过20个字的用户名xxxxxxxxxxxxx",
            2077, "男"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_15() {
    assertFalse(personalInfoService.updateUserInfo(371393115791429L, "哈希", 1800, "女"));
  }

  @Test
  void testPersonalInfoService_updateUserInfo_16() {
    assertFalse(personalInfoService.updateUserInfo(371393115791429L, null, 2002, null));
  }


}
