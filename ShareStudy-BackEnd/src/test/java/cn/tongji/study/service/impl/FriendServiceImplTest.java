package cn.tongji.study.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cn.tongji.study.ShareStudyBackEndApplication;
import cn.tongji.study.service.FriendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = ShareStudyBackEndApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class FriendServiceImplTest {

  @Autowired
  FriendService friendService;

  @Test
  void testFriendService_sendFriendRequest_01() {
    assertTrue(friendService.sendFriendRequest(411393115791429L, "你好", 430609259245637L));
  }

  @Test
  void testFriendService_sendFriendRequest_02() {
    assertFalse(friendService.sendFriendRequest(111L, "你好", 430609259245637L));
  }

  @Test
  void testFriendService_sendFriendRequest_03() {
    assertFalse(friendService.sendFriendRequest(0L, "你好", 430609259245637L));
  }

  @Test
  void testFriendService_sendFriendRequest_04() {
    assertFalse(friendService.sendFriendRequest(411393115791429L, "你好", 111L));
  }

  @Test
  void testFriendService_sendFriendRequest_05() {
    assertFalse(friendService.sendFriendRequest(411393115791429L, "你好", 411393115791429L));
  }

  @Test
  void testFriendService_sendFriendRequest_06() {
    assertFalse(friendService.sendFriendRequest(411393115791429L, "你好", 0L));
  }

  @Test
  void testFriendService_sendFriendRequest_07() {
    assertFalse(friendService.sendFriendRequest(411393115791429L,
        "超过50字的内容xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
        430609259245637L));
  }

  @Test
  void testFriendService_sendFriendRequest_08() {
    assertTrue(friendService.sendFriendRequest(411393115791429L, "", 430609259245637L));
  }
}