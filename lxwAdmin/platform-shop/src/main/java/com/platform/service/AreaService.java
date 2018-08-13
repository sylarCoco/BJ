package com.platform.service;

import com.platform.entity.AreaEntity;
import com.platform.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-07-13 11:56:21
 */
public interface AreaService {
    List<AreaEntity> querySmx();
    List<AreaEntity> querySmxs();
    List<AreaEntity> queryMax( String parentId);
    List<AreaEntity> queryMin(String parentId);
    String   queryMaxs(String parentId);
    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    AreaEntity queryObject(Long id);
}
