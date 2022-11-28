package cn.tongji.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@SpringBootApplication
@MapperScan("cn.tongji.study.mapper")
@EnableCaching//开启缓存
public class ShareStudyBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareStudyBackEndApplication.class, args);
    }

}
