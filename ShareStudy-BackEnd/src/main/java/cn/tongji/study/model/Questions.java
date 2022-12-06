package cn.tongji.study.model;

import java.io.Serializable;
import java.util.Date;

public class Questions implements Serializable {
    private Long questionId;

    private Long questionAskerId;

    private Integer rewardPoints;

    private String questionHeader;

    private Date createTime;

    private Boolean hasAdoptedAnswer;

    private Boolean hasAnswerer;

    private String questionContent;

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

    public String getQuestionHeader() {
        return questionHeader;
    }

    public void setQuestionHeader(String questionHeader) {
        this.questionHeader = questionHeader;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getHasAdoptedAnswer() {
        return hasAdoptedAnswer;
    }

    public void setHasAdoptedAnswer(Boolean hasAdoptedAnswer) {
        this.hasAdoptedAnswer = hasAdoptedAnswer;
    }

    public Boolean getHasAnswerer() {
        return hasAnswerer;
    }

    public void setHasAnswerer(Boolean hasAnswerer) {
        this.hasAnswerer = hasAnswerer;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
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
        sb.append(", questionHeader=").append(questionHeader);
        sb.append(", createTime=").append(createTime);
        sb.append(", hasAdoptedAnswer=").append(hasAdoptedAnswer);
        sb.append(", hasAnswerer=").append(hasAnswerer);
        sb.append(", questionContent=").append(questionContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}