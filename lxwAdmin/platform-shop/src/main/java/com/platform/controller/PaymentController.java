package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.PaymentEntity;
import com.platform.service.PaymentService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-26 14:51:14
 */
@Controller
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("payment:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<PaymentEntity> paymentList = paymentService.queryList(query);
        int total = paymentService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(paymentList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("payment:info")
    @ResponseBody
    public R info(@PathVariable("id") Integer id) {
        PaymentEntity payment = paymentService.queryObject(id);

        return R.ok().put("payment", payment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("payment:save")
    @ResponseBody
    public R save(@RequestBody PaymentEntity payment) {
        paymentService.save(payment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("payment:update")
    @ResponseBody
    public R update(@RequestBody PaymentEntity payment) {
        paymentService.update(payment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("payment:delete")
    @ResponseBody
    public R delete(@RequestBody Integer[]ids) {
        paymentService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<PaymentEntity> list = paymentService.queryList(params);

        return R.ok().put("list", list);
    }
}
