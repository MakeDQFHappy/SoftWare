package cn.tongji.study.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.tongji.study.dto.LoginDTO;
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

    @GetMapping("academic")
    public ResponseEntity<LoginDTO> userAcademicLogin(
            @RequestParam(value = "academicNum") String academicNum,
            @RequestParam(value = "password") String password
    ){
        try {
            LoginDTO loginDTO = loginService.academicLogin(academicNum, password);
            if(loginDTO!=null){
                StpUtil.login(loginDTO.getUserId());
                return ResponseEntity.ok(loginDTO);
            }
            else {
                return ResponseEntity.status(403).body(null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("email")
    public ResponseEntity<LoginDTO> userEmailLogin(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password
    ){
        try {
            LoginDTO loginDTO = loginService.emailLogin(email, password);
            if(loginDTO!=null){
                StpUtil.login(loginDTO.getUserId());
                return ResponseEntity.ok(loginDTO);
            }
            else {
                return ResponseEntity.status(403).body(null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).body(null);
        }
    }
    @GetMapping("logout")
    public ResponseEntity<String> userLogout(
            @RequestParam(value = "id") Long id
    ){
        StpUtil.logout(id);
        return ResponseEntity.ok("退出成功");
    }
}
