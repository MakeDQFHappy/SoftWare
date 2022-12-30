package cn.tongji.study.dto;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionDTO {
    Long questionid;
    Long questionaskerid;
    String questioncontent;
    Integer rewardpoints;
    String questionheader;
    Boolean hasanswerer;
    Boolean hasadoptedanswer=false;
    Date createtime;
}
