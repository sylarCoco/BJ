package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.RegisterDao;
import com.platform.entity.RegisterEntity;
import com.platform.service.RegisterService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-08-09 09:45:55
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDao registerDao;

    @Override
    public RegisterEntity queryObject(Integer id) {
        return registerDao.queryObject(id);
    }

    @Override
    public List<RegisterEntity> queryList(Map<String, Object> map) {
        return registerDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return registerDao.queryTotal(map);
    }

    @Override
    public int save(RegisterEntity register) {
        return registerDao.save(register);
    }

    @Override
    public int deleteing(String contactMobile) {

        return registerDao.deleteing(contactMobile);
    }

    @Override
    public int update(RegisterEntity register) {
        return registerDao.update(register);
    }

    @Override
    public int delete(Integer id) {
        return registerDao.delete(id);
    }


    @Override
    public int deleteBatch(Integer[]ids) {
        return registerDao.deleteBatch(ids);
    }
}
