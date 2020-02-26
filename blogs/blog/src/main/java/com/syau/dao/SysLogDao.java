package com.syau.dao;

import com.syau.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


//系统日志
public interface SysLogDao {


    @Insert("insert into sysLog(id,visitTime,username,ip,url,executionTime,method) values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog)throws Exception;

    @Select("select * from sysLog order by visitTime desc")
    List<SysLog> findAll()throws Exception;

}
