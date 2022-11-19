package cn.tongji.study.model;

import java.io.Serializable;
import java.util.Date;

public class FriendApplications implements Serializable {
    private Long applicationId;

    private Long applicantId;

    private Long receiverId;

    private Short status;

    private Date createTime;

    private String introduction;

    private static final long serialVersionUID = 1L;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", applicationId=").append(applicationId);
        sb.append(", applicantId=").append(applicantId);
        sb.append(", receiverId=").append(receiverId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", introduction=").append(introduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}