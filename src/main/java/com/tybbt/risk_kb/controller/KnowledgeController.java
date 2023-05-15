package com.tybbt.risk_kb.controller;

import com.tybbt.risk_kb.domain.KnowledgeManagement;
import com.tybbt.risk_kb.req.*;
import com.tybbt.risk_kb.resp.CommonResp;
import com.tybbt.risk_kb.resp.PageResp;
import com.tybbt.risk_kb.resp.TaxMisreportListResp;
import com.tybbt.risk_kb.resp.TaxReportListResp;
import com.tybbt.risk_kb.service.KnowledgeManagementService;
import com.tybbt.risk_kb.service.KnowledgeTaxMisreportService;
import com.tybbt.risk_kb.service.KnowledgeTaxReportService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {

    // 风险知识管理 -> 提供统计、提供知识的内容
    @Resource
    private KnowledgeManagementService knowledgeManagementService;

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

    @PostMapping("/management/save")
    public CommonResp saveTopKnowledge(@RequestBody KnowledgeManagementSaveReq req) {
        CommonResp resp = new CommonResp<>();
        knowledgeManagementService.save(req);
        return resp;
    }

    @DeleteMapping("/management/delete/{id}")
    public CommonResp deleteTopKnowledge(@PathVariable Long id){
        CommonResp resp = new CommonResp<>();
        knowledgeManagementService.delete(id);
        return resp;
    }

    // 税号误报风险知识（黑样本）
    @Resource
    private KnowledgeTaxMisreportService knowledgeTaxMisreportService;

    @GetMapping("/taxMisreport/list")
    public CommonResp<PageResp<TaxMisreportListResp>> listTaxMisreport(@RequestBody TaxMisreportListReq req){
        CommonResp<PageResp<TaxMisreportListResp>> resp = new CommonResp<>();
        PageResp<TaxMisreportListResp> pageResp = knowledgeTaxMisreportService.list(req);
        resp.setContent(pageResp);
        return resp;
    }

    @PostMapping("/taxMisreport/save")
    public CommonResp saveTaxMisreport(@RequestBody TaxMisreportSaveReq req){
        CommonResp resp = new CommonResp<>();
        knowledgeTaxMisreportService.save(req);
        return resp;
    }

    @DeleteMapping("/taxMisreport/delete/{id}")
    public CommonResp deleteTaxMisreport(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        knowledgeTaxMisreportService.delete(id);
        return resp;
    }

    //税号误报风险知识（白样本）
    @Resource
    private KnowledgeTaxReportService knowledgeTaxReportService;

    @GetMapping("/taxReport/list")
    public CommonResp<PageResp<TaxReportListResp>> listTaxReport(@RequestBody TaxReportListReq req) {
        CommonResp<PageResp<TaxReportListResp>> resp = new CommonResp<>();
        PageResp<TaxReportListResp> pageResp = knowledgeTaxReportService.list(req);
        resp.setContent(pageResp);
        return resp;
    }

    @PostMapping("/taxReport/save")
    public CommonResp saveTaxReport(@RequestBody TaxReportSaveReq req) {
        CommonResp resp = new CommonResp<>();
        knowledgeTaxReportService.save(req);
        return resp;
    }

    @DeleteMapping("/taxReport/delete/{id}")
    public CommonResp deleteTaxReport(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        knowledgeTaxReportService.delete(id);
        return resp;
    }

    // 商品信息风险知识


}
