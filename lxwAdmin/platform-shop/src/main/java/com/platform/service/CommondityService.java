package com.platform.service;
import com.platform.entity.CommondityEntity;
import java.util.List;
import java.util.Map;

public interface CommondityService  {
    CommondityEntity queryObject(Integer id);

    List<CommondityEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    int update(CommondityEntity user);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);

    int save(CommondityEntity provider);
}
