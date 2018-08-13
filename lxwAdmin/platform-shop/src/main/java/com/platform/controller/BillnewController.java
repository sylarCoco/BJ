package com.platform.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import com.platform.entity.MajorbillnewEntity;
import com.platform.entity.OrderEntity;
import com.platform.service.MajorbillnewService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.BillnewEntity;
import com.platform.service.BillnewService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-26 14:37:56
 */
@Controller
@RequestMapping("billnew")
public class BillnewController {
    @Autowired
    private BillnewService billnewService;
    @Autowired
    private MajorbillnewService majorbillnewService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("billnew:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<MajorbillnewEntity> billnewList = billnewService.queryList(query);
        int total = majorbillnewService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(billnewList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("billnew:info")
    @ResponseBody
    public R info(@PathVariable("id") Integer id) {
        BillnewEntity billnew = billnewService.queryObject(id);

        return R.ok().put("billnew", billnew);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("billnew:save")
    @ResponseBody
    public R save(@RequestBody BillnewEntity billnew) {
        billnewService.save(billnew);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("billnew:update")
    @ResponseBody
    public R update(@RequestBody BillnewEntity billnew, OrderEntity orderEntity) {
        billnewService.update(billnew,orderEntity);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("billnew:delete")
    @ResponseBody
    public R delete(@RequestBody Integer[]ids) {
        billnewService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<MajorbillnewEntity> list = billnewService.queryList(params);

        return R.ok().put("list", list);
    }
}
