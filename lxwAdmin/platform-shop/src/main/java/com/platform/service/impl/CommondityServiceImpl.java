package com.platform.service.impl;
import com.platform.dao.CommondityDao;
import com.platform.entity.CommondityEntity;
import com.platform.service.CommondityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service("commondityService")
public class CommondityServiceImpl implements CommondityService {
    @Autowired
    private CommondityDao commondityDao;

    @Override
    public CommondityEntity queryObject(Integer id) {
        return commondityDao.queryObject(id);
    }
    @Override
    public List<CommondityEntity> queryList(Map<String, Object> map) {
        return commondityDao.queryList(map);
    }

    //查询商品信息数
    @Override
    public int queryTotal(Map<String, Object> map) {
        return commondityDao.queryTotal();
    }

    //修改商品信息
    @Override
    public int update(CommondityEntity user) {
        return commondityDao.update(user);
    }


    //单个删除信息
    @Override
    public int delete(Integer id) {
        return commondityDao.delete(id);
    }

    //批量删除商品信息
    @Override
    public int deleteBatch(Integer[] ids) {
        return commondityDao.deleteBatch(ids);
    }

    //新增商品录入信息
    @Override
    public int save(CommondityEntity commondityEntity) {
        return commondityDao.save(commondityEntity);
    }


}
