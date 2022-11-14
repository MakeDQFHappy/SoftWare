package cn.tongji.study.model;

import java.io.Serializable;

public class Answer implements Serializable {
    private Long answerId;

    private Long answererId;

    private Long questionId;

    private Boolean adopted;

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
        sb.append(", answerContent=").append(answerContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}