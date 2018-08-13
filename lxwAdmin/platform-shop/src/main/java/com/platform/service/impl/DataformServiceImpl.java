package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.platform.dao.DataformDao;
import com.platform.entity.DataformEntity;
import com.platform.service.DataformService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-08-01 11:26:06
 */
@Service("dataformService")
public class DataformServiceImpl implements DataformService {
    @Autowired
    private DataformDao dataformDao;

    @Override
    public DataformEntity queryObject(Integer id) {
        return dataformDao.queryObject(id);
    }

    @Override
    public List<DataformEntity> queryList(Map<String, Object> map) {
        return dataformDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return dataformDao.queryTotal(map);
    }

    @Override
    public int save(DataformEntity dataform) {
        return dataformDao.save(dataform);
    }

    @Override
    public int update(DataformEntity dataform) {
        return dataformDao.update(dataform);
    }

    @Override
    public int delete(Integer id) {
        return dataformDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return dataformDao.deleteBatch(ids);
    }

    @Override
    public DataformEntity queryWeek(String date,String cycleType) {
        return dataformDao.queryWeek(date,cycleType);
    }

    @Override
    public DataformEntity queryMonth(String date) {
        return dataformDao.queryMonth(date);
    }

    @Override
    public DataformEntity queryYear(String date) {
        return dataformDao.queryYear(date);
    }
}
