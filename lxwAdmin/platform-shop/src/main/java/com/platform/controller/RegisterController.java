package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.RegisterEntity;
import com.platform.service.RegisterService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-08-09 09:45:55
 */
@Controller
@RequestMapping("register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("register:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<RegisterEntity> registerList = registerService.queryList(query);
        int total = registerService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(registerList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("register:info")
    @ResponseBody
    public R info(@PathVariable("id") Integer id) {
        RegisterEntity register = registerService.queryObject(id);

        return R.ok().put("register", register);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("register:save")
    @ResponseBody
    public R save(@RequestBody RegisterEntity register) {
        registerService.save(register);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("register:update")
    @ResponseBody
    public R update(@RequestBody RegisterEntity register) {
        registerService.update(register);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("register:delete")
    @ResponseBody
    public R delete(@RequestBody Integer[]ids) {
        registerService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<RegisterEntity> list = registerService.queryList(params);

        return R.ok().put("list", list);
    }
}
