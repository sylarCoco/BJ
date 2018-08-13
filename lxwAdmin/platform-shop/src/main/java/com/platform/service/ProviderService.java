package com.platform.service;

import com.platform.entity.OpeningBank;
import com.platform.entity.Provider;
import com.platform.entity.ProviderOpeningEntity;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;
import java.util.UUID;


public interface ProviderService {
    Provider queryObject(Integer id);

    List<Provider> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    List<Provider> queryUsername();

    int update(Provider user,OpeningBank openingBank);

    int delete(Integer id);

    void deleteBatch(Integer[] ids);

    int save(Provider provider, OpeningBank openingBank);

}




