package com.platform.service.impl;

import com.platform.dao.UserDao;
import com.platform.entity.UserEntity;
import com.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-16 15:02:28
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity queryObject(Integer id) {
        return userDao.queryObject(id);
    }

    @Override
    public UserEntity queryObjects(Integer id) {
        return userDao.queryObjects(id);
    }

    @Override
    public UserEntity queryObj(Integer id) {
        return userDao.queryObj(id);
    }

    @Override
    public List<UserEntity> queryList(Map<String, Object> map) {
        return userDao.queryList(map);
    }

    @Override
    public List<UserEntity> selectMobile() {
        return userDao.selectMobile();
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userDao.queryTotal(map);
    }

    @Override
    public int selectId(String mobile) {
        return userDao.selectId(mobile);
    }

    @Override
    public int save(UserEntity user) {
        Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat s = new SimpleDateFormat("yyyymmddHHmmss");
        Date b=calendar.getTime();
        String custnumber="KH"+s.format(b);
        user.setCustnumber(custnumber);
        user.setRegisterTime(new Date());
        return userDao.save(user);
    }

    @Override
    public int update(UserEntity user) {
        return userDao.update(user);
    }

    @Override
    public int updating(UserEntity user) {
        return userDao.updating(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return userDao.deleteBatch(ids);
    }

    @Override
    public int deleteing(String phoneNumber) {
        return userDao.deleteing(phoneNumber);
    }
}
