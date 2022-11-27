package cn.tongji.study.model;

import java.io.Serializable;
import java.util.Date;

public class Questions implements Serializable {
    private Long questionId;

    private Long questionAskerId;

    private Integer rewardPoints;

    private Date createTime;

    private String questionContent;

    private String questionHeader;

    private static final long serialVersionUID = 1L;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getQuestionAskerId() {
        return questionAskerId;
    }

    public void setQuestionAskerId(Long questionAskerId) {
        this.questionAskerId = questionAskerId;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionHeader() {
        return questionHeader;
    }

    public void setQuestionHeader(String questionHeader) {
        this.questionHeader = questionHeader;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", questionId=").append(questionId);
        sb.append(", questionAskerId=").append(questionAskerId);
        sb.append(", rewardPoints=").append(rewardPoints);
        sb.append(", createTime=").append(createTime);
        sb.append(", questionContent=").append(questionContent);
        sb.append(", questionHeader=").append(questionHeader);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}