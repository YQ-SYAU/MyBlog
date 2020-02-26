package com.syau.service;

import com.syau.domain.SysLog;

import java.util.List;

public interface SysLogService {
    void save(SysLog sysLog)throws Exception;

    List<SysLog> findAll(int pageNum,int pageSize)throws Exception;

//    List<SysLog> findAll()throws Exception;
}
