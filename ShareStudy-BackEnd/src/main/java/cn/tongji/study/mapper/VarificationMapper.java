package cn.tongji.study.mapper;

import cn.tongji.study.model.Varification;
import cn.tongji.study.model.VarificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VarificationMapper {
    long countByExample(VarificationExample example);

    int deleteByExample(VarificationExample example);

    int insert(Varification record);

    int insertSelective(Varification record);

    List<Varification> selectByExample(VarificationExample example);

    int updateByExampleSelective(@Param("record") Varification record, @Param("example") VarificationExample example);

    int updateByExample(@Param("record") Varification record, @Param("example") VarificationExample example);
}