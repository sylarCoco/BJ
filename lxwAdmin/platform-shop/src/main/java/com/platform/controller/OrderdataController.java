package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.OrderdataEntity;
import com.platform.service.OrderdataService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-08-03 16:45:01
 */
@Controller
@RequestMapping("orderdata")
public class OrderdataController {
    @Autowired
    private OrderdataService orderdataService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("orderdata:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<OrderdataEntity> orderdataList = orderdataService.queryList(query);
        int total = orderdataService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(orderdataList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("orderdata:info")
    @ResponseBody
    public R info(@PathVariable("id") Integer id) {
        OrderdataEntity orderdata = orderdataService.queryObject(id);

        return R.ok().put("orderdata", orderdata);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("orderdata:save")
    @ResponseBody
    public R save(@RequestBody OrderdataEntity orderdata) {
        orderdataService.save(orderdata);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("orderdata:update")
    @ResponseBody
    public R update(@RequestBody OrderdataEntity orderdata) {
        orderdataService.update(orderdata);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("orderdata:delete")
    @ResponseBody
    public R delete(@RequestBody Integer[]ids) {
        orderdataService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<OrderdataEntity> list = orderdataService.queryList(params);

        return R.ok().put("list", list);
    }
}
