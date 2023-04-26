package com.tybbt.risk_kb.controller;

import com.tybbt.risk_kb.req.CategoryQueryReq;
import com.tybbt.risk_kb.req.CategorySaveReq;
import com.tybbt.risk_kb.req.CategorySearchReq;
import com.tybbt.risk_kb.req.CategoryUpdateReq;
import com.tybbt.risk_kb.resp.CategoryQueryResp;
import com.tybbt.risk_kb.resp.CommonResp;
import com.tybbt.risk_kb.resp.PageResp;
import com.tybbt.risk_kb.service.CategoryService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/list")
    public CommonResp<PageResp<CategoryQueryResp>> list(@Valid CategoryQueryReq req) {
        CommonResp<PageResp<CategoryQueryResp>> resp = new CommonResp<>();
        PageResp<CategoryQueryResp> list = categoryService.list(req);
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/search")
    public CommonResp<PageResp<CategoryQueryResp>> search(CategorySearchReq req) {
        CommonResp<PageResp<CategoryQueryResp>> resp = new CommonResp<>();
        PageResp<CategoryQueryResp> list = categoryService.search(req);
        resp.setContent(list);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@RequestBody CategorySaveReq req) {
        CommonResp resp = new CommonResp<>();
        categoryService.save(req);
        return resp;
    }

    @PostMapping("/update")
    public CommonResp update(@RequestBody CategoryUpdateReq req) {
        CommonResp resp = new CommonResp<>();
        categoryService.update(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        categoryService.delete(id);
        return resp;
    }
}
