package cn.tongji.study.model;

import java.io.Serializable;

public class Question implements Serializable {
    private Long questionId;

    private Long questionAskerId;

    private Integer rewardPoints;

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
        sb.append(", questionContent=").append(questionContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}