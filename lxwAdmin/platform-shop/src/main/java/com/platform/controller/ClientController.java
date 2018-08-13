package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.platform.entity.ClientEntity;
import com.platform.service.ClientService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-05 14:38:25
 */
@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("client:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ClientEntity> clientList = clientService.queryList(query);
        int total = clientService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(clientList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("client:info")
    @ResponseBody
    public R info(@PathVariable("id") Integer id) {
        ClientEntity client = clientService.queryObject(id);

        return R.ok().put("client", client);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("client:save")
    @ResponseBody
    public R save(@RequestBody ClientEntity client) {
        clientService.save(client);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("client:update")
    @ResponseBody
    public R update(@RequestBody ClientEntity client) {
        clientService.update(client);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("client:delete")
    @ResponseBody
    public R delete(@RequestBody Integer[]ids) {
        clientService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ClientEntity> list = clientService.queryList(params);

        return R.ok().put("list", list);
    }
}
