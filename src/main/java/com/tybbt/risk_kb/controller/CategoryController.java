package com.tybbt.risk_kb.controller;

import com.tybbt.risk_kb.domain.Category;
import com.tybbt.risk_kb.req.CategorySaveReq;
import com.tybbt.risk_kb.req.CategorySearchReq;
import com.tybbt.risk_kb.req.CategoryUpdateReq;
import com.tybbt.risk_kb.resp.CommonResp;
import com.tybbt.risk_kb.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
