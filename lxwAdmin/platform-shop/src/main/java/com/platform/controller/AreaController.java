package com.platform.controller;

import java.util.List;
import java.util.Map;

import com.platform.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.AreaEntity;
import com.platform.service.AreaService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-13 11:56:21
 */
@Controller
@RequestMapping("area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        params.put("grade", "1");
        //查询列表数据
        // List<CategoryEntity>  list  = categoryService.queryList(params);
        List<AreaEntity>  list1  = areaService.querySmx();
        System.out.println(list1);
        return R.ok().put("list", list1);
    }
    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
    public R info(@PathVariable("id") Long id) {
        AreaEntity area = areaService.queryObject(id);

        return R.ok().put("area", area);
    }

    @RequestMapping("/listing")
    public R listing(@RequestParam Map<String, Object> params) {
        params.put("grade", "2");
        //查询列表数据
        // List<CategoryEntity>  list  = categoryService.queryList(params);
        List<AreaEntity>  list1  = areaService.querySmxs();

        return R.ok().put("list", list1);
    }

    @RequestMapping("/listMax")
    public R list1(@RequestParam Map<String, Object> params) {

        String parentId = (String) params.get("parentId");
        List<AreaEntity>  list  = areaService.queryMax(parentId);
        return R.ok().put("list", list);
    }
    @RequestMapping("/listMin")
    public R list2(@RequestParam Map<String, Object> params) {

        String parentId = (String) params.get("parentId");
        List<AreaEntity>  list  = areaService.queryMin(parentId);

        return R.ok().put("list", list);
    }
}
