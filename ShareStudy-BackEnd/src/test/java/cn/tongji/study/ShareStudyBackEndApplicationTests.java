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
        String endpoint = encryptor.encrypt("endpoint");
        String bucketname = encryptor.encrypt("bucketname");
        String keyid = encryptor.encrypt("keyid");
        String keysecret = encryptor.encrypt("keysecret");
        System.out.println("endpoint: " + endpoint);
        System.out.println("bucketname: " + bucketname);
        System.out.println("keyid: " + keyid);
        System.out.println("keysecret: " + keysecret);
        Assert.assertTrue(endpoint.length() > 0);
        Assert.assertTrue(bucketname.length() > 0);
        Assert.assertTrue(keyid.length() > 0);
        Assert.assertTrue(keysecret.length() > 0);
    }

}
