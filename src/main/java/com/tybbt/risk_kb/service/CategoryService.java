package com.tybbt.risk_kb.service;

import com.tybbt.risk_kb.domain.Category;
import com.tybbt.risk_kb.domain.CategoryExample;
import com.tybbt.risk_kb.mapper.CategoryMapper;
import com.tybbt.risk_kb.req.CategorySearchReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    public List<Category> list() {
        return categoryMapper.selectByExample(null);
    }

    public List<Category> search(CategorySearchReq req) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        return categoryMapper.selectByExample(categoryExample);
    }

}
