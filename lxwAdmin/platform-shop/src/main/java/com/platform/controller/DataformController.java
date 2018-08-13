package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.DataformEntity;
import com.platform.service.DataformService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-08-01 11:26:06
 */
@Controller
@RequestMapping("dataform")
public class DataformController {
    @Autowired
    private DataformService dataformService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataform:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<DataformEntity> dataformList = dataformService.queryList(query);
        int total = dataformService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(dataformList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataform:info")
    @ResponseBody
    public R info(@PathVariable("id") Integer id) {
        DataformEntity dataform = dataformService.queryObject(id);

        return R.ok().put("dataform", dataform);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dataform:save")
    @ResponseBody
    public R save(@RequestBody DataformEntity dataform) {
        dataformService.save(dataform);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dataform:update")
    @ResponseBody
    public R update(@RequestBody DataformEntity dataform) {
        dataformService.update(dataform);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dataform:delete")
    @ResponseBody
    public R delete(@RequestBody Integer[]ids) {
        dataformService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<DataformEntity> list = dataformService.queryList(params);

        return R.ok().put("list", list);
    }
}
