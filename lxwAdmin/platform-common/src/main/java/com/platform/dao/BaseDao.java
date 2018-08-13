package com.platform.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年9月18日 上午9:31:36
 */
public interface BaseDao<T> {

    int save(T t);

    void save(Map<String, Object> map);

    void saveBatch(List<T> list);

    int update(T t);

    int update(Map<String, Object> map);

    int delete(Object id);

    int delete(String id);

    int delete(Map<String, Object> map);

    int deleteBatch(Object[] id);

    int deleteing(String contactMobile);

    T queryObject(Object id);
    T queryObjects(Object id);

    List<T> queryList(Map<String, Object> map);

    List<T> queryListing(Map<String, Object> map);
    List<T> queryList(Object id);

    int queryTotal(Map<String, Object> map);

    int queryTotal();

    List<T> queryListSos(Map<String, Object> map);
    T  queryListSosP(Map<String, Object> map);
    String select(Integer id);

    T querys(Object id);

    Integer selecting(String orderSn);

    int updates(Integer orderStatus);

    int updating(T t);

    List<T> queryName();

    List<T> querySmx();
    List<T> querySmxs();
    List<T> queryMax( String parentId);
    List<T> queryMin(String parentId);

    List<T> queryParentName(String parentId);
    List<T> queryParentNames(String parentId);
    List<T> queryParent(String parentId);

    String selects(String parentId);

    List<T> queryListOrder(T t);
    List<T> selectMobile();

    int selectId(String mobile);

    String selectpos(Integer id);

    T queryObj(Object id);

    T queryListOrder(String orderSn);
    int select(String billNumber);

    T queryWeek(String date,String cycleType);
    T queryMonth(String date);
    T queryYear(String date);
    List<T> querying();

    String queryBillNumber(T t);

}
