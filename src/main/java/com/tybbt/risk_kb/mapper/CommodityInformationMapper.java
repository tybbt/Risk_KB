package com.tybbt.risk_kb.mapper;

import com.tybbt.risk_kb.domain.CommodityInformation;
import com.tybbt.risk_kb.domain.CommodityInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityInformationMapper {
    long countByExample(CommodityInformationExample example);

    int deleteByExample(CommodityInformationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommodityInformation record);

    int insertSelective(CommodityInformation record);

    List<CommodityInformation> selectByExample(CommodityInformationExample example);

    CommodityInformation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommodityInformation record, @Param("example") CommodityInformationExample example);

    int updateByExample(@Param("record") CommodityInformation record, @Param("example") CommodityInformationExample example);

    int updateByPrimaryKeySelective(CommodityInformation record);

    int updateByPrimaryKey(CommodityInformation record);
}