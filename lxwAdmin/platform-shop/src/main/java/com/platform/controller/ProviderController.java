package com.platform.controller;

import com.platform.dao.ProviderDao;
import com.platform.entity.*;
import com.platform.service.AreaService;
import com.platform.service.ProviderService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("provider")
public class ProviderController {
    @Autowired
    ProviderService providerService;
    @Autowired
    private AreaService areaService;
    @Resource
    ProviderDao providerDao;
    @RequestMapping("/save")
    @RequiresPermissions("provider:delete")
    public R save(@RequestBody Provider provider, OpeningBank openingBank){
         System.out.println(provider);
         String  address  = areaService.queryMaxs(provider.getAddress());
         provider.setAddress(address);
         String [] arr=address.split(",");
         String a0=arr[0];
         provider.setProvince(a0);
         String a1=arr[1];
         provider.setRegion(a1);
         String a2=arr[2];
         provider.setTown(a2);
         providerService.save(provider,openingBank);
        return R.ok();
    }
   @RequestMapping("/list")
   @RequiresPermissions("provider:list")
    public R list(@RequestParam Map<String,Object> map){
        Query query=new Query(map);
        List<Provider> providerList = providerService.queryList(query);
        int total=providerService.queryTotal(query);
        PageUtils pageUtils=new PageUtils(providerList,total,query.getLimit(),query.getPage());
        return R.ok().put("page",pageUtils);
   }
  @RequestMapping("/update")
  @RequiresPermissions("provider:update")
  public R update(@RequestBody Provider provider,OpeningBank openingBank) {
        System.out.println(provider);
      String  address  = areaService.queryMaxs(provider.getAddress());
      provider.setAddress(address);
      String [] arr=address.split(",");
      String a0=arr[0];
      provider.setProvince(a0);
      String a1=arr[1];
      provider.setRegion(a1);
      String a2=arr[2];
      provider.setTown(a2);
      providerService.update(provider,openingBank);
      return R.ok();
  }
    @RequestMapping("/info/{id}")
    @RequiresPermissions("provider:info")
    public R info(@PathVariable("id") Integer id) {
        Provider  product = providerService.queryObject(id);
        System.out.println(product);
        return R.ok().put("product", product);
    }
    @RequestMapping("/delete")
    @RequiresPermissions("provider:info")
    public R delete(@RequestBody Integer[] ids) {
        providerService.deleteBatch(ids);
        return R.ok();
    }
    @RequestMapping("/least")
    public R least(@RequestParam Map<String,Object> map) {
        List<Provider>  list1  = providerService.queryUsername();
        return R.ok().put("list", list1);
    }

    @RequestMapping("/area")
    public R list1(@RequestParam Map<String, Object> params) {
        params.put("grade", "1");
        //查询列表数据
        // List<CategoryEntity>  list  = categoryService.queryList(params);
        List<AreaEntity>  list1  = areaService.querySmx();
        System.out.println(list1);
        return R.ok().put("list", list1);
    }

    @RequestMapping("/listing")
    public R listing(@RequestParam Map<String, Object> params) {
        params.put("grade", "2");
        //查询列表数据
        // List<CategoryEntity>  list  = categoryService.queryList(params);
        List<AreaEntity> list1 = areaService.querySmxs();
        return R.ok().put("list", list1);
    }

    @RequestMapping("/listMax")
    public R list12(@RequestParam Map<String, Object> params) {
        String parentId = (String) params.get("parentId");
        List<AreaEntity>  list  = areaService.queryMax(parentId);
        return R.ok().put("list", list);
    }
    @RequestMapping("/listMin")
    public R list2(@RequestParam Map<String, Object> params) {
        String parentId = (String) params.get("parentId");
        List<AreaEntity>  list  = areaService.queryMin(parentId);
        return R.ok().put("list", list);
    }


}
