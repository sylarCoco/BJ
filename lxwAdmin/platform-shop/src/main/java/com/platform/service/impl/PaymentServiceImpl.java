package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.PaymentDao;
import com.platform.entity.PaymentEntity;
import com.platform.service.PaymentService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-26 14:51:14
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public PaymentEntity queryObject(Integer id) {
        return paymentDao.queryObject(id);
    }

    @Override
    public List<PaymentEntity> queryList(Map<String, Object> map) {
        return paymentDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return paymentDao.queryTotal(map);
    }

    @Override
    public int save(PaymentEntity payment) {
        return paymentDao.save(payment);
    }

    @Override
    public int update(PaymentEntity payment) {
        return paymentDao.update(payment);
    }

    @Override
    public int delete(Integer id) {
        return paymentDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return paymentDao.deleteBatch(ids);
    }
}
