package com.platform.controller;

import com.platform.entity.AttributeCategoryEntity;
import com.platform.entity.CategoryEntity;
import com.platform.service.AttributeCategoryService;
import com.platform.service.CategoryService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
import com.sun.net.httpserver.Authenticator;
import com.sun.tools.internal.xjc.generator.bean.ImplStructureStrategy;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("goodsType")
public class GoodsTypeController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        params.put("level", "L0");
        //查询列表数据
       // List<CategoryEntity>  list  = categoryService.queryList(params);
        List<CategoryEntity>  list1  = categoryService.querySmx();

        return R.ok().put("list", list1);
    }

    @RequestMapping("/listing")
    public R listing(@RequestParam Map<String, Object> params) {
        params.put("level", "L1");
        //查询列表数据
        // List<CategoryEntity>  list  = categoryService.queryList(params);
        List<CategoryEntity>  list1  = categoryService.querySmxs();

        return R.ok().put("list", list1);
    }

    @RequestMapping("/listMax")
    public R list1(@RequestParam Map<String, Object> params) {

        String parentId = (String) params.get("parentId");
        List<CategoryEntity>  list  = categoryService.queryMax(parentId);
        return R.ok().put("list", list);
    }
    @RequestMapping("/listMin")
    public R list2(@RequestParam Map<String, Object> params) {

        String parentId = (String) params.get("parentId");
        List<CategoryEntity>  list  = categoryService.queryMin(parentId);

        return R.ok().put("list", list);
    }


}
