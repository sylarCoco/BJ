package com.platform.controller;

import com.aliyuncs.exceptions.ClientException;
import com.platform.entity.RegisterEntity;
import com.platform.entity.UserEntity;
import com.platform.service.AreaService;
import com.platform.service.RegisterService;
import com.platform.service.UserService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
import com.platform.utils.excel.ExcelExport;
import com.platform.utils.smsUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-16 15:02:28
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private RegisterService registerService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<UserEntity> userList = userService.queryList(query);
        int total = userService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("user:info")
    public R info(@PathVariable("id") Integer id) {
        UserEntity user = userService.queryObject(id);

        return R.ok().put("user", user);
    }
    @RequestMapping("/infos/{id}")
    @RequiresPermissions("user:info")
    public R infos(@PathVariable("id") Integer id) {
        UserEntity user = userService.queryObjects(id);

        return R.ok().put("user", user);
    }
    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:save")
    @Transactional
    public R save(@RequestBody UserEntity user, RegisterEntity registerEntity) throws ClientException {
        String  address  = areaService.queryMaxs(user.getAddress());
        user.setAddress(address);
        String [] arr=address.split(",");
        String a0=arr[0];
        user.setProvince(a0);
        String a1=arr[1];
        user.setRegion(a1);
        String a2=arr[2];
        user.setTown(a2);
        user.setPhoneNumber(user.getContactMobile());
        registerEntity.setPeopleName(user.getPeopleName());
        registerEntity.setContactMobile(user.getContactMobile());
        registerEntity.setMangeName(user.getMangeName());
        try{
                registerService.save(registerEntity);
            }catch (Exception e){
                return R.error("注册失败,用户已存在!");
            }
            try {
                userService.save(user);
            }catch (Exception e){
                registerService.deleteing(user.getContactMobile());
            return  R.error("注册失败,客户名称不能重复");
            }
            //调短信接口
           int a=smsUtils.sendMsg(user.getMangeName(),user.getContactMobile(),"666666");
           if(a==1){
               return R.ok("注册成功");
           }else if(a==2){
                       userService.deleteing(user.getContactMobile());
                       registerService.deleteing(user.getContactMobile());
               return R.error("发送短信失败，注册失败!");
           }

            return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:update")
    public R update(@RequestBody UserEntity user) {
        String  address  = areaService.queryMaxs(user.getAddress());
        user.setAddress(address);
        String [] arr=address.split(",");
        String a0=arr[0];
        user.setProvince(a0);
        String a1=arr[1];
        user.setRegion(a1);
        String a2=arr[2];
        user.setTown(a2);
        userService.update(user);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:delete")
    public R delete(@RequestBody Integer[] ids) {
        userService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<UserEntity> userList = userService.queryList(params);

        return R.ok().put("list", userList);
    }

    /**
     * 总计
     */
    @RequestMapping("/queryTotal")
    public R queryTotal(@RequestParam Map<String, Object> params) {
        int sum = userService.queryTotal(params);

        return R.ok().put("userSum", sum);
    }

    /**
     * 导出会员
     */
    @RequestMapping("/export")
    @RequiresPermissions("user:export")
    public R export(@RequestParam Map<String, Object> params, HttpServletResponse response) {

        List<UserEntity> userList = userService.queryList(params);

        ExcelExport ee = new ExcelExport("会员列表");

        String[] header = new String[]{"会员名称", "性别", "会员级别", "手机号码"};

        List<Map<String, Object>> list = new ArrayList<>();

        if (userList != null && userList.size() != 0) {
            for (UserEntity userEntity : userList) {
                LinkedHashMap<String, Object> map = new LinkedHashMap<>();
                map.put("USERNAME", userEntity.getUsername());
                map.put("GENDER", userEntity.getGender() == 1 ? "男" : (userEntity.getGender() == 2 ? "女" : "未知"));
                map.put("LEVEL_NAME", userEntity.getLevelName());
                map.put("MOBILE", userEntity.getMobile());
                list.add(map);
            }
        }

        ee.addSheetByMap("会员", list, header);
        ee.export(response);
        return R.ok();
    }
}
