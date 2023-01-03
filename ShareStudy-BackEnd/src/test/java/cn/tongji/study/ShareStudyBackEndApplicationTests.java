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
public class ShareStudyBackEndApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    private StringEncryptor encryptor;

    @Test
    void contextLoads() throws SQLException {
    }

    @Test
    public void getPass() {
        String username = encryptor.encrypt("310499328@qq.com");
        String password = encryptor.encrypt("vxsflmvxcjawcahi");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        Assert.assertTrue(username.length() > 0);
        Assert.assertTrue(password.length() > 0);
    }

}
