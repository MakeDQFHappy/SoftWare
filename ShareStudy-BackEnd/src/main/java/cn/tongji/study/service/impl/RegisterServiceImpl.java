package cn.tongji.study.service.impl;

import cn.tongji.study.mapper.UsersMapper;
import cn.tongji.study.mapper.VarificationMapper;
import cn.tongji.study.model.Users;
import cn.tongji.study.model.UsersExample;
import cn.tongji.study.model.Varification;
import cn.tongji.study.model.VarificationExample;
import cn.tongji.study.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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


    @Override
    public Boolean academicExist(String academicNumber) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria=example.createCriteria();
        criteria.andAcademicNumberEqualTo(academicNumber);
        List<Users> users = usersMapper.selectByExample(example);
        return users.size()!=0;
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
}
