package com.syau.dao;


import com.syau.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.Set;
import java.util.List;

public interface UserDao {

    //通过用户名查找用户
    @Select("select * from user where username = #{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "qq",column = "qq"),
            @Result(property = "gender",column = "gender"),
            @Result(property = "picture",column = "picture"),
            @Result(property = "description",column = "description"),
            @Result(property = "fans",column = "fans"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = Set.class,
            many = @Many(select = "com.syau.dao.RoleDao.findRoleByUserId")),
    })
    public UserInfo findByUsername(String username)throws Exception;

    @Select("select * from user")
    public List<UserInfo> findAll()throws Exception;

    //保存用户
    @Insert("insert into user(id,username,password,qq,picture,fans,status,gender) values (#{id},#{username},#{password},#{qq},#{picture},#{fans},#{status},#{gender})")
    void save(UserInfo userInfo)throws Exception;

    //修改用户状态
    @Update("update user set status = #{status} where id=#{id}")
    void updateStatus(@Param("id") String id,@Param("status") Integer status)throws Exception;

    //设置角色
    @Insert("insert into user_role(userId,roleId) values(#{uid},2)")
    void setUserRole(String uid)throws Exception;

    //通过id查找用户
    @Select("select * from user where id=#{id}")
    UserInfo findById(String id)throws Exception;

    //修改用户信息
    @Update("update user set username=#{username}, password=#{password},gender=#{gender},picture=#{picture},description=#{description},fans=#{fans} where id=#{id}")
    void update(UserInfo userInfo)throws Exception;

    //查找用户名是否重复（更新用户名）
    @Select("select * from user where username=#{username} and id!=#{uId}")
    List<UserInfo> checkUpdateUsername(@Param("username") String username, @Param("uId") String uId)throws Exception;
}
