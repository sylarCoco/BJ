package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.ClientDao;
import com.platform.entity.ClientEntity;
import com.platform.service.ClientService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-05 14:38:25
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public ClientEntity queryObject(Integer id) {
        return clientDao.queryObject(id);
    }

    @Override
    public List<ClientEntity> queryList(Map<String, Object> map) {
        return clientDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return clientDao.queryTotal(map);
    }

    @Override
    public int save(ClientEntity client) {
        return clientDao.save(client);
    }

    @Override
    public int update(ClientEntity client) {
        return clientDao.update(client);
    }

    @Override
    public int delete(Integer id) {
        return clientDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return clientDao.deleteBatch(ids);
    }
}
