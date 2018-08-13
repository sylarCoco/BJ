package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.OrderdataDao;
import com.platform.entity.OrderdataEntity;
import com.platform.service.OrderdataService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-08-03 16:45:01
 */
@Service("orderdataService")
public class OrderdataServiceImpl implements OrderdataService {
    @Autowired
    private OrderdataDao orderdataDao;

    @Override
    public OrderdataEntity queryObject(Integer id) {
        return orderdataDao.queryObject(id);
    }

    @Override
    public List<OrderdataEntity> queryList(Map<String, Object> map) {
        return orderdataDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return orderdataDao.queryTotal(map);
    }

    @Override
    public int save(OrderdataEntity orderdata) {
        return orderdataDao.save(orderdata);
    }

    @Override
    public int update(OrderdataEntity orderdata) {
        return orderdataDao.update(orderdata);
    }

    @Override
    public int delete(Integer id) {
        return orderdataDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return orderdataDao.deleteBatch(ids);
    }
}
