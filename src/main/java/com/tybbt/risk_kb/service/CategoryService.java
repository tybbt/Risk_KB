package com.tybbt.risk_kb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tybbt.risk_kb.domain.Category;
import com.tybbt.risk_kb.domain.CategoryExample;
import com.tybbt.risk_kb.mapper.CategoryMapper;
import com.tybbt.risk_kb.req.CategoryQueryReq;
import com.tybbt.risk_kb.req.CategorySaveReq;
import com.tybbt.risk_kb.req.CategorySearchReq;
import com.tybbt.risk_kb.req.CategoryUpdateReq;
import com.tybbt.risk_kb.resp.CategoryQueryResp;
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
public class CategoryService {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);
    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<CategoryQueryResp> list(CategoryQueryReq req) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        // 调用CategoryMapper的list方法
        List<Category> categoryslist = categoryMapper.selectByExample(categoryExample);

        PageInfo<Category> pageInfo = new PageInfo<>(categoryslist);
        LOG.info("总行数： {}", pageInfo.getTotal());
        LOG.info("总页数： {}", pageInfo.getPages());

        // 列表复制
        List<CategoryQueryResp> list = CopyUtil.copyList(categoryslist, CategoryQueryResp.class);

        PageResp<CategoryQueryResp> pageResp = new PageResp<>();

        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    public PageResp<CategoryQueryResp> search(CategorySearchReq req) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        criteria.andNameLike("%" + req.getName() + "%");
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        LOG.info("总行数： {}", pageInfo.getTotal());
        LOG.info("总页数： {}", pageInfo.getPages());
        // 列表复制
        List<CategoryQueryResp> list = CopyUtil.copyList(categoryList, CategoryQueryResp.class);

        PageResp<CategoryQueryResp> pageResp = new PageResp<>();

        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
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
