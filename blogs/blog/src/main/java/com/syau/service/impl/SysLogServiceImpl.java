package com.syau.service.impl;

import com.github.pagehelper.PageHelper;
import com.syau.dao.SysLogDao;
import com.syau.domain.SysLog;
import com.syau.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;


    //保存日志
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    //查找所有日志
    @Override
    public List<SysLog> findAll(int pageNum,int pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return sysLogDao.findAll();
    }

//    @Override
//    public List<SysLog> findAll() throws Exception {
//        return sysLogDao.findAll();
//    }
}
