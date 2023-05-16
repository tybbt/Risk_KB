package com.tybbt.risk_kb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tybbt.risk_kb.domain.CommodityInformation;
import com.tybbt.risk_kb.domain.CommodityInformationExample;
import com.tybbt.risk_kb.mapper.CommodityInformationMapper;
import com.tybbt.risk_kb.req.CommodityInfoListReq;
import com.tybbt.risk_kb.req.CommodityInfoSaveReq;
import com.tybbt.risk_kb.resp.CommodityInfoListResp;
import com.tybbt.risk_kb.resp.PageResp;
import com.tybbt.risk_kb.util.CopyUtil;
import com.tybbt.risk_kb.util.SnowFlake;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class KnowledgeCommodityService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    @Resource
    private SnowFlake snowFlake;

    @Resource
    private CommodityInformationMapper commodityInformationMapper;

    public PageResp<CommodityInfoListResp> list(CommodityInfoListReq req){
        CommodityInformationExample commodityInformationExample = new CommodityInformationExample();
        CommodityInformationExample.Criteria criteria = commodityInformationExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<CommodityInformation> resultList = commodityInformationMapper.selectByExample(commodityInformationExample);

        PageInfo<CommodityInformation> pageInfo = new PageInfo<>(resultList);
        LOG.info("总行数： {}", pageInfo.getTotal());
        LOG.info("总页数： {}", pageInfo.getPages());
        List<CommodityInfoListResp> list = CopyUtil.copyList(resultList, CommodityInfoListResp.class);
        PageResp<CommodityInfoListResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    public void save(CommodityInfoSaveReq req) {
        CommodityInformation record = CopyUtil.copy(req, CommodityInformation.class);
        if (ObjectUtils.isEmpty(record.getId())) {
            // 自增，uuid，雪花
            record.setId(snowFlake.nextId());
            commodityInformationMapper.insert(record);
        } else {
            commodityInformationMapper.updateByPrimaryKey(record);
        }
    }

    public void delete(Long id) {
        commodityInformationMapper.deleteByPrimaryKey(id);
    }
}
