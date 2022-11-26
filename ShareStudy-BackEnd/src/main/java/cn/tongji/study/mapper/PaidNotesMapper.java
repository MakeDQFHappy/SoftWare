package cn.tongji.study.mapper;

import cn.tongji.study.model.PaidNotes;
import cn.tongji.study.model.PaidNotesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaidNotesMapper {
    long countByExample(PaidNotesExample example);

    int deleteByExample(PaidNotesExample example);

    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("noteId") Long noteId);

    int insert(PaidNotes record);

    int insertSelective(PaidNotes record);

    List<PaidNotes> selectByExample(PaidNotesExample example);

    int updateByExampleSelective(@Param("record") PaidNotes record, @Param("example") PaidNotesExample example);

    int updateByExample(@Param("record") PaidNotes record, @Param("example") PaidNotesExample example);
}