package com.platform.controller;

import java.util.List;
import java.util.Map;

import com.platform.entity.BillnewEntity;
import com.platform.entity.OrderEntity;
import com.platform.service.BillnewService;
import com.platform.service.OrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.MajorbillnewEntity;
import com.platform.service.MajorbillnewService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-26 16:20:45
 */
@Controller
@RequestMapping("majorbillnew")
public class MajorbillnewController {
    @Autowired
    private MajorbillnewService majorbillnewService;
    @Autowired
    private BillnewService billnewService;
    @Autowired
    private OrderService orderService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<MajorbillnewEntity> majorbillnewList = majorbillnewService.queryList(query);
        int total = majorbillnewService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(majorbillnewList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @ResponseBody
    public R info(@PathVariable("id") Integer id) {
        MajorbillnewEntity majorbillnew = majorbillnewService.queryObject(id);

        return R.ok().put("majorbillnew", majorbillnew);
    }
    /**
     * 查看信息
     */
   /* @RequestMapping("/infos")
    @ResponseBody
    public R infos(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<OrderEntity> orderList = orderService.queryList(query);
        int total = orderService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(orderList, total, query.getLimit(), query.getPage());
     *//*   MajorbillnewEntity majorbillnew = majorbillnewService.queryObject(id);
        String pid=majorbillnew.getPid();
        String cycleNo=majorbillnew.getCycleNo();
        BillnewEntity billnewEntity=new BillnewEntity();
        billnewEntity.setPid(pid);
        billnewEntity.setCycleNo(cycleNo);
        List<BillnewEntity> billnewEntities=billnewService.queryListOrder(billnewEntity);*//*
      *//*  List<OrderEntity> orderEntities=orderService.queryList(billnewEntities.)*//*
        return R.ok().put("page", billnewEntities);
    }*/




    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
    public R save(@RequestBody MajorbillnewEntity majorbillnew) {
        majorbillnewService.save(majorbillnew);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public R update(@RequestBody MajorbillnewEntity majorbillnew) {
        majorbillnewService.update(majorbillnew);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public R delete(@RequestBody Integer[]ids) {
        majorbillnewService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<MajorbillnewEntity> list = majorbillnewService.queryList(params);

        return R.ok().put("list", list);
    }
}
