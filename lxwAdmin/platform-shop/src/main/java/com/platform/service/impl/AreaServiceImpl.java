package com.platform.service.impl;

import com.platform.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.AreaDao;
import com.platform.entity.AreaEntity;
import com.platform.service.AreaService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-13 11:56:21
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<AreaEntity> querySmx() {
        return areaDao.querySmx();
    }

    @Override
    public List<AreaEntity> querySmxs() {
        return areaDao.querySmxs();
    }

    @Override
    public List<AreaEntity> queryMax(String parentId) {
        return areaDao.queryMax(parentId);
    }

    @Override
    public List<AreaEntity> queryMin(String parentId) {
        return areaDao.queryMin(parentId);
    }

    @Override
    public String queryMaxs(String id) {
        return areaDao.selects(id);
    }

    @Override
    public AreaEntity queryObject(Long id) {
        return areaDao.queryObject(id);
    }
}
