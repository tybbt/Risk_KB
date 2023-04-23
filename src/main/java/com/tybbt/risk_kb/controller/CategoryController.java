package com.tybbt.risk_kb.controller;

import com.tybbt.risk_kb.domain.Category;
import com.tybbt.risk_kb.req.CategorySearchReq;
import com.tybbt.risk_kb.resp.CommonResp;
import com.tybbt.risk_kb.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/list")
    public List<Category> list() {
        return categoryService.list();
    }

    @GetMapping("/search")
    public CommonResp<List<Category>> search(CategorySearchReq req) {
        CommonResp<List<Category>> resp = new CommonResp<>();
        List<Category> result = categoryService.search(req);
        resp.setContent(result);
        return resp;
    }
}
