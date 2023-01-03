package cn.tongji.study.model;

import java.io.Serializable;
import java.util.Date;

public class Answers implements Serializable {
    private Long answerId;

    private Long answererId;

    private Long questionId;

    private Boolean adopted;

    private Date createTime;

    private Boolean hasComment;

    private String answerContent;

    private static final long serialVersionUID = 1L;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getAnswererId() {
        return answererId;
    }

    public void setAnswererId(Long answererId) {
        this.answererId = answererId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Boolean getAdopted() {
        return adopted;
    }

    public void setAdopted(Boolean adopted) {
        this.adopted = adopted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getHasComment() {
        return hasComment;
    }

    public void setHasComment(Boolean hasComment) {
        this.hasComment = hasComment;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", answerId=").append(answerId);
        sb.append(", answererId=").append(answererId);
        sb.append(", questionId=").append(questionId);
        sb.append(", adopted=").append(adopted);
        sb.append(", createTime=").append(createTime);
        sb.append(", hasComment=").append(hasComment);
        sb.append(", answerContent=").append(answerContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}