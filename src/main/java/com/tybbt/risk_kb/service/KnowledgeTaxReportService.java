package com.tybbt.risk_kb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tybbt.risk_kb.domain.TaxReport;
import com.tybbt.risk_kb.domain.TaxReportExample;
import com.tybbt.risk_kb.mapper.TaxReportMapper;
import com.tybbt.risk_kb.req.TaxReportListReq;
import com.tybbt.risk_kb.req.TaxReportSaveReq;
import com.tybbt.risk_kb.resp.PageResp;
import com.tybbt.risk_kb.resp.TaxReportListResp;
import com.tybbt.risk_kb.util.CopyUtil;
import com.tybbt.risk_kb.util.SnowFlake;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class KnowledgeTaxReportService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    @Resource
    private SnowFlake snowFlake;

    @Resource
    private TaxReportMapper taxReportMapper;

    public PageResp<TaxReportListResp> list(TaxReportListReq req){
        TaxReportExample taxReportExample = new TaxReportExample();
        TaxReportExample.Criteria criteria = taxReportExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<TaxReport> resultList = taxReportMapper.selectByExample(taxReportExample);

        PageInfo<TaxReport> pageInfo = new PageInfo<>(resultList);
        LOG.info("总行数： {}", pageInfo.getTotal());
        LOG.info("总页数： {}", pageInfo.getPages());
        List<TaxReportListResp> list = CopyUtil.copyList(resultList, TaxReportListResp.class);
        PageResp<TaxReportListResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    public void save(TaxReportSaveReq req) {
        TaxReport record = CopyUtil.copy(req, TaxReport.class);
        if (ObjectUtils.isEmpty(record.getId())) {
            // 自增，uuid，雪花
            record.setId(snowFlake.nextId());
            taxReportMapper.insert(record);
        } else {
            taxReportMapper.updateByPrimaryKey(record);
        }
    }

    public void delete(Long id) {
        taxReportMapper.deleteByPrimaryKey(id);
    }
}
