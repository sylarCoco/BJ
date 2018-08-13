package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.SendingDao;
import com.platform.entity.SendingEntity;
import com.platform.service.SendingService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-25 14:06:02
 */
@Service("sendingService")
public class SendingServiceImpl implements SendingService {
    @Autowired
    private SendingDao sendingDao;

    @Override
    public SendingEntity queryObject(Integer id) {
        return sendingDao.queryObject(id);
    }

    @Override
    public List<SendingEntity> queryList(Map<String, Object> map) {
        return sendingDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sendingDao.queryTotal(map);
    }

    @Override
    public int save(SendingEntity sending) {
        return sendingDao.save(sending);
    }

    @Override
    public int update(SendingEntity sending) {
        return sendingDao.update(sending);
    }

    @Override
    public int delete(Integer id) {
        return sendingDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return sendingDao.deleteBatch(ids);
    }
}
