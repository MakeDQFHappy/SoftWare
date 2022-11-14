package cn.tongji.study;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShareStudyBackEndApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    private StringEncryptor encryptor;

    @Test
    void contextLoads() throws SQLException {
    }

    @Test
    public void getPass() {
        String host = encryptor.encrypt("jdbc:mysql://47.103.94.33:3306/test_db?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC");
        String username = encryptor.encrypt("daijiawei");
        String password = encryptor.encrypt("douyu93589");
        System.out.println("database url: " + host);
        System.out.println("database username: " + username);
        System.out.println("database password: " + password);
        Assert.assertTrue(host.length() > 0);
        Assert.assertTrue(password.length() > 0);
        Assert.assertTrue(username.length() > 0);
    }

}
