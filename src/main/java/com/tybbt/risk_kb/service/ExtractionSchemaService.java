package com.tybbt.risk_kb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tybbt.risk_kb.domain.ExtractionSchema;
import com.tybbt.risk_kb.domain.ExtractionSchemaExample;
import com.tybbt.risk_kb.mapper.ExtractionSchemaMapper;
import com.tybbt.risk_kb.req.ExtractionSchemaQueryReq;
import com.tybbt.risk_kb.resp.ExtractionSchemaListResp;
import com.tybbt.risk_kb.resp.PageResp;
import com.tybbt.risk_kb.util.CopyUtil;
import com.tybbt.risk_kb.util.SnowFlake;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtractionSchemaService {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    @Resource
    private SnowFlake snowFlake;
    @Resource
    private ExtractionSchemaMapper extractionSchemaMapper;

    public PageResp<ExtractionSchemaListResp> list(ExtractionSchemaQueryReq req) {
        ExtractionSchemaExample extractionSchemaExample = new ExtractionSchemaExample();
        ExtractionSchemaExample.Criteria criteria = extractionSchemaExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        // 调用CategoryMapper的list方法
        List<ExtractionSchema> extractionSchemaList = extractionSchemaMapper.selectByExample(extractionSchemaExample);

        PageInfo<ExtractionSchema> pageInfo = new PageInfo<>(extractionSchemaList);
        LOG.info("总行数： {}", pageInfo.getTotal());
        LOG.info("总页数： {}", pageInfo.getPages());

        // 列表复制
        List<ExtractionSchemaListResp> list = CopyUtil.copyList(extractionSchemaList, ExtractionSchemaListResp.class);

        PageResp<ExtractionSchemaListResp> pageResp = new PageResp<>();

        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    public List<ExtractionSchemaListResp> search(Long kid) {
        ExtractionSchemaExample extractionSchemaExample = new ExtractionSchemaExample();
        ExtractionSchemaExample.Criteria crietria = extractionSchemaExample.createCriteria();
        crietria.andRelateKnowledgeEqualTo(kid);
        List<ExtractionSchema> extractionSchemaList =  extractionSchemaMapper.selectByExample(extractionSchemaExample);
        return CopyUtil.copyList(extractionSchemaList, ExtractionSchemaListResp.class);
    }


    public void delete(Long id) {
        extractionSchemaMapper.deleteByPrimaryKey(id);

    }
}
