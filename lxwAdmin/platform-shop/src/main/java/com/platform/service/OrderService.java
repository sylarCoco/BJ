package com.platform.service;

import com.platform.entity.BillnewEntity;
import com.platform.entity.OrderEntity;
import com.platform.entity.SendingEntity;
import com.platform.entity.UserEntity;
import com.platform.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-06-25 13:14:05
 */
public interface OrderService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    OrderEntity queryObject(Integer id);


    OrderEntity queryListOrder(String orderSn);


    OrderEntity querys(Integer id);
    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<OrderEntity> queryList(Map<String, Object> map);

    List<OrderEntity> queryListed(Integer id);

    List<OrderEntity> queryListing(Map<String, Object> map);
    List<OrderEntity> queryListSos(Map<String, Object> map);
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
     * @param order 实体
     * @return 保存条数
     */
    int save(OrderEntity order);

    /**
     * 根据主键更新实体
     *
     * @param order 实体
     * @return 更新条数
     */
    int update(OrderEntity order, SendingEntity sendingEntity, BillnewEntity billnewEntity) throws ParseException;
    int updates(OrderEntity order, SendingEntity sendingEntity, BillnewEntity billnewEntity) throws ParseException;
    int update(OrderEntity order, SendingEntity sendingEntity);

    int update(OrderEntity order);
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

    String selectpos(Integer id);


}
