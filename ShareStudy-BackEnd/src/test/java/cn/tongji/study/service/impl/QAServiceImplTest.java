package cn.tongji.study.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cn.tongji.study.ShareStudyBackEndApplication;
import cn.tongji.study.service.QAService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = ShareStudyBackEndApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class QAServiceImplTest {

  @Autowired
  QAService qaService;

  @Test
  void testQAService_clickLike_01() {
    assertTrue(qaService.clickLikeTest(371393115791429L, 371189782810693L));
  }

  @Test
  void testQAService_clickLike_02() {
    assertFalse(qaService.clickLikeTest(111L, 371189782810693L));
  }

  @Test
  void testQAService_clickLike_03() {
    assertFalse(qaService.clickLikeTest(null, 371189782810693L));
  }

  @Test
  void testQAService_clickLike_04() {
    assertFalse(qaService.clickLikeTest(371393115791429L, 222L));
  }

  @Test
  void testQAService_clickLike_05() {
    assertFalse(qaService.clickLikeTest(371393115791429L, null));
  }

  @Test
  void testQAService_clickLike_06() {
    assertFalse(qaService.clickLikeTest(111L, 222L));
  }

  @Test
  void testQAService_clickLike_07() {
    assertFalse(qaService.clickLikeTest(111L, null));
  }

  @Test
  void testQAService_clickLike_08() {
    assertFalse(qaService.clickLikeTest(null, 222L));
  }

  @Test
  void testQAService_clickLike_09() {
    assertFalse(qaService.clickLikeTest(null, null));
  }

}