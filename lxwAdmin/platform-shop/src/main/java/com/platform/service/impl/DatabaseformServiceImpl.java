package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.DatabaseformDao;
import com.platform.entity.DatabaseformEntity;
import com.platform.service.DatabaseformService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-31 11:38:20
 */
@Service("databaseformService")
public class DatabaseformServiceImpl implements DatabaseformService {
    @Autowired
    private DatabaseformDao databaseformDao;

    @Override
    public DatabaseformEntity queryObject(Integer id) {
        return databaseformDao.queryObject(id);
    }

    @Override
    public String select(Integer ints) {
        return databaseformDao.select(ints);
    }


    @Override
    public List<DatabaseformEntity> queryList(Map<String, Object> map) {
        return databaseformDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return databaseformDao.queryTotal(map);
    }

    @Override
    public int save(DatabaseformEntity databaseform) {
        return databaseformDao.save(databaseform);
    }

    @Override
    public int update(DatabaseformEntity databaseform) {
        return databaseformDao.update(databaseform);
    }

    @Override
    public int delete(Integer id) {
        return databaseformDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return databaseformDao.deleteBatch(ids);
    }


}
