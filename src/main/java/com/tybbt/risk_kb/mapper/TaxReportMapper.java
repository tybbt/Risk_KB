package com.tybbt.risk_kb.mapper;

import com.tybbt.risk_kb.domain.TaxReport;
import com.tybbt.risk_kb.domain.TaxReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaxReportMapper {
    long countByExample(TaxReportExample example);

    int deleteByExample(TaxReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaxReport record);

    int insertSelective(TaxReport record);

    List<TaxReport> selectByExample(TaxReportExample example);

    TaxReport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaxReport record, @Param("example") TaxReportExample example);

    int updateByExample(@Param("record") TaxReport record, @Param("example") TaxReportExample example);

    int updateByPrimaryKeySelective(TaxReport record);

    int updateByPrimaryKey(TaxReport record);
}