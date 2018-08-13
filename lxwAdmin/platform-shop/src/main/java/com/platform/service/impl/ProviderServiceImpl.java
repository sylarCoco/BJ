package com.platform.service.impl;

import com.platform.dao.OpeningBankDao;
import com.platform.dao.ProviderDao;
import com.platform.entity.OpeningBank;
import com.platform.entity.Provider;
import com.platform.entity.ProviderOpeningEntity;
import com.platform.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import sun.util.calendar.BaseCalendar;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderDao providers;
    @Resource
    OpeningBankDao openingBankDao;

    @Override
    public Provider queryObject(Integer id) {
        return providers.queryObject(id);
    }

    @Override
    public List<Provider> queryList(Map<String, Object> map) {
        return providers.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return providers.queryTotal();
    }

    @Override
    public List<Provider> queryUsername() {
        return providers.queryName();
    }


    @Override
    @Transactional
    public int save(Provider provider, OpeningBank openingBank) {
        Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat s = new SimpleDateFormat("yyyymmddHHmmss");
        Date b=calendar.getTime();
        String brandId="GYS"+s.format(b);
        System.out.println(brandId);
       /* String brandId = UUID.randomUUID().toString();*/
        provider.setBrandId(brandId);
        int result = providers.save(provider);
        if (result == 1) {
            openingBank.setOpeningBank(provider.getOpengingBank());
            openingBank.setAccountName(provider.getAccountName());
            openingBank.setAccountNumber(provider.getAccountNumber());
            openingBank.setBrandId(brandId);
            return openingBankDao.save(openingBank);
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Integer.parseInt(null);
        }
    }

    @Override
    @Transactional
    public int update(Provider provider, OpeningBank openingBank) {
        int result = providers.update(provider);
        if (result == 1) {
            openingBank.setOpeningBank(provider.getOpengingBank());
            openingBank.setAccountName(provider.getAccountName());
            openingBank.setAccountNumber(provider.getAccountNumber());
            String brandId = provider.getBrandId();
            openingBank.setBrandId(brandId);

            return openingBankDao.update(openingBank);
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Integer.parseInt(null);
        }
    }

    @Override
    public int delete(Integer id) {
        return providers.delete(id);
    }

    @Override
    @Transactional
    public void deleteBatch(Integer[] ids) {
        for(int i=0;i<ids.length;i++) {
            String arr = providers.select(ids[i]);
            int result=openingBankDao.delete(arr);
            if(result==1){
                }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                break;
            }
            int result1=providers.delete(ids[i]);
            if(result1==1){
                }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                break;
            }
        }

}

}
