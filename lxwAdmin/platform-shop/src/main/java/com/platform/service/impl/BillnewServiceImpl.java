package com.platform.service.impl;

import com.platform.dao.*;
import com.platform.entity.*;
import com.platform.service.MajorbillnewService;
import com.platform.service.OrderService;
import com.platform.service.OrderdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import com.platform.service.BillnewService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-26 14:37:56
 */
@Service("billnewService")
public class BillnewServiceImpl implements BillnewService {
    @Autowired
    private BillnewDao billnewDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private DataformDao dataformDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private MajorbillnewDao majorbillnewDao;
    @Autowired
    private MajorbillnewService majorbillnewService;
    @Autowired
    private BillnewService billnewService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderdataService orderdataService;
    @Override
    public BillnewEntity queryObject(Integer id) {
        return billnewDao.queryObject(id);
    }

    @Override
    public List<MajorbillnewEntity> queryList(Map<String, Object> map) {
        List<BillnewEntity> billnewEntities = billnewDao.queryList(map);
        List<BillnewEntity> billnewEntities1 = (List<BillnewEntity>) billnewDao.querying();

        for (BillnewEntity billnewEntity : billnewEntities1) {
            MajorbillnewEntity majorbillnewEntitying=new MajorbillnewEntity();
            majorbillnewEntitying.setPid(billnewEntity.getPid());
            majorbillnewEntitying.setCycleNo(billnewEntity.getCycleNo());
            String billNumber=majorbillnewService.queryBillNumber(majorbillnewEntitying);
            if(billNumber==null) {
                billnewEntity.getCycleNo();
                billnewEntity.getMoney();
                UserEntity userEntity = userDao.queryObject(billnewEntity.getPid());
                MajorbillnewEntity majorbillnewEntity = new MajorbillnewEntity();
                majorbillnewEntity.setCycleNo(billnewEntity.getCycleNo());
                majorbillnewEntity.setMoney(billnewEntity.getMoney());
                DataformEntity dataformEntity = dataformDao.queryObject(billnewEntity.getCycleNo());
                String dateMin = dataformEntity.getMintime();
                String dateMax = dataformEntity.getMaxtime();
                String dueDate = dataformEntity.getDueDate();
                majorbillnewEntity.setBargainTime(dateMin);
                majorbillnewEntity.setAccomplishTime(dateMax);
                majorbillnewEntity.setExpireTime(dueDate);
                majorbillnewEntity.setClientName(userEntity.getCustnumber());
                majorbillnewEntity.setCustnumber(userEntity.getClientName());
                Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
                SimpleDateFormat s1 = new SimpleDateFormat("yyyymmddHHmmssSS");
                Date b1 = calendar1.getTime();
                String custnumber1 = "ZD" + s1.format(b1).substring(10);
                majorbillnewEntity.setBillNumber(custnumber1);
                majorbillnewEntity.setPid(billnewEntity.getPid());
                majorbillnewDao.save(majorbillnewEntity);
            }else{
                billnewEntity.getCycleNo();
                billnewEntity.getMoney();
                UserEntity userEntity = userDao.queryObject(billnewEntity.getPid());
                MajorbillnewEntity majorbillnewEntity = new MajorbillnewEntity();
                majorbillnewEntity.setCycleNo(billnewEntity.getCycleNo());
                majorbillnewEntity.setMoney(billnewEntity.getMoney());
                DataformEntity dataformEntity = dataformDao.queryObject(billnewEntity.getCycleNo());
                String dateMin = dataformEntity.getMintime();
                String dateMax = dataformEntity.getMaxtime();
                String dueDate = dataformEntity.getDueDate();
                majorbillnewEntity.setBargainTime(dateMin);
                majorbillnewEntity.setAccomplishTime(dateMax);
                majorbillnewEntity.setExpireTime(dueDate);
                majorbillnewEntity.setClientName(userEntity.getCustnumber());
                majorbillnewEntity.setCustnumber(userEntity.getClientName());
                majorbillnewEntity.setPid(billnewEntity.getPid());
                Integer id=majorbillnewDao.select(billNumber);
                majorbillnewEntity.setId(id);
                majorbillnewDao.update(majorbillnewEntity);
            }

            }
            return majorbillnewDao.queryList(map);

    }

    @Override
    public List<BillnewEntity> queryListOrder(BillnewEntity billnewEntity) {
        return billnewDao.queryListOrder(billnewEntity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return billnewDao.queryTotal(map);
    }

    @Override
    public int save(BillnewEntity billnew) {
        return billnewDao.save(billnew);
    }

    @Override
    @Transactional
    public int update(BillnewEntity billnew, OrderEntity orderEntity) {
        String settlementStatus=billnew.getSettlementStatus();
        if(Integer.valueOf(settlementStatus)==301) {
            billnew.setOrderStatus("1");
             int a=billnewDao.update(billnew);
             if(a==1){
                 String billNumber=billnew.getBillNumber();
                 int id=orderDao.selecting(billNumber);
                 orderEntity.setOrderStatus(201);
                 orderEntity.setId(id);
                 orderDao.update(orderEntity);
             }else {
                 TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                 return Integer.parseInt(null);
             }
        } else if(Integer.valueOf(settlementStatus)==302) {
            billnew.setOrderStatus("0");
            int b=billnewDao.update(billnew);
            if(b==1){
                String billNumber=billnew.getBillNumber();
                int id=orderDao.selecting(billNumber);
                orderEntity.setOrderStatus(0);
                orderEntity.setId(id);
                orderDao.update(orderEntity);
            }else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Integer.parseInt(null);
            }
        }
        return 1;
    }

    @Override
    public int delete(Integer id) {
        return billnewDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return billnewDao.deleteBatch(ids);
    }
}
