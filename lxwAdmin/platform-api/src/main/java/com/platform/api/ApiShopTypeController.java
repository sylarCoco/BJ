package com.platform.api;

import com.alibaba.fastjson.JSONObject;
import com.platform.annotation.IgnoreAuth;
import com.platform.annotation.LoginUser;
import com.platform.dao.ApiOrderMapper;
import com.platform.entity.*;
import com.platform.service.ApiCategoryService;
import com.platform.service.ApiOrderService;
import com.platform.service.ApiUserService;
import com.platform.util.ApiBaseAction;
import com.platform.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/api/shop")
public class ApiShopTypeController extends ApiBaseAction {
    @Autowired
    private ApiOrderService apiOrderService;
    @Autowired
    private ApiOrderMapper apiOrderMapper;
    @Autowired
    private ApiUserService userService;

    @RequestMapping("save")
    public Object list(@LoginUser UserVo loginUser, Integer parentId) {
        Map Param = new HashMap();
        Param.put("user_id", loginUser.getUserId());
        JSONObject shopJson = this.getJsonRequest();
        ShopTypeVo shopTypeVo = new ShopTypeVo();
        if (null != shopJson) {
            shopTypeVo.setShopName(shopJson.getString("shipping_name"));
            shopTypeVo.setIntegral(shopJson.getString("integral"));
            shopTypeVo.setGoodsPrice(shopJson.getString("goods_price"));
            shopTypeVo.setDetailInfo(shopJson.getString("detailInfo"));
            shopTypeVo.setMobile(shopJson.getString("mobile"));
        }
        UserVo  userVo = userService.queryById(loginUser.getUserId());
        if(shopTypeVo.getMobile()!=null && !"".equals(shopTypeVo.getMobile())){
            userVo.setMobile(shopTypeVo.getMobile());
            userService.update(userVo);
        }
        BigDecimal orderTotalPrice = new BigDecimal(shopTypeVo.getGoodsPrice());

        OrderVo orderInfo = new OrderVo();
        orderInfo.setOrder_sn(CommonUtil.generateOrderNumber());
        orderInfo.setDistrict(shopTypeVo.getDetailInfo());
        orderInfo.setShipping_name(shopTypeVo.getShopName());
        orderInfo.setUser_id(loginUser.getUserId());
        orderInfo.setMobile(shopTypeVo.getMobile());
        orderInfo.setIntegral(Integer.valueOf(shopTypeVo.getIntegral()));
        orderInfo.setGoods_price(orderTotalPrice);
        orderInfo.setOrder_status(0);
        orderInfo.setAdd_time(new Date().toString());
        // 待付款
        orderInfo.setOrder_status(0);
        orderInfo.setShipping_status(0);
        orderInfo.setPay_status(0);
        orderInfo.setShipping_id(0);

        //开启事务，插入订单信息和订单商品
        apiOrderMapper.save(orderInfo);
        Map<String, Object> resultObj = new HashMap();
        if (null == orderInfo.getId()) {
            resultObj.put("errno", 1);
            resultObj.put("errmsg", "订单提交失败");
            return resultObj;
        }


        return toResponsSuccess(resultObj);
    }

    @RequestMapping("list")
    public Object list(@LoginUser UserVo loginUser) {
        Map param = new HashMap();
        param.put("user_id", loginUser.getUserId());
        List<OrderVo> OrderVo = apiOrderService.queryList(param);
        return toResponsSuccess(OrderVo);
    }

    @IgnoreAuth
    @RequestMapping("detail")
    public Object detail(Integer id) {
        OrderVo orderVo = apiOrderService.queryObject(id);
        return toResponsSuccess(orderVo);
    }

    @IgnoreAuth
    @RequestMapping("delete")
    public Object delete() {
        JSONObject jsonParam = this.getJsonRequest();
        apiOrderService.delete(jsonParam.getIntValue("id"));
        return toResponsSuccess("");
    }
}

