package com.tybbt.risk_kb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tybbt.risk_kb.domain.TaxMisreport;
import com.tybbt.risk_kb.domain.TaxMisreportExample;
import com.tybbt.risk_kb.mapper.TaxMisreportMapper;
import com.tybbt.risk_kb.req.TaxMisreportListReq;
import com.tybbt.risk_kb.req.TaxMisreportSaveReq;
import com.tybbt.risk_kb.resp.PageResp;
import com.tybbt.risk_kb.resp.TaxMisreportListResp;
import com.tybbt.risk_kb.util.CopyUtil;
import com.tybbt.risk_kb.util.SnowFlake;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class KnowledgeTaxMisreportService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    @Resource
    private SnowFlake snowFlake;

    @Resource
    private TaxMisreportMapper taxMisreportMapper;

    public PageResp<TaxMisreportListResp> list(TaxMisreportListReq req){
        TaxMisreportExample taxMisreportExample = new TaxMisreportExample();
        TaxMisreportExample.Criteria criteria = taxMisreportExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<TaxMisreport> resultList = taxMisreportMapper.selectByExample(taxMisreportExample);

        PageInfo<TaxMisreport> pageInfo = new PageInfo<>(resultList);
        LOG.info("总行数： {}", pageInfo.getTotal());
        LOG.info("总页数： {}", pageInfo.getPages());
        List<TaxMisreportListResp> list = CopyUtil.copyList(resultList, TaxMisreportListResp.class);
        PageResp<TaxMisreportListResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    public void save(TaxMisreportSaveReq req) {
        TaxMisreport record = CopyUtil.copy(req, TaxMisreport.class);
        if (ObjectUtils.isEmpty(record.getId())) {
            // 自增，uuid，雪花
            record.setId(snowFlake.nextId());
            taxMisreportMapper.insert(record);
        } else {
            taxMisreportMapper.updateByPrimaryKey(record);
        }
    }

    public void delete(Long id) {
        taxMisreportMapper.deleteByPrimaryKey(id);
    }
}
