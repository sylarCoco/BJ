package com.platform.service.impl;

import com.platform.dao.OpeningBankDao;
import com.platform.entity.OpeningBank;
import com.platform.entity.UserEntity;
import com.platform.service.OpeningBankService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class OpeningBankServiceImpl implements OpeningBankService {
    @Override
    public UserEntity queryObject(Integer id) {
        return null;
    }

    @Override
    public List<UserEntity> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int save(UserEntity user) {
        return 0;
    }

    @Override
    public int update(UserEntity user) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return 0;
    }
}
