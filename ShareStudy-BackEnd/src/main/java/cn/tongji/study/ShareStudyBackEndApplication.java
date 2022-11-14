package cn.tongji.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.tongji.hospital.mapper")
public class ShareStudyBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareStudyBackEndApplication.class, args);
    }

}
