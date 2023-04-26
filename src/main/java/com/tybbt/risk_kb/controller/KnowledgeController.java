package com.tybbt.risk_kb.controller;

import com.tybbt.risk_kb.domain.KnowledgeManagement;
import com.tybbt.risk_kb.resp.CommonResp;
import com.tybbt.risk_kb.service.KnowledgeManagementService;
import com.tybbt.risk_kb.util.SnowFlake;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Knowledge")
public class KnowledgeController {
    @Resource
    private SnowFlake snowFlake;
    @Resource
    private KnowledgeManagementService knowledgeManagementService;
    // 管理 -> 提供统计、提供知识的内容
    @GetMapping("/management/list")
    public CommonResp<List<KnowledgeManagement>> list() {
        CommonResp<List<KnowledgeManagement>> resp = new CommonResp<>();
        List<KnowledgeManagement> kML = knowledgeManagementService.list();
        resp.setContent(kML);
        return resp;
    }

    @GetMapping("/management/search")
    public CommonResp<List<KnowledgeManagement>> search(String name) {
        CommonResp<List<KnowledgeManagement>> resp = new CommonResp<>();
        List<KnowledgeManagement> kml = knowledgeManagementService.search(name);
        resp.setContent(kml);
        return resp;
    }
}
