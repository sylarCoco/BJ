package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.DatabaseformEntity;
import com.platform.service.DatabaseformService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-31 11:38:20
 */
@Controller
@RequestMapping("databaseform")
public class DatabaseformController {
    @Autowired
    private DatabaseformService databaseformService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("databaseform:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<DatabaseformEntity> databaseformList = databaseformService.queryList(query);
        int total = databaseformService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(databaseformList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("databaseform:info")
    @ResponseBody
    public R info(@PathVariable("id") Integer id) {
        DatabaseformEntity databaseform = databaseformService.queryObject(id);

        return R.ok().put("databaseform", databaseform);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("databaseform:save")
    @ResponseBody
    public R save(@RequestBody DatabaseformEntity databaseform) {
        databaseformService.save(databaseform);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("databaseform:update")
    @ResponseBody
    public R update(@RequestBody DatabaseformEntity databaseform) {
        databaseformService.update(databaseform);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("databaseform:delete")
    @ResponseBody
    public R delete(@RequestBody Integer[]ids) {
        databaseformService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<DatabaseformEntity> list = databaseformService.queryList(params);

        return R.ok().put("list", list);
    }
}
