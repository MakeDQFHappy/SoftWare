package cn.tongji.study.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cn.tongji.study.ShareStudyBackEndApplication;
import cn.tongji.study.dto.RegisterDTO;
import cn.tongji.study.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = ShareStudyBackEndApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class RegisterServiceImplTest {

  @Autowired
  RegisterService registerService;
  RegisterDTO registerDTO = new RegisterDTO();

  @Autowired
  void Initialize() {
    registerDTO.setAcademicNumber("2050277");
    registerDTO.setRealName("小王");
    registerDTO.setUserName("xiaowang");
    registerDTO.setPassword("123456");
    registerDTO.setSex("男");
    registerDTO.setBirthYear(2002);
    registerDTO.setEmail("xiaowang@tongji.edu.cn");
  }

  @Test
  void testRegisterService_insertUser_01() {
    registerDTO.setAcademicNumber("2050277");
    registerDTO.setRealName("小王");
    registerDTO.setUserName("xiaowang");
    registerDTO.setPassword("123456");
    assertTrue(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_02() {
    registerDTO.setAcademicNumber("2050277");
    registerDTO.setRealName("王源昇");
    registerDTO.setUserName("哈希");
    registerDTO.setPassword("123");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_03() {
    registerDTO.setAcademicNumber("2050277");
    registerDTO.setRealName("");
    registerDTO.setUserName("//超过20个字的用户名xxxxxxxxxxxxx");
    registerDTO.setPassword("123456789123456789");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_04() {
    registerDTO.setAcademicNumber("2050277");
    registerDTO.setRealName("小王");
    registerDTO.setUserName("");
    registerDTO.setPassword("");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_05() {
    registerDTO.setAcademicNumber("2050001");
    registerDTO.setRealName("小王");
    registerDTO.setUserName("哈希");
    registerDTO.setPassword("123456789123456789");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_06() {
    registerDTO.setAcademicNumber("2050001");
    registerDTO.setRealName("王源昇");
    registerDTO.setUserName("xiaowang");
    registerDTO.setPassword("");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_07() {
    registerDTO.setAcademicNumber("2050001");
    registerDTO.setRealName("");
    registerDTO.setUserName("");
    registerDTO.setPassword("123456");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_08() {
    registerDTO.setAcademicNumber("2050001");
    registerDTO.setRealName("小王");
    registerDTO.setUserName("//超过20个字的用户名xxxxxxxxxxx");
    registerDTO.setPassword("123");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_09() {
    registerDTO.setAcademicNumber("abc");
    registerDTO.setRealName("小王");
    registerDTO.setUserName("//超过20个字的用户名xxxxxxxxxxx");
    registerDTO.setPassword("");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_10() {
    registerDTO.setAcademicNumber("abc");
    registerDTO.setRealName("王源昇");
    registerDTO.setUserName("");
    registerDTO.setPassword("123456789123456789");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_11() {
    registerDTO.setAcademicNumber("abc");
    registerDTO.setRealName("");
    registerDTO.setUserName("xiaowang");
    registerDTO.setPassword("123");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_12() {
    registerDTO.setAcademicNumber("abc");
    registerDTO.setRealName("小王");
    registerDTO.setUserName("哈希");
    registerDTO.setPassword("123456");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_13() {
    registerDTO.setAcademicNumber("");
    registerDTO.setRealName("小王");
    registerDTO.setUserName("");
    registerDTO.setPassword("123");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_14() {
    registerDTO.setAcademicNumber("");
    registerDTO.setRealName("王源昇");
    registerDTO.setUserName("//超过20个字的用户名xxxxxxxxx");
    registerDTO.setPassword("123456");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_15() {
    registerDTO.setAcademicNumber("");
    registerDTO.setRealName("");
    registerDTO.setUserName("哈希");
    registerDTO.setPassword("");
    assertFalse(registerService.insertUser(registerDTO));
  }

  @Test
  void testRegisterService_insertUser_16() {
    registerDTO.setAcademicNumber("");
    registerDTO.setRealName("小王");
    registerDTO.setUserName("xiaowang");
    registerDTO.setPassword("123456789123456789");
    assertFalse(registerService.insertUser(registerDTO));
  }

}