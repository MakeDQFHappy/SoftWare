package cn.tongji.study.model;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
    private Long userId;

    private Date createdTime;

    private String userName;

    private Integer bonusPoints;

    private String email;

    private String sex;

    private String academicNumber;

    private Short userType;

    private Date lastLoginTime;

    private Integer birthYear;

    private String password;

    private String realName;

    private String userAvatar;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(Integer bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAcademicNumber() {
        return academicNumber;
    }

    public void setAcademicNumber(String academicNumber) {
        this.academicNumber = academicNumber;
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", userName=").append(userName);
        sb.append(", bonusPoints=").append(bonusPoints);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", academicNumber=").append(academicNumber);
        sb.append(", userType=").append(userType);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", birthYear=").append(birthYear);
        sb.append(", password=").append(password);
        sb.append(", realName=").append(realName);
        sb.append(", userAvatar=").append(userAvatar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}