package com.platform.service.impl;

import com.platform.dao.CategoryDao;
import com.platform.entity.CategoryEntity;
import com.platform.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-21 15:32:31
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public CategoryEntity queryObject(Integer id) {
        return categoryDao.queryObject(id);
    }

    @Override
    public List<CategoryEntity> queryList(Map<String, Object> map) {
        return categoryDao.queryList(map);
    }

    @Override
    public List<CategoryEntity> queryListing(Map<String, Object> map) {
        return categoryDao.queryListing(map);
    }

    @Override
    public List<CategoryEntity> queryLists(String parentId) {
        Integer parentId1 =  Integer.parseInt(parentId);
        return categoryDao.queryMax(parentId1);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return categoryDao.queryTotal(map);
    }

    @Override
    public int save(CategoryEntity category) {
        Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat s = new SimpleDateFormat("yyyymmddHHmmss");
        Date b=calendar.getTime();
        String custnumber="SPA"+s.format(b);
        category.setProductid(custnumber);
        return categoryDao.save(category);
    }

    @Override
    public int update(CategoryEntity category) {
        Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat s = new SimpleDateFormat("yyyymmddHHmmss");
        Date b=calendar.getTime();
        String custnumber="SPA"+s.format(b);
        category.setProductid(custnumber);
        return categoryDao.update(category);
    }

    @Override
    public int delete(Integer id) {
        return categoryDao.delete(id);
    }

    @Override
    @Transactional
    public int deleteBatch(Integer[]ids) {
        categoryDao.deleteByParentBatch(ids);
        return categoryDao.deleteBatch(ids);
    }

    @Override
    public List<CategoryEntity> querySmx() {
        return categoryDao.querySmx();
    }

    @Override
    public List<CategoryEntity> querySmxs() {
        return categoryDao.querySmxs();
    }

    @Override
    public List<CategoryEntity> queryMax(String parentId) {
        Integer parentId1 =  Integer.parseInt(parentId);
        return categoryDao.queryMax(parentId1);
    }

    @Override
    public List<CategoryEntity> queryMin(String parentId) {
        Integer parentId1 =  Integer.parseInt(parentId);
        return categoryDao.queryMin(parentId1);
    }

    @Override
    public List<CategoryEntity> queryPraentName(String parentId) {
        return categoryDao.queryParentName(parentId);
    }

    @Override
    public  List<CategoryEntity> queryParent(String parentId) {
        return categoryDao.queryParent(parentId);
    }

    @Override
    public List<CategoryEntity> queryParentNames(String parentId) {
        List<CategoryEntity> los=categoryDao.queryParent(parentId);
        System.out.println(los);
        return los;
    }


}
