package cn.tongji.study.service.impl;

import cn.tongji.study.dto.RegisterDTO;
import cn.tongji.study.mapper.UsersMapper;
import cn.tongji.study.mapper.VarificationMapper;
import cn.tongji.study.model.Users;
import cn.tongji.study.model.UsersExample;
import cn.tongji.study.model.Varification;
import cn.tongji.study.model.VarificationExample;
import cn.tongji.study.service.RegisterService;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

/**
 * @Author : 王晨
 * @Date : Created in 14:56 2022/11/2
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    UsersMapper usersMapper;

    @Resource
    VarificationMapper varificationMapper;

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public Boolean academicExist(String academicNumber) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria=example.createCriteria();
        criteria.andAcademicNumberEqualTo(academicNumber);
        List<Users> users = usersMapper.selectByExample(example);
        return users.size()!=0;
    }

    public String randomCode(){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
    @Override
    public String sendEmail(String toEmail) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setSubject("邮箱验证码");//主题
            //生成随机数
            String code = randomCode();

            mailMessage.setText("尊敬的用户：您好！欢迎您注册享学平台，您收到的验证码是："+code);//内容

            mailMessage.setTo(toEmail);//发给谁

            mailMessage.setFrom(from);//你自己的邮箱

            mailSender.send(mailMessage);//发送
            return  code;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean verifyAcademicNumber(String academicNumber,String name) {
        VarificationExample example=new VarificationExample();
        VarificationExample.Criteria criteria=example.createCriteria();
        criteria.andAcademicNumberEqualTo(academicNumber);
        criteria.andNameEqualTo(name);
        List<Varification> varifications = varificationMapper.selectByExample(example);
        return varifications.size()!=0;
    }

    @Override
    public void insertUser(RegisterDTO registerDTO) {
        Users users=new Users();
        users.setUserId(YitIdHelper.nextId());
        users.setAcademicNumber(registerDTO.getAcademicNumber());
        users.setBirthYear(registerDTO.getBirthYear());
        users.setEmail(registerDTO.getEmail());
        users.setSex(registerDTO.getSex());
        users.setRealName(registerDTO.getRealName());
        users.setUserName(registerDTO.getUserName());
        users.setPassword(registerDTO.getPassword());
        users.setBonusPoints(0);
        users.setUserAvatar("https://wc-project.oss-cn-shanghai.aliyuncs.com/%E7%94%A8%E6%88%B7%E5%A4%B4%E5%83%8F.png");
        users.setUserType((short)0);
        TimeZone time=TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone.setDefault(time);
        Date date = new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        users.setCreatedTime(timestamp);
        usersMapper.insert(users);
    }
}
