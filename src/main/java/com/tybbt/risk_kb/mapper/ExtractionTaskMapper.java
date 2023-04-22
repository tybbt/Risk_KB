package com.tybbt.risk_kb.mapper;

import com.tybbt.risk_kb.domain.ExtractionTask;
import com.tybbt.risk_kb.domain.ExtractionTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExtractionTaskMapper {
    long countByExample(ExtractionTaskExample example);

    int deleteByExample(ExtractionTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExtractionTask record);

    int insertSelective(ExtractionTask record);

    List<ExtractionTask> selectByExample(ExtractionTaskExample example);

    ExtractionTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExtractionTask record, @Param("example") ExtractionTaskExample example);

    int updateByExample(@Param("record") ExtractionTask record, @Param("example") ExtractionTaskExample example);

    int updateByPrimaryKeySelective(ExtractionTask record);

    int updateByPrimaryKey(ExtractionTask record);
}