package com.platform.service.impl;

import com.google.gson.JsonObject;
import com.platform.entity.BillnewEntity;
import com.platform.entity.UserEntity;
import com.platform.service.BillnewService;
import com.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.platform.dao.MajorbillnewDao;
import com.platform.entity.MajorbillnewEntity;
import com.platform.service.MajorbillnewService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-26 16:20:45
 */
@Service("majorbillnewService")
public class MajorbillnewServiceImpl implements MajorbillnewService {
    @Autowired
    private MajorbillnewDao majorbillnewDao;
    @Autowired
    private BillnewService billnewService;
    @Autowired
    private UserService userService;

    @Override
    public MajorbillnewEntity queryObject(Integer id) {
        return majorbillnewDao.queryObject(id);
    }

    @Override
    public List<MajorbillnewEntity> queryList(Map<String, Object> map) {

        return majorbillnewDao.queryList(map);
    }

    @Override
    public MajorbillnewEntity queryListSosP(Map<String, Object> map) {
        return  majorbillnewDao.queryListSosP(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return majorbillnewDao.queryTotal(map);
    }

    @Override
    public int save(MajorbillnewEntity majorbillnew) {
        return majorbillnewDao.save(majorbillnew);
    }

    @Override
    public int update(MajorbillnewEntity majorbillnew) {
        return majorbillnewDao.update(majorbillnew);
    }

    @Override
    public int delete(Integer id) {
        return majorbillnewDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return majorbillnewDao.deleteBatch(ids);
    }

    @Override
    public String queryBillNumber(MajorbillnewEntity majorbillnewEntity) {
        return majorbillnewDao.queryBillNumber(majorbillnewEntity);
    }


}
