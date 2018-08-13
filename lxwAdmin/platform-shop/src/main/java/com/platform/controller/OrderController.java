package com.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.platform.dao.OrderDao;
import com.platform.entity.BillnewEntity;
import com.platform.entity.OrderEntity;
import com.platform.entity.SendingEntity;
import com.platform.entity.UserEntity;
import com.platform.service.BillnewService;
import com.platform.service.OrderService;
import com.platform.service.UserService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-13 10:41:09
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private BillnewService billnewService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderDao orderDao;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<OrderEntity> orderList = orderService.queryList(query);
        int total = orderService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(orderList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }
    @RequestMapping("/listSos")
    public R listSos(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<OrderEntity> orderList = orderService.queryListSos(query);
        int total = orderService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(orderList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }
    @RequestMapping("/listing")
    @RequiresPermissions("order:list")
    public R listing(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<OrderEntity> orderList = orderService.queryListing(query);
        int total = orderService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(orderList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/infos/{id}")
    @RequiresPermissions("order:infos")
    public R infos(@PathVariable("id") Integer id) {
        BillnewEntity billnewEntity=billnewService.queryObject(id);
        String userId=billnewEntity.getPid();
        String custNumber=billnewEntity.getCustnumber();
        return R.ok();
    }







    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:info")
    public R info(@PathVariable("id") Integer id) {
        OrderEntity order = orderService.queryObject(id);
        OrderEntity orderEntity=orderService.querys(order.getId());
        order.setUserId(orderEntity.getUserId());
        UserEntity userEntity= userService.queryObject(orderEntity.getUserId());
        if(userEntity==null){
            return R.ok().put("order", order);
        }
        order.setClientName(userEntity.getClientName());
        System.out.println(order);
        return R.ok().put("order", order);
    }
    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:save")
    public R save(@RequestBody OrderEntity order) {
        orderService.save(order);
        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ApplyOrder:save")
    public R update(@RequestBody OrderEntity order) {
        String status=order.getConfirmStatus();
        if(status.equals("502")){
            return R.error("订单状态必须为已确定,请重新提交");
        }
        orderService.update(order);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:delete")
    public R delete(@RequestBody Integer[] ids) {
        orderService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<OrderEntity> list = orderService.queryList(params);

        return R.ok().put("list", list);
    }

    /**
     * 总计
     */
    @RequestMapping("/queryTotal")
    public R queryTotal(@RequestParam Map<String, Object> params) {
        int sum = orderService.queryTotal(params);

        return R.ok().put("sum", sum);
    }

  /*  *
     * 修改
     *
     * @param id
     * @return
     */
    @RequestMapping("/confirm")
    @RequiresPermissions("order:confirm")
    public R update(@RequestBody OrderEntity order, SendingEntity sendingEntity) {
        orderService.update(order,sendingEntity);
        return R.ok();
    }

   /* *//**
     *
     *
     * @param order
     * @return
     */
    @RequestMapping("/sendGoods")
    @RequiresPermissions("order:sendGoods")
    public R sendGoods(@RequestBody OrderEntity order, SendingEntity sendingEntity, BillnewEntity billnewEntity) throws ParseException {
        String commodity=order.getCommodity();
        if(order.getConfirmStatus().equals("502")){
            return R.error("订单状态必须为确认状态才可提交!");
        }else  if(order.getConfirmStatus()==null){
            return R.error("订单状态必须为确认状态才可提交!");
        }
        orderService.update(order,sendingEntity,billnewEntity);
        return R.ok();
    }
    @RequestMapping("/sendGood")
    @RequiresPermissions("order:sendGood")
    public R sendGood(@RequestBody String params)  {
        net.sf.json.JSONObject jsonObject= net.sf.json.JSONObject.fromObject(params);
        OrderEntity orderEntity= (OrderEntity) net.sf.json.JSONObject.toBean(jsonObject,OrderEntity.class);
        Integer id=orderEntity.getId();
        Integer orderStatus=orderEntity.getOrderStatus();
        orderEntity.setOrderStatus(orderStatus);
        orderEntity.setId(id);
        int a=orderService.update(orderEntity);
        if(a==0){
            return R.error("请先确认订单已收货!");
        }else if(a==2){
            return R.error("系统异常");
        }else if(a==3){
            return R.error("订单状态不可修改,请重新发起!");
        }else if(a==4)
            return R.error("订单收货后只能退货不能取消,如需修改退货处理!");
        return R.ok();
    }
}
