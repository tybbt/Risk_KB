package com.tybbt.risk_kb.mapper;

import com.tybbt.risk_kb.domain.TaxMisreport;
import com.tybbt.risk_kb.domain.TaxMisreportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaxMisreportMapper {
    long countByExample(TaxMisreportExample example);

    int deleteByExample(TaxMisreportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaxMisreport record);

    int insertSelective(TaxMisreport record);

    List<TaxMisreport> selectByExample(TaxMisreportExample example);

    TaxMisreport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaxMisreport record, @Param("example") TaxMisreportExample example);

    int updateByExample(@Param("record") TaxMisreport record, @Param("example") TaxMisreportExample example);

    int updateByPrimaryKeySelective(TaxMisreport record);

    int updateByPrimaryKey(TaxMisreport record);
}