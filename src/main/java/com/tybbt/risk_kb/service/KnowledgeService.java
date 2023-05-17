package com.tybbt.risk_kb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tybbt.risk_kb.domain.Knowledge;
import com.tybbt.risk_kb.domain.KnowledgeExample;
import com.tybbt.risk_kb.mapper.KnowledgeMapper;
import com.tybbt.risk_kb.req.KnowledgeQueryReq;
import com.tybbt.risk_kb.req.KnowledgeSaveReq;
import com.tybbt.risk_kb.resp.KnowledgeQueryResp;
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
public class KnowledgeService {
    private static final Logger LOG = LoggerFactory.getLogger(KnowledgeService.class);
    @Resource
    private KnowledgeMapper knowledgeMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<KnowledgeQueryResp> list(KnowledgeQueryReq req) {
        KnowledgeExample knowledgeExample = new KnowledgeExample();
        KnowledgeExample.Criteria criteria = knowledgeExample.createCriteria();
        criteria.andKidEqualTo(req.getKid());
        PageHelper.startPage(req.getPage(), req.getSize());
        // 调用CategoryMapper的list方法
        List<Knowledge> knowledgeList = knowledgeMapper.selectByExample(knowledgeExample);

        PageInfo<Knowledge> pageInfo = new PageInfo<>(knowledgeList);
        LOG.info("总行数： {}", pageInfo.getTotal());
        LOG.info("总页数： {}", pageInfo.getPages());

        // 列表复制
        List<KnowledgeQueryResp> list = CopyUtil.copyList(knowledgeList, KnowledgeQueryResp.class);

        PageResp<KnowledgeQueryResp> pageResp = new PageResp<>();

        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    public void save(KnowledgeSaveReq req) {
        Knowledge knowledge = CopyUtil.copy(req, Knowledge.class);
        if (ObjectUtils.isEmpty(knowledge.getId())) {
            // 自增，uuid，雪花
            knowledge.setId(snowFlake.nextId());
            knowledgeMapper.insert(knowledge);
        } else {
            knowledgeMapper.updateByPrimaryKey(knowledge);
        }
    }

    public void delete(Long id) {
        knowledgeMapper.deleteByPrimaryKey(id);
    }

}
