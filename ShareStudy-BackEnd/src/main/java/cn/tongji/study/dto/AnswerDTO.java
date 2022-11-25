package cn.tongji.study.dto;

import lombok.Data;

@Data
public class AnswerDTO {
    Long answerid;
    Long answererid;
    String answercontent;
    Long questionid;
    Boolean adopted;
    String answerername;
    String answereravatar;
}
