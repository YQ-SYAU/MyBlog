package com.syau.service;

import com.syau.domain.Support;

public interface SupportService {
    void save(Support support)throws Exception;

    void delete(Support support)throws Exception;

    Support findById(String aId, String uId)throws Exception;

    int findSupportNumByuId(String uId)throws Exception;

    void delByAid(String aId)throws Exception;
}
