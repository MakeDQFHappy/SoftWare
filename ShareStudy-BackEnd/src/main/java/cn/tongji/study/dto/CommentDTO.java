package cn.tongji.study.dto;

import lombok.Data;

@Data
public class CommentDTO {
    Long commentid;
    Long commenterid;
    String commentcontent;
    Long targetid;
    String commentername;
    String commenteravatar;
    Boolean isliked;
    Boolean likenum;
}
