package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.CommondityEntity;
import com.platform.service.CommondityService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-21 11:52:39
 */
@Controller
@RequestMapping("commondity")
public class CommondityController {
    @Autowired
    private CommondityService commondityService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("commondity:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<CommondityEntity> commondityList = commondityService.queryList(query);
        int total = commondityService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(commondityList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("commondity:info")
    @ResponseBody
    public R info(@PathVariable("id") Integer id) {
        CommondityEntity commondity = commondityService.queryObject(id);

        return R.ok().put("commondity", commondity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("commondity:save")
    @ResponseBody
    public R save(@RequestBody CommondityEntity commondity) {
        commondityService.save(commondity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("commondity:update")
    @ResponseBody
    public R update(@RequestBody CommondityEntity commondity) {
        commondityService.update(commondity);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("commondity:delete")
    @ResponseBody
    public R delete(@RequestBody Integer[]ids) {
        commondityService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<CommondityEntity> list = commondityService.queryList(params);

        return R.ok().put("list", list);
    }
}
