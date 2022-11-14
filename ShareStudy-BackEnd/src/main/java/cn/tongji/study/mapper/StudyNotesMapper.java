package cn.tongji.study.mapper;

import cn.tongji.study.model.StudyNotes;
import cn.tongji.study.model.StudyNotesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudyNotesMapper {
    long countByExample(StudyNotesExample example);

    int deleteByExample(StudyNotesExample example);

    int deleteByPrimaryKey(Long studyNoteId);

    int insert(StudyNotes record);

    int insertSelective(StudyNotes record);

    List<StudyNotes> selectByExampleWithBLOBs(StudyNotesExample example);

    List<StudyNotes> selectByExample(StudyNotesExample example);

    StudyNotes selectByPrimaryKey(Long studyNoteId);

    int updateByExampleSelective(@Param("record") StudyNotes record, @Param("example") StudyNotesExample example);

    int updateByExampleWithBLOBs(@Param("record") StudyNotes record, @Param("example") StudyNotesExample example);

    int updateByExample(@Param("record") StudyNotes record, @Param("example") StudyNotesExample example);

    int updateByPrimaryKeySelective(StudyNotes record);

    int updateByPrimaryKeyWithBLOBs(StudyNotes record);

    int updateByPrimaryKey(StudyNotes record);
}