package cn.tongji.study.mapper;

import cn.tongji.study.model.Reports;
import cn.tongji.study.model.ReportsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportsMapper {
    long countByExample(ReportsExample example);

    int deleteByExample(ReportsExample example);

    int deleteByPrimaryKey(Long reportId);

    int insert(Reports record);

    int insertSelective(Reports record);

    List<Reports> selectByExample(ReportsExample example);

    Reports selectByPrimaryKey(Long reportId);

    int updateByExampleSelective(@Param("record") Reports record, @Param("example") ReportsExample example);

    int updateByExample(@Param("record") Reports record, @Param("example") ReportsExample example);

    int updateByPrimaryKeySelective(Reports record);

    int updateByPrimaryKey(Reports record);
}