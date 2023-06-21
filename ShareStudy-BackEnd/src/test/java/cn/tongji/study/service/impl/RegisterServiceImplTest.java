package cn.tongji.study.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import cn.tongji.study.dto.RegisterDTO;
import cn.tongji.study.mapper.UsersMapper;
import cn.tongji.study.mapper.VarificationMapper;
import cn.tongji.study.model.Users;
import cn.tongji.study.model.UsersExample;
import cn.tongji.study.model.Varification;
import cn.tongji.study.model.VarificationExample;

import java.time.LocalDate;
import java.time.ZoneOffset;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RegisterServiceImpl.class})
@ExtendWith(SpringExtension.class)
class RegisterServiceImplTest {
    @MockBean
    private JavaMailSender javaMailSender;

    @Autowired
    private RegisterServiceImpl registerServiceImpl;

    @MockBean
    private UsersMapper usersMapper;

    @MockBean
    private VarificationMapper varificationMapper;

    /**
     * Method under test: {@link RegisterServiceImpl#academicExist(String)}
     */
    @Test
    void testAcademicExist() {
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(new ArrayList<>());
        assertFalse(registerServiceImpl.academicExist("2050001"));
        verify(usersMapper).selectByExample(Mockito.<UsersExample>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#academicExist(String)}
     */
    @Test
    void testAcademicExist2() {
        Users users = new Users();
        users.setAcademicNumber("42");
        users.setBirthYear(1);
        users.setBonusPoints(1);
        users.setCreatedTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        users.setEmail("jane.doe@example.org");
        users.setLastLoginTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        users.setPassword("iloveyou");
        users.setRealName("academic_number =");
        users.setSex("academic_number =");
        users.setUserAvatar("academic_number =");
        users.setUserId(1L);
        users.setUserName("janedoe");
        users.setUserType((short) 1);

        ArrayList<Users> usersList = new ArrayList<>();
        usersList.add(users);
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(usersList);
        assertTrue(registerServiceImpl.academicExist("42"));
        verify(usersMapper).selectByExample(Mockito.<UsersExample>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#randomCode()}
     */
    @Test
    void testRandomCode() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        registerServiceImpl.randomCode();
    }

    /**
     * Method under test: {@link RegisterServiceImpl#sendEmail(String)}
     */
    @Test
    void testSendEmail() throws MailException {
        doNothing().when(javaMailSender).send(Mockito.<SimpleMailMessage>any());
        registerServiceImpl.sendEmail("jane.doe@example.org");
        verify(javaMailSender).send(Mockito.<SimpleMailMessage>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#verifyAcademicNumber(String, String)}
     */
    @Test
    void testVerifyAcademicNumber() {
        when(varificationMapper.selectByExample(Mockito.<VarificationExample>any())).thenReturn(new ArrayList<>());
        assertFalse(registerServiceImpl.verifyAcademicNumber("42", "Name"));
        verify(varificationMapper).selectByExample(Mockito.<VarificationExample>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#verifyAcademicNumber(String, String)}
     */
    @Test
    void testVerifyAcademicNumber2() {
        Varification varification = new Varification();
        varification.setAcademicNumber("42");
        varification.setName("academic_number =");

        ArrayList<Varification> varificationList = new ArrayList<>();
        varificationList.add(varification);
        when(varificationMapper.selectByExample(Mockito.<VarificationExample>any())).thenReturn(varificationList);
        assertTrue(registerServiceImpl.verifyAcademicNumber("42", "Name"));
        verify(varificationMapper).selectByExample(Mockito.<VarificationExample>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#verifyEmail(String)}
     */
    @Test
    void testVerifyEmail() {
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(new ArrayList<>());
        assertTrue(registerServiceImpl.verifyEmail("jane.doe@example.org"));
        verify(usersMapper).selectByExample(Mockito.<UsersExample>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#verifyEmail(String)}
     */
    @Test
    void testVerifyEmail2() {
        Users users = new Users();
        users.setAcademicNumber("42");
        users.setBirthYear(1);
        users.setBonusPoints(1);
        users.setCreatedTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        users.setEmail("jane.doe@example.org");
        users.setLastLoginTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        users.setPassword("iloveyou");
        users.setRealName("email =");
        users.setSex("email =");
        users.setUserAvatar("email =");
        users.setUserId(1L);
        users.setUserName("janedoe");
        users.setUserType((short) 1);

        ArrayList<Users> usersList = new ArrayList<>();
        usersList.add(users);
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(usersList);
        assertFalse(registerServiceImpl.verifyEmail("jane.doe@example.org"));
        verify(usersMapper).selectByExample(Mockito.<UsersExample>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#insertUser(RegisterDTO)}
     */
    @Test
    void testInsertUser() {
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(new ArrayList<>());
        when(varificationMapper.selectByExample(Mockito.<VarificationExample>any())).thenReturn(new ArrayList<>());

        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setAcademicNumber("42");
        registerDTO.setBirthYear(1);
        registerDTO.setEmail("jane.doe@example.org");
        registerDTO.setPassword("iloveyou");
        registerDTO.setRealName("Real Name");
        registerDTO.setSex("Sex");
        registerDTO.setUserName("janedoe");
        assertFalse(registerServiceImpl.insertUser(registerDTO));
        verify(usersMapper).selectByExample(Mockito.<UsersExample>any());
        verify(varificationMapper).selectByExample(Mockito.<VarificationExample>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#insertUser(RegisterDTO)}
     */
    @Test
    void testInsertUser2() {
        Users users = new Users();
        users.setAcademicNumber("42");
        users.setBirthYear(1);
        users.setBonusPoints(1);
        users.setCreatedTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        users.setEmail("jane.doe@example.org");
        users.setLastLoginTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        users.setPassword("iloveyou");
        users.setRealName("academic_number =");
        users.setSex("academic_number =");
        users.setUserAvatar("academic_number =");
        users.setUserId(1L);
        users.setUserName("janedoe");
        users.setUserType((short) 1);

        ArrayList<Users> usersList = new ArrayList<>();
        usersList.add(users);
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(usersList);

        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setAcademicNumber("42");
        registerDTO.setBirthYear(1);
        registerDTO.setEmail("jane.doe@example.org");
        registerDTO.setPassword("iloveyou");
        registerDTO.setRealName("Real Name");
        registerDTO.setSex("Sex");
        registerDTO.setUserName("janedoe");
        assertFalse(registerServiceImpl.insertUser(registerDTO));
        verify(usersMapper).selectByExample(Mockito.<UsersExample>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#insertUser(RegisterDTO)}
     */
    @Test
    void testInsertUser3() {
        when(usersMapper.insert(Mockito.<Users>any())).thenReturn(1);
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(new ArrayList<>());

        Varification varification = new Varification();
        varification.setAcademicNumber("42");
        varification.setName("academic_number =");

        ArrayList<Varification> varificationList = new ArrayList<>();
        varificationList.add(varification);
        when(varificationMapper.selectByExample(Mockito.<VarificationExample>any())).thenReturn(varificationList);

        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setAcademicNumber("42");
        registerDTO.setBirthYear(1);
        registerDTO.setEmail("jane.doe@example.org");
        registerDTO.setPassword("iloveyou");
        registerDTO.setRealName("Real Name");
        registerDTO.setSex("Sex");
        registerDTO.setUserName("janedoe");
        assertTrue(registerServiceImpl.insertUser(registerDTO));
        verify(usersMapper).insert(Mockito.<Users>any());
        verify(usersMapper, atLeast(1)).selectByExample(Mockito.<UsersExample>any());
        verify(varificationMapper).selectByExample(Mockito.<VarificationExample>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#insertUser(RegisterDTO)}
     */
    @Test
    void testInsertUser4() {
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(new ArrayList<>());

        Varification varification = new Varification();
        varification.setAcademicNumber("42");
        varification.setName("academic_number =");

        ArrayList<Varification> varificationList = new ArrayList<>();
        varificationList.add(varification);
        when(varificationMapper.selectByExample(Mockito.<VarificationExample>any())).thenReturn(varificationList);
        RegisterDTO registerDTO = mock(RegisterDTO.class);
        when(registerDTO.getBirthYear()).thenReturn(1);
        when(registerDTO.getEmail()).thenReturn("jane.doe@example.org");
        when(registerDTO.getSex()).thenReturn("Sex");
        when(registerDTO.getUserName()).thenReturn("cn.tongji.study.dto.RegisterDTO");
        when(registerDTO.getRealName()).thenReturn("Real Name");
        when(registerDTO.getAcademicNumber()).thenReturn("42");
        doNothing().when(registerDTO).setAcademicNumber(Mockito.<String>any());
        doNothing().when(registerDTO).setBirthYear(Mockito.<Integer>any());
        doNothing().when(registerDTO).setEmail(Mockito.<String>any());
        doNothing().when(registerDTO).setPassword(Mockito.<String>any());
        doNothing().when(registerDTO).setRealName(Mockito.<String>any());
        doNothing().when(registerDTO).setSex(Mockito.<String>any());
        doNothing().when(registerDTO).setUserName(Mockito.<String>any());
        registerDTO.setAcademicNumber("42");
        registerDTO.setBirthYear(1);
        registerDTO.setEmail("jane.doe@example.org");
        registerDTO.setPassword("iloveyou");
        registerDTO.setRealName("Real Name");
        registerDTO.setSex("Sex");
        registerDTO.setUserName("janedoe");
        assertFalse(registerServiceImpl.insertUser(registerDTO));
        verify(usersMapper).selectByExample(Mockito.<UsersExample>any());
        verify(varificationMapper).selectByExample(Mockito.<VarificationExample>any());
        verify(registerDTO).getBirthYear();
        verify(registerDTO, atLeast(1)).getAcademicNumber();
        verify(registerDTO).getEmail();
        verify(registerDTO).getRealName();
        verify(registerDTO).getSex();
        verify(registerDTO, atLeast(1)).getUserName();
        verify(registerDTO).setAcademicNumber(Mockito.<String>any());
        verify(registerDTO).setBirthYear(Mockito.<Integer>any());
        verify(registerDTO).setEmail(Mockito.<String>any());
        verify(registerDTO).setPassword(Mockito.<String>any());
        verify(registerDTO).setRealName(Mockito.<String>any());
        verify(registerDTO).setSex(Mockito.<String>any());
        verify(registerDTO).setUserName(Mockito.<String>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#insertUser(RegisterDTO)}
     */
    @Test
    void testInsertUser5() {
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(new ArrayList<>());

        Varification varification = new Varification();
        varification.setAcademicNumber("42");
        varification.setName("academic_number =");

        ArrayList<Varification> varificationList = new ArrayList<>();
        varificationList.add(varification);
        when(varificationMapper.selectByExample(Mockito.<VarificationExample>any())).thenReturn(varificationList);
        RegisterDTO registerDTO = mock(RegisterDTO.class);
        when(registerDTO.getBirthYear()).thenReturn(null);
        when(registerDTO.getEmail()).thenReturn("jane.doe@example.org");
        when(registerDTO.getSex()).thenReturn("Sex");
        when(registerDTO.getUserName()).thenReturn("cn.tongji.study.dto.RegisterDTO");
        when(registerDTO.getRealName()).thenReturn("Real Name");
        when(registerDTO.getAcademicNumber()).thenReturn("42");
        doNothing().when(registerDTO).setAcademicNumber(Mockito.<String>any());
        doNothing().when(registerDTO).setBirthYear(Mockito.<Integer>any());
        doNothing().when(registerDTO).setEmail(Mockito.<String>any());
        doNothing().when(registerDTO).setPassword(Mockito.<String>any());
        doNothing().when(registerDTO).setRealName(Mockito.<String>any());
        doNothing().when(registerDTO).setSex(Mockito.<String>any());
        doNothing().when(registerDTO).setUserName(Mockito.<String>any());
        registerDTO.setAcademicNumber("42");
        registerDTO.setBirthYear(1);
        registerDTO.setEmail("jane.doe@example.org");
        registerDTO.setPassword("iloveyou");
        registerDTO.setRealName("Real Name");
        registerDTO.setSex("Sex");
        registerDTO.setUserName("janedoe");
        assertFalse(registerServiceImpl.insertUser(registerDTO));
        verify(usersMapper).selectByExample(Mockito.<UsersExample>any());
        verify(varificationMapper).selectByExample(Mockito.<VarificationExample>any());
        verify(registerDTO).getBirthYear();
        verify(registerDTO, atLeast(1)).getAcademicNumber();
        verify(registerDTO).getEmail();
        verify(registerDTO).getRealName();
        verify(registerDTO).getSex();
        verify(registerDTO).getUserName();
        verify(registerDTO).setAcademicNumber(Mockito.<String>any());
        verify(registerDTO).setBirthYear(Mockito.<Integer>any());
        verify(registerDTO).setEmail(Mockito.<String>any());
        verify(registerDTO).setPassword(Mockito.<String>any());
        verify(registerDTO).setRealName(Mockito.<String>any());
        verify(registerDTO).setSex(Mockito.<String>any());
        verify(registerDTO).setUserName(Mockito.<String>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#insertUser(RegisterDTO)}
     */
    @Test
    void testInsertUser6() {
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(new ArrayList<>());

        Varification varification = new Varification();
        varification.setAcademicNumber("42");
        varification.setName("academic_number =");

        ArrayList<Varification> varificationList = new ArrayList<>();
        varificationList.add(varification);
        when(varificationMapper.selectByExample(Mockito.<VarificationExample>any())).thenReturn(varificationList);
        RegisterDTO registerDTO = mock(RegisterDTO.class);
        when(registerDTO.getEmail()).thenReturn(null);
        when(registerDTO.getSex()).thenReturn("Sex");
        when(registerDTO.getUserName()).thenReturn("cn.tongji.study.dto.RegisterDTO");
        when(registerDTO.getRealName()).thenReturn("Real Name");
        when(registerDTO.getAcademicNumber()).thenReturn("42");
        doNothing().when(registerDTO).setAcademicNumber(Mockito.<String>any());
        doNothing().when(registerDTO).setBirthYear(Mockito.<Integer>any());
        doNothing().when(registerDTO).setEmail(Mockito.<String>any());
        doNothing().when(registerDTO).setPassword(Mockito.<String>any());
        doNothing().when(registerDTO).setRealName(Mockito.<String>any());
        doNothing().when(registerDTO).setSex(Mockito.<String>any());
        doNothing().when(registerDTO).setUserName(Mockito.<String>any());
        registerDTO.setAcademicNumber("42");
        registerDTO.setBirthYear(1);
        registerDTO.setEmail("jane.doe@example.org");
        registerDTO.setPassword("iloveyou");
        registerDTO.setRealName("Real Name");
        registerDTO.setSex("Sex");
        registerDTO.setUserName("janedoe");
        assertFalse(registerServiceImpl.insertUser(registerDTO));
        verify(usersMapper).selectByExample(Mockito.<UsersExample>any());
        verify(varificationMapper).selectByExample(Mockito.<VarificationExample>any());
        verify(registerDTO, atLeast(1)).getAcademicNumber();
        verify(registerDTO).getEmail();
        verify(registerDTO).getRealName();
        verify(registerDTO).getSex();
        verify(registerDTO).getUserName();
        verify(registerDTO).setAcademicNumber(Mockito.<String>any());
        verify(registerDTO).setBirthYear(Mockito.<Integer>any());
        verify(registerDTO).setEmail(Mockito.<String>any());
        verify(registerDTO).setPassword(Mockito.<String>any());
        verify(registerDTO).setRealName(Mockito.<String>any());
        verify(registerDTO).setSex(Mockito.<String>any());
        verify(registerDTO).setUserName(Mockito.<String>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#insertUser(RegisterDTO)}
     */
    @Test
    void testInsertUser7() {
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(new ArrayList<>());

        Varification varification = new Varification();
        varification.setAcademicNumber("42");
        varification.setName("academic_number =");

        ArrayList<Varification> varificationList = new ArrayList<>();
        varificationList.add(varification);
        when(varificationMapper.selectByExample(Mockito.<VarificationExample>any())).thenReturn(varificationList);
        RegisterDTO registerDTO = mock(RegisterDTO.class);
        when(registerDTO.getSex()).thenReturn(null);
        when(registerDTO.getUserName()).thenReturn("cn.tongji.study.dto.RegisterDTO");
        when(registerDTO.getRealName()).thenReturn("Real Name");
        when(registerDTO.getAcademicNumber()).thenReturn("42");
        doNothing().when(registerDTO).setAcademicNumber(Mockito.<String>any());
        doNothing().when(registerDTO).setBirthYear(Mockito.<Integer>any());
        doNothing().when(registerDTO).setEmail(Mockito.<String>any());
        doNothing().when(registerDTO).setPassword(Mockito.<String>any());
        doNothing().when(registerDTO).setRealName(Mockito.<String>any());
        doNothing().when(registerDTO).setSex(Mockito.<String>any());
        doNothing().when(registerDTO).setUserName(Mockito.<String>any());
        registerDTO.setAcademicNumber("42");
        registerDTO.setBirthYear(1);
        registerDTO.setEmail("jane.doe@example.org");
        registerDTO.setPassword("iloveyou");
        registerDTO.setRealName("Real Name");
        registerDTO.setSex("Sex");
        registerDTO.setUserName("janedoe");
        assertFalse(registerServiceImpl.insertUser(registerDTO));
        verify(usersMapper).selectByExample(Mockito.<UsersExample>any());
        verify(varificationMapper).selectByExample(Mockito.<VarificationExample>any());
        verify(registerDTO, atLeast(1)).getAcademicNumber();
        verify(registerDTO).getRealName();
        verify(registerDTO).getSex();
        verify(registerDTO).getUserName();
        verify(registerDTO).setAcademicNumber(Mockito.<String>any());
        verify(registerDTO).setBirthYear(Mockito.<Integer>any());
        verify(registerDTO).setEmail(Mockito.<String>any());
        verify(registerDTO).setPassword(Mockito.<String>any());
        verify(registerDTO).setRealName(Mockito.<String>any());
        verify(registerDTO).setSex(Mockito.<String>any());
        verify(registerDTO).setUserName(Mockito.<String>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#insertUser(RegisterDTO)}
     */
    @Test
    void testInsertUser8() {
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(new ArrayList<>());

        Varification varification = new Varification();
        varification.setAcademicNumber("42");
        varification.setName("academic_number =");

        ArrayList<Varification> varificationList = new ArrayList<>();
        varificationList.add(varification);
        when(varificationMapper.selectByExample(Mockito.<VarificationExample>any())).thenReturn(varificationList);
        RegisterDTO registerDTO = mock(RegisterDTO.class);
        when(registerDTO.getUserName()).thenReturn(null);
        when(registerDTO.getRealName()).thenReturn("Real Name");
        when(registerDTO.getAcademicNumber()).thenReturn("42");
        doNothing().when(registerDTO).setAcademicNumber(Mockito.<String>any());
        doNothing().when(registerDTO).setBirthYear(Mockito.<Integer>any());
        doNothing().when(registerDTO).setEmail(Mockito.<String>any());
        doNothing().when(registerDTO).setPassword(Mockito.<String>any());
        doNothing().when(registerDTO).setRealName(Mockito.<String>any());
        doNothing().when(registerDTO).setSex(Mockito.<String>any());
        doNothing().when(registerDTO).setUserName(Mockito.<String>any());
        registerDTO.setAcademicNumber("42");
        registerDTO.setBirthYear(1);
        registerDTO.setEmail("jane.doe@example.org");
        registerDTO.setPassword("iloveyou");
        registerDTO.setRealName("Real Name");
        registerDTO.setSex("Sex");
        registerDTO.setUserName("janedoe");
        assertFalse(registerServiceImpl.insertUser(registerDTO));
        verify(usersMapper).selectByExample(Mockito.<UsersExample>any());
        verify(varificationMapper).selectByExample(Mockito.<VarificationExample>any());
        verify(registerDTO, atLeast(1)).getAcademicNumber();
        verify(registerDTO).getRealName();
        verify(registerDTO).getUserName();
        verify(registerDTO).setAcademicNumber(Mockito.<String>any());
        verify(registerDTO).setBirthYear(Mockito.<Integer>any());
        verify(registerDTO).setEmail(Mockito.<String>any());
        verify(registerDTO).setPassword(Mockito.<String>any());
        verify(registerDTO).setRealName(Mockito.<String>any());
        verify(registerDTO).setSex(Mockito.<String>any());
        verify(registerDTO).setUserName(Mockito.<String>any());
    }

    /**
     * Method under test: {@link RegisterServiceImpl#insertUser(RegisterDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInsertUser9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: Value for name cannot be null
        //       at cn.tongji.study.model.VarificationExample$GeneratedCriteria.addCriterion(VarificationExample.java:95)
        //       at cn.tongji.study.model.VarificationExample$GeneratedCriteria.andNameEqualTo(VarificationExample.java:188)
        //       at cn.tongji.study.model.VarificationExample$Criteria.andNameEqualTo(VarificationExample.java:248)
        //       at cn.tongji.study.service.impl.RegisterServiceImpl.verifyAcademicNumber(RegisterServiceImpl.java:89)
        //       at cn.tongji.study.service.impl.RegisterServiceImpl.insertUser(RegisterServiceImpl.java:107)
        //   See https://diff.blue/R013 to resolve this issue.

        when(usersMapper.insert(Mockito.<Users>any())).thenReturn(1);
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(new ArrayList<>());

        Varification varification = new Varification();
        varification.setAcademicNumber("42");
        varification.setName("academic_number =");

        ArrayList<Varification> varificationList = new ArrayList<>();
        varificationList.add(varification);
        when(varificationMapper.selectByExample(Mockito.<VarificationExample>any())).thenReturn(varificationList);
        RegisterDTO registerDTO = mock(RegisterDTO.class);
        when(registerDTO.getBirthYear()).thenReturn(1);
        when(registerDTO.getEmail()).thenReturn("jane.doe@example.org");
        when(registerDTO.getSex()).thenReturn("Sex");
        when(registerDTO.getUserName()).thenReturn("cn.tongji.study.dto.RegisterDTO");
        when(registerDTO.getRealName()).thenReturn(null);
        when(registerDTO.getAcademicNumber()).thenReturn("42");
        doNothing().when(registerDTO).setAcademicNumber(Mockito.<String>any());
        doNothing().when(registerDTO).setBirthYear(Mockito.<Integer>any());
        doNothing().when(registerDTO).setEmail(Mockito.<String>any());
        doNothing().when(registerDTO).setPassword(Mockito.<String>any());
        doNothing().when(registerDTO).setRealName(Mockito.<String>any());
        doNothing().when(registerDTO).setSex(Mockito.<String>any());
        doNothing().when(registerDTO).setUserName(Mockito.<String>any());
        registerDTO.setAcademicNumber("42");
        registerDTO.setBirthYear(1);
        registerDTO.setEmail("jane.doe@example.org");
        registerDTO.setPassword("iloveyou");
        registerDTO.setRealName("Real Name");
        registerDTO.setSex("Sex");
        registerDTO.setUserName("janedoe");
        registerServiceImpl.insertUser(registerDTO);
    }

    /**
     * Method under test: {@link RegisterServiceImpl#insertUser(RegisterDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInsertUser10() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: Value for academicNumber cannot be null
        //       at cn.tongji.study.model.UsersExample$GeneratedCriteria.addCriterion(UsersExample.java:96)
        //       at cn.tongji.study.model.UsersExample$GeneratedCriteria.andAcademicNumberEqualTo(UsersExample.java:509)
        //       at cn.tongji.study.model.UsersExample$Criteria.andAcademicNumberEqualTo(UsersExample.java:889)
        //       at cn.tongji.study.service.impl.RegisterServiceImpl.academicExist(RegisterServiceImpl.java:48)
        //       at cn.tongji.study.service.impl.RegisterServiceImpl.insertUser(RegisterServiceImpl.java:104)
        //   See https://diff.blue/R013 to resolve this issue.

        when(usersMapper.insert(Mockito.<Users>any())).thenReturn(1);
        when(usersMapper.selectByExample(Mockito.<UsersExample>any())).thenReturn(new ArrayList<>());

        Varification varification = new Varification();
        varification.setAcademicNumber("42");
        varification.setName("academic_number =");

        ArrayList<Varification> varificationList = new ArrayList<>();
        varificationList.add(varification);
        when(varificationMapper.selectByExample(Mockito.<VarificationExample>any())).thenReturn(varificationList);
        RegisterDTO registerDTO = mock(RegisterDTO.class);
        when(registerDTO.getBirthYear()).thenReturn(1);
        when(registerDTO.getEmail()).thenReturn("jane.doe@example.org");
        when(registerDTO.getSex()).thenReturn("Sex");
        when(registerDTO.getUserName()).thenReturn("cn.tongji.study.dto.RegisterDTO");
        when(registerDTO.getRealName()).thenReturn("Real Name");
        when(registerDTO.getAcademicNumber()).thenReturn(null);
        doNothing().when(registerDTO).setAcademicNumber(Mockito.<String>any());
        doNothing().when(registerDTO).setBirthYear(Mockito.<Integer>any());
        doNothing().when(registerDTO).setEmail(Mockito.<String>any());
        doNothing().when(registerDTO).setPassword(Mockito.<String>any());
        doNothing().when(registerDTO).setRealName(Mockito.<String>any());
        doNothing().when(registerDTO).setSex(Mockito.<String>any());
        doNothing().when(registerDTO).setUserName(Mockito.<String>any());
        registerDTO.setAcademicNumber("42");
        registerDTO.setBirthYear(1);
        registerDTO.setEmail("jane.doe@example.org");
        registerDTO.setPassword("iloveyou");
        registerDTO.setRealName("Real Name");
        registerDTO.setSex("Sex");
        registerDTO.setUserName("janedoe");
        registerServiceImpl.insertUser(registerDTO);
    }
}

