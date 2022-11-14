package cn.tongji.study.model;

import java.io.Serializable;

public class StudyNotes implements Serializable {
    private Long studyNoteId;

    private Long sharerId;

    private Integer points;

    private String noteContent;

    private static final long serialVersionUID = 1L;

    public Long getStudyNoteId() {
        return studyNoteId;
    }

    public void setStudyNoteId(Long studyNoteId) {
        this.studyNoteId = studyNoteId;
    }

    public Long getSharerId() {
        return sharerId;
    }

    public void setSharerId(Long sharerId) {
        this.sharerId = sharerId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studyNoteId=").append(studyNoteId);
        sb.append(", sharerId=").append(sharerId);
        sb.append(", points=").append(points);
        sb.append(", noteContent=").append(noteContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}