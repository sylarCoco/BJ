package com.platform.controller;

import com.alibaba.fastjson.JSON;
import com.platform.entity.SysOssEntity;
import com.platform.oss.CloudStorageConfig;
import com.platform.oss.OSSFactory;
import com.platform.oss.QcloudCloudStorageService;
import com.platform.service.SysConfigService;
import com.platform.service.SysOssService;
import com.platform.utils.*;
import com.platform.validator.ValidatorUtils;
import com.platform.validator.group.AliyunGroup;
import com.platform.validator.group.QcloudGroup;
import com.platform.validator.group.QiniuGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
import java.io.File;
import java.io.InputStream;
import java.util.*;


/**
 * 文件上传
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-25 12:13:26
 */
@RestController
@RequestMapping("sys/oss")
public class SysOssController {
    @Autowired
    private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;
    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:oss:all")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SysOssEntity> sysOssList = sysOssService.queryList(query);
        int total = sysOssService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(sysOssList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 云存储配置信息
     */
    @RequestMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public R config() {
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return R.ok().put("config", config);
    }


    /**
     * 保存云存储配置信息
     */
    @RequestMapping("/saveConfig")
    @RequiresPermissions("sys:oss:all")
    public R saveConfig(@RequestBody CloudStorageConfig config) {
        //校验类型
        ValidatorUtils.validateEntity(config);

        if (config.getType() == Constant.CloudService.QINIU.getValue()) {
            //校验七牛数据
            ValidatorUtils.validateEntity(config, QiniuGroup.class);
        } else if (config.getType() == Constant.CloudService.ALIYUN.getValue()) {
            //校验阿里云数据
            ValidatorUtils.validateEntity(config, AliyunGroup.class);
        } else if (config.getType() == Constant.CloudService.QCLOUD.getValue()) {
            //校验腾讯云数据
            ValidatorUtils.validateEntity(config, QcloudGroup.class);
        }


        sysConfigService.updateValueByKey(KEY, JSON.toJSONString(config));

        return R.ok();
    }
    String dataPortalDir = "C:\\liu\\upload";    //dataPortal路径
    String cacheDir = "/files/cache";

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    @RequiresPermissions("sys:oss:all")
    public R upload(@RequestParam("file") MultipartFile file ,HttpServletRequest request ) throws Exception {

        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());

        //检查form中是否有enctype="multipart/form-data"
        String path =null;
        String filename = file.getOriginalFilename();
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                 file = multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    File filepath = new File(dataPortalDir);

                        path = dataPortalDir+File.separator+UUID.randomUUID()+
                                filename.substring(filename.lastIndexOf("."));
                        // path="E:/springUpload"+file.getOriginalFilename();
                        //上传
                        file.transferTo(new File(path));



                }

            }

        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
//        if (file.isEmpty()) {
//            throw new RRException("上传文件不能为空");
//        }
//        String filename = file.getOriginalFilename();
//        //拷贝文件
//        InputStream inputStream;
//        String htmlUrl = "";
//        inputStream = file.getInputStream();
//        //上传文件
//        String url = OSSFactory.build().upload(file);
//        String tmpFilePath = dataPortalDir+cacheDir+File.separator+UUID.randomUUID()+
//                filename.substring(filename.lastIndexOf("."));
//        //tmpFilePath = FileUtil.copyInputStreamToFile(inputStream, tmpFilePath,false);

        //保存文件信息
        SysOssEntity ossEntity = new SysOssEntity();
        ossEntity.setUrl(path);
        ossEntity.setCreateDate(new Date());
        sysOssService.save(ossEntity);

        R r = new R();
        r.put("url", path);
        r.put("link", path);
        return r;
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:oss:all")
    public R delete(@RequestBody Long[] ids) {
        sysOssService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查询所有列表
     */
    @RequestMapping("/queryAll")
    public List<String> queryAll(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<SysOssEntity> sysOssList = sysOssService.queryList(params);

        List<String> list = new ArrayList<>();
        if (null != sysOssList && sysOssList.size() > 0) {
            for (SysOssEntity item : sysOssList) {
                list.add(item.getUrl());
            }
        }
        return list;
    }
}
