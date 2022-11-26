package cn.tongji.study.controller;

import cn.tongji.study.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author : 王晨
 * @Date : Created in 14:52 2022/11/2
 */
@RestController
@RequestMapping("api/register")
public class RegisterController {
    @Resource
    RegisterService registerService;

    @GetMapping("varifyAcademic")
    public ResponseEntity<String> varifyAcademic(
            @RequestParam(value = "academicNumber") String academicNumber,
            @RequestParam(value = "name") String name
    ){
        try {
            if(registerService.academicExist(academicNumber)){
                return ResponseEntity.status(403).body("学号已存在");
            }
            if(!registerService.verifyAcademicNumber(academicNumber,name)){
                return ResponseEntity.status(405).body("学号验证未通过");
            }
            return ResponseEntity.ok("学号验证通过");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(404).body("学号验证出错");
        }
    }


}
