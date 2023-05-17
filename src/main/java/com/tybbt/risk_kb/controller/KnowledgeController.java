package com.tybbt.risk_kb.controller;

import com.tybbt.risk_kb.domain.KnowledgeManagement;
import com.tybbt.risk_kb.req.*;
import com.tybbt.risk_kb.resp.*;
import com.tybbt.risk_kb.service.*;
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
    public CommonResp<PageResp<KnowledgeManagementListResp>> list(KnowledgeManagementQueryReq req) {
        CommonResp<PageResp<KnowledgeManagementListResp>> resp = new CommonResp<>();
        PageResp<KnowledgeManagementListResp> kML = knowledgeManagementService.list(req);
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
    // 查看参数表Schema
    @Resource
    private ExtractionSchemaService extractionSchemaService;

    @GetMapping("/schema/list")
    public CommonResp<PageResp<ExtractionSchemaListResp>> listSchema(ExtractionSchemaQueryReq req) {
        CommonResp<PageResp<ExtractionSchemaListResp>> resp = new CommonResp<>();
        PageResp<ExtractionSchemaListResp> pageResp = extractionSchemaService.list(req);
        resp.setContent(pageResp);
        return resp;
    }

    @GetMapping("/schema/search/{kid}")
    public CommonResp<List<ExtractionSchemaListResp>> searchSchema(@PathVariable Long kid) {
        CommonResp<List<ExtractionSchemaListResp>> resp = new CommonResp<>();
        List<ExtractionSchemaListResp> listResp = extractionSchemaService.search(kid);
        resp.setContent(listResp);
        return resp;
    }

    // 基本通用知识形式，仅包含内容，需要依赖抽取框架
    @Resource
    private KnowledgeService knowledgeService;

    @GetMapping("/basement/list")
    public CommonResp<PageResp<KnowledgeQueryResp>> listKnowledge(KnowledgeQueryReq req) {
        CommonResp<PageResp<KnowledgeQueryResp>> resp = new CommonResp<>();
        PageResp<KnowledgeQueryResp> pageResp = knowledgeService.list(req);
        resp.setContent(pageResp);
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
    @Resource
    private KnowledgeCommodityService knowledgeCommodityService;

    @GetMapping("/commodityInfo/list")
    public CommonResp<PageResp<CommodityInfoListResp>> listCommodityInfo(@RequestBody CommodityInfoListReq req) {
        CommonResp<PageResp<CommodityInfoListResp>> resp = new CommonResp<>();
        PageResp<CommodityInfoListResp> pageResp = knowledgeCommodityService.list(req);
        resp.setContent(pageResp);
        return resp;
    }

    @PostMapping("/commodityInfo/save")
    public CommonResp saveCommodityInfo(@RequestBody CommodityInfoSaveReq req) {
        CommonResp resp = new CommonResp<>();
        knowledgeCommodityService.save(req);
        return resp;
    }

    @DeleteMapping("/commodityInfo/delete/{id}")
    public CommonResp deleteCommodityInfo(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        knowledgeCommodityService.delete(id);
        return resp;
    }

}
