package com.platform.service;

import com.platform.entity.DatabaseformEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-31 11:38:20
 */
public interface DatabaseformService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    DatabaseformEntity queryObject(Integer id);


   String select(Integer ints);




    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<DatabaseformEntity> queryList(Map<String, Object> map);

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
     * @param databaseform 实体
     * @return 保存条数
     */
    int save(DatabaseformEntity databaseform);

    /**
     * 根据主键更新实体
     *
     * @param databaseform 实体
     * @return 更新条数
     */
    int update(DatabaseformEntity databaseform);

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
    int deleteBatch(Integer[]ids);
}
