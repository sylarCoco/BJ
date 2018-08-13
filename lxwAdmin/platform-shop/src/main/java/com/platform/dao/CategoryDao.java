package com.platform.dao;

import com.platform.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-21 15:32:31
 */
public interface CategoryDao extends BaseDao<CategoryEntity> {

    public int deleteByParentBatch(Object[] id);

    List<CategoryEntity> querySmx();

    List<CategoryEntity> querySmxs();

    List<CategoryEntity> queryMax(@Param("parentId") Integer parentId);

    List<CategoryEntity> queryMin(Integer parentId1);

    List<CategoryEntity> queryListing(Map<String, Object> map);
    List<CategoryEntity> queryParentName(String parentId);
    List<CategoryEntity> queryParent(String parentId);

}
