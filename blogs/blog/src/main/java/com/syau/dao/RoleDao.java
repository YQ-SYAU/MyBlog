package com.syau.dao;

import com.syau.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

//角色持久层
public interface RoleDao {

    @Select("select * from role where id in(select roleId from user_role where userId=#{userId})")
    public Set<Role> findRoleByUserId(String userId)throws Exception;
}
