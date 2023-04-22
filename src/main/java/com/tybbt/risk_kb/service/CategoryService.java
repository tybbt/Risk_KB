package com.tybbt.risk_kb.service;

import com.tybbt.risk_kb.domain.Category;
import com.tybbt.risk_kb.mapper.CategoryMapper;
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

}
