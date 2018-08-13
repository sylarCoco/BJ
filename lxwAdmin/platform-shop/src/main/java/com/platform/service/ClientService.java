package com.platform.service;

import com.platform.entity.ClientEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-05 14:38:25
 */
public interface ClientService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ClientEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<ClientEntity> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param client 实体
     * @return 保存条数
     */
    int save(ClientEntity client);

    /**
     * 根据主键更新实体
     *
     * @param client 实体
     * @return 更新条数
     */
    int update(ClientEntity client);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Integer id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);
}
