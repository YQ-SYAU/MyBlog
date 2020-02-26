package com.syau.dao;

import com.syau.domain.Article;
import com.syau.domain.Attention;
import com.syau.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

//关注
public interface AttentionDao {

    //保存一条关注记录
    @Insert("insert into attention(id,u_id,p_id)values(#{id},#{myself.id},#{other.id})")
    void save(Attention attention)throws Exception;


    //删除一条关注记录
    @Delete("delete from attention where u_id=#{myself.id} and p_id=#{other.id}")
    void delete(Attention attention)throws Exception;


    //通过(关注者和被关注者的)id查找一条记录
    @Select("select * from attention where p_id=#{oId} and u_id=#{uId}")
    Attention findById(@Param("oId") String oId,@Param("uId") String uId)throws Exception;

    //获取我的关注数
    @Select("select count(*) from attention where u_id = #{uId}")
    int findCount(String uId);

    //查找我的关注
    @Select("select * from attention where u_id=#{uId}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "myself",column = "u_id",javaType = UserInfo.class,
            one = @One(select = "com.syau.dao.UserDao.findById")),
            @Result(property = "other",column = "p_id",javaType = UserInfo.class,
                    one = @One(select = "com.syau.dao.UserDao.findById")),
    })
    List<Attention> findMyAttention(String uId);
}
