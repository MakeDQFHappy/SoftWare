package cn.tongji.study.dto;

import lombok.Data;

@Data
public class QuestionDTO {
    Long questionid;
    Long questionaskerid;
    String questioncontent;
    Integer rewardpoints;
    String questionheader;
    String labels;
}
