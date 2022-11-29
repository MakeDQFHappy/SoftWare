package cn.tongji.study.dto;

import lombok.Data;

@Data
public class LikeDTO {
    Long likeid;
    Long targetid;
    Long userid;
}
