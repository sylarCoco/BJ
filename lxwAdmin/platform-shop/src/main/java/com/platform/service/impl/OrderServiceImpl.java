package com.platform.service.impl;


import com.platform.dao.*;
import com.platform.entity.*;
import com.platform.service.*;
import com.platform.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-25 13:14:05
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private BillnewDao billNewDao;
    @Autowired
    private UserService userService;
    @Autowired
    SendingDao sendingDao;
    @Autowired
    private DataformService dataformService ;
    @Autowired
    private MajorbillnewDao majorbillnewDao;
    @Autowired
    private MajorbillnewService majorbillnewService;
    @Override
    public OrderEntity queryObject(Integer id) {

        OrderEntity orderEntity=orderDao.queryObject(id);
        if(orderEntity==null){
            return orderDao.querys(id);
        }
        return orderEntity;
        }

    @Override
    public OrderEntity queryListOrder(String orderSn) {
        return orderDao.queryListOrder(orderSn);
    }

    @Override
    public OrderEntity querys(Integer id) {
        return orderDao.queryObj(id);
    }

    @Override
    public List<OrderEntity> queryList(Map<String, Object> map) {
        return orderDao.queryList(map);
    }

    @Override
    public List<OrderEntity> queryListed(Integer id) {
        //










        return null;
    }

    @Override
    public List<OrderEntity> queryListing(Map<String, Object> map) {
        return orderDao.queryListing(map);
    }

    @Override
    public List<OrderEntity> queryListSos(Map<String, Object> map) {
        MajorbillnewEntity majorbillnew =  majorbillnewService.queryListSosP(map);
        String pid=majorbillnew.getPid();
        String cycleNo=majorbillnew.getCycleNo();
        map.put("pid",pid);
        map.put("cycleNo",cycleNo);
        List<OrderEntity> orderEntities= orderDao.queryListSos(map);
        return orderEntities;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return orderDao.queryTotal(map);
    }

    @Override
    public int save(OrderEntity order) {

        return orderDao.save(order);
    }

    @Override
    @Transactional
    public int update(OrderEntity order, SendingEntity sendingEntity, BillnewEntity billnewEntity) throws ParseException {
            order.setConfirmTime(new Date());
            String orderNo=orderDao.selectpos(order.getId());
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
                SimpleDateFormat s = new SimpleDateFormat("yyyymmddHHmmss");
                Date b = calendar.getTime();
                String custnumber = "CG" + s.format(b);
                order.setOrderNo(custnumber);
                Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
                SimpleDateFormat s1 = new SimpleDateFormat("yyyymmddHHmmss");
                Date b1 = calendar1.getTime();
                String custnumber1 = "ZD" + s1.format(b1);
                Integer orderStatus = order.getOrderStatus();
                //插入操作用户
             /*   order.setDispose();*/
                /*String usernames= (String) httpSession.getParameter(username);
                System.out.println(username);*/

                int result = orderDao.update(order);
                if (result == 1) {
                    if (orderStatus == 0) {
                        sendingEntity.setOrderSn(order.getOrderNo());
                        sendingEntity.setTime(order.getTime());
                        sendingEntity.setModeDistribution(order.getModeDistribution());
                        sendingEntity.setPerson(order.getPerson());
                        sendingEntity.setMobiles(order.getMobiles());
                        Integer id = sendingDao.selecting(order.getOrderSn());
                        int a=sendingDao.save(sendingEntity);
                        OrderEntity orders = new OrderEntity();
                        orders.setOrderStatus(300);
                        orders.setId(order.getId());
                        orderDao.update(orders);
                       /* billnewEntity.setBillNumber(custnumber1);
                        billnewEntity.setPid(order.getUserId().toString());
                        billnewEntity.setUser(order.getConsignee());
                        billnewEntity.setApplyTime(order.getAddTime());
                        billnewEntity.setBargainTime(order.getTime());
                        DataformEntity dataformEntity=dataformService.queryWeek(order.getTime());
                        String cycleNo=dataformEntity.getCycleno();
                        billnewEntity.setCycleNo(cycleNo);
                        billnewEntity.setMoney(order.getGeneralBudget());
                        billnewEntity.setOrderStatus(orders.getOrderStatus().toString());
                        billnewEntity.setSettlementStatus("302");
                        billnewEntity.setOrderSn(order.getOrderNo());
                        billNewDao.save(billnewEntity);*/
                    } else if (orderStatus == 101) {
                        OrderEntity orders = new OrderEntity();
                        orders.setOrderStatus(101);
                        orders.setId(order.getId());
                        return orderDao.update(orders);
                    }
                    return 1;
                } else {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Integer.parseInt(null);
                }
            }


    private  String getNextDate(Date d) {
        long addTime = 1;//用1为乘的基数
        addTime *= 1;
        addTime *=24; //1天24小时
        addTime *=60; //一小时60分钟
        addTime *=60; //一分钟60秒
        addTime *=1000; //一秒1000毫秒
        Date date=new Date(d.getTime()+addTime);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    @Override
    public int updates(OrderEntity order, SendingEntity sendingEntity, BillnewEntity billnewEntity) throws ParseException {
        order.setCreatingTime(new Date());
        int result = orderDao.update(order);
        if (result == 1) {
            sendingEntity.setTime(order.getTime());
            sendingEntity.setModeDistribution(order.getModeDistribution());
            sendingEntity.setPerson(order.getPerson());
            sendingEntity.setMobiles(order.getMobiles());
            System.out.println(order.getOrderNo());
            Integer id = sendingDao.selecting(order.getOrderNo());
            sendingEntity.setId(id);
            int a = sendingDao.update(sendingEntity);

            billnewEntity.setUser(order.getConsignee());
            billnewEntity.setApplyTime(order.getAddTime());
            billnewEntity.setMoney(order.getGeneralBudget());
            billnewEntity.setOrderStatus(order.getOrderStatus().toString());
            Integer ids=billNewDao.selecting(order.getOrderNo());
            billnewEntity.setId(ids);
            billNewDao.update(billnewEntity);
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Integer.parseInt(null);
        }
        return 1;
    }

    @Override
    @Transactional
    public int update(OrderEntity order, SendingEntity sendingEntity) {
        order.setId(order.getId());
        int result = orderDao.update(order);
        if (result == 1) {
                sendingEntity.setOrderSn(order.getOrderSn());
                sendingEntity.setTime(order.getTime());
                sendingEntity.setModeDistribution(order.getModeDistribution());
                sendingEntity.setPerson(order.getPerson());
                sendingEntity.setMobiles(order.getMobiles());
                Integer id = sendingDao.selecting(order.getOrderSn());
                String orderSn = sendingDao.select(id);
                sendingEntity.setId(id);
                if (order.getOrderSn().equals(orderSn)) {
                    sendingDao.update(sendingEntity);
                }else {
                    return sendingDao.save(sendingEntity);
                }
            return 1;
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Integer.parseInt(null);
        }
    }

    @Override
    public int update(OrderEntity order) {
        BillnewEntity billnewEntity=new BillnewEntity();
        OrderEntity orderEntity=orderDao.queryObject(order.getId());
        if( orderEntity.getOrderStatus().equals(300) || orderEntity.getOrderStatus().equals(402)) {
            if (order.getOrderStatus().equals(101)) {
                if(orderEntity.getOrderStatus().equals(402)){
                    return 4;
                }
                order.setCreatingTime(new Date());
                orderDao.update(order);
                return 1;
            } else if (order.getOrderStatus().equals(401)) {
                order.setCreatingTime(new Date());
                int a = orderDao.update(order);
                if(a==1) {
                    Integer id = billNewDao.selecting(orderEntity.getOrderNo().toString());
                    BillnewEntity billnewEntitying = billNewDao.queryObject(id);
                    if (billnewEntitying == null) {
                        return 0;
                    }
                    billnewEntity.setId(id);
                    billnewEntity.setOrderStatus("401");
                    billnewEntity.setMoney("-" + billnewEntitying.getMoney());
                    billNewDao.update(billnewEntity);
                }else{
                    return 2;
                }
            } else if (order.getOrderStatus().equals(402)) {
                order.setCreatingTime(new Date());
                int a = orderDao.update(order);
                if (a == 1) {
                    Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
                    SimpleDateFormat s1 = new SimpleDateFormat("yyyymmddHHmmss");
                    Date b1 = calendar1.getTime();
                    String custnumber1 = "ZD" + s1.format(b1);
                    billnewEntity.setBillNumber(custnumber1);
                    billnewEntity.setPid(orderEntity.getUserId().toString());
                    billnewEntity.setUser(orderEntity.getConsignee());
                    billnewEntity.setApplyTime(orderEntity.getAddTime());
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.println(sdf.format(date));
                    billnewEntity.setBargainTime(sdf.format(date));
                    UserEntity userEntity=userService.queryObject(orderEntity.getUserId());
                    String cycleType=userEntity.getClearingForm();
                    if(cycleType.equals(2)){
                        String cycleTypeMonth="week";
                        DataformEntity dataformEntity = dataformService.queryWeek(sdf.format(date),cycleTypeMonth);
                        String cycleNo = dataformEntity.getCycleno();
                        billnewEntity.setCycleNo(cycleNo);
                    }else if(cycleType.equals(3)){
                        String cycleTypeMonth="month";
                        DataformEntity dataformEntity = dataformService.queryWeek(sdf.format(date),cycleTypeMonth);
                        String cycleNo = dataformEntity.getCycleno();
                        billnewEntity.setCycleNo(cycleNo);
                    }else if(cycleType.equals(4)){
                        String cycleTypeMonth="year";
                        DataformEntity dataformEntity = dataformService.queryWeek(sdf.format(date),cycleTypeMonth);
                        String cycleNo = dataformEntity.getCycleno();
                        billnewEntity.setCycleNo(cycleNo);
                    }
                    billnewEntity.setMoney(orderEntity.getGeneralBudget());
                    billnewEntity.setOrderStatus("402");
                    billnewEntity.setSettlementStatus("302");
                    billnewEntity.setOrderSn(orderEntity.getOrderNo());
                    billNewDao.save(billnewEntity);
                } else {
                    return 2;
                }
            }
        } else{
            return 3;
        }
          return 1;
    }

    @Override
    public int delete(Integer id) {
        return orderDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return orderDao.deleteBatch(ids);
    }

    @Override
    public String selectpos(Integer id) {
        return orderDao.selectpos(id);
    }
}
