package cn.tongji.study.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.tongji.study.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author : 王晨
 * @Date : Created in 14:41 2022/11/2
 */
@RestController
@RequestMapping("api/login")
public class LoginController {

    @Resource
    LoginService loginService;

    @GetMapping("user")
    public ResponseEntity<String> userLogin(
            @RequestParam(value = "userId") String userId
    ){
        try {
            Long id=Long.parseLong(userId);
            if(loginService.checkLogin(id)){
                StpUtil.login(id);
                return ResponseEntity.ok(StpUtil.getTokenValue());
            }
            return ResponseEntity.status(401).body("输入账号不存在或密码错误");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(402).body("登录失败,请稍后再试");
        }
    }

    @GetMapping("logout")
    public ResponseEntity<String> userLogout(Long id){
        StpUtil.logout(id);
        return ResponseEntity.ok("退出成功");
    }
}
