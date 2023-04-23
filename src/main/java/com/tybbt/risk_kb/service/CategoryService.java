package com.tybbt.risk_kb.service;

import com.tybbt.risk_kb.domain.Category;
import com.tybbt.risk_kb.domain.CategoryExample;
import com.tybbt.risk_kb.mapper.CategoryMapper;
import com.tybbt.risk_kb.req.CategorySaveReq;
import com.tybbt.risk_kb.req.CategorySearchReq;
import com.tybbt.risk_kb.req.CategoryUpdateReq;
import com.tybbt.risk_kb.util.CopyUtil;
import com.tybbt.risk_kb.util.SnowFlake;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private SnowFlake snowFlake;

    public List<Category> list() {
        return categoryMapper.selectByExample(null);
    }

    public List<Category> search(CategorySearchReq req) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        return categoryMapper.selectByExample(categoryExample);
    }

    public void save(CategorySaveReq req) {
        Category category = CopyUtil.copy(req, Category.class);
        if (ObjectUtils.isEmpty(category.getId())) {
            // 自增，uuid，雪花
            category.setId(snowFlake.nextId());
            categoryMapper.insert(category);
        } else {
            categoryMapper.updateByPrimaryKey(category);
        }
    }

    public void update(CategoryUpdateReq req) {
        Category category = CopyUtil.copy(req, Category.class);
        categoryMapper.updateByPrimaryKey(category);
    }

    public void delete(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

}
