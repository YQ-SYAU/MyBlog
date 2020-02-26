package com.syau.dao;

import com.syau.domain.Support;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

//点赞
public interface SupportDao {

    //保存一条点赞记录
    @Insert("insert into support(id,uId,aId) values (#{id},#{uId},#{aId})")
    void save(Support support )throws Exception;

    //删除一条点赞记录
    @Delete("delete from support where aId = #{aId} and uId = #{uId}")
    void delete(Support support)throws Exception;

    //查找用户是否有点赞记录
    @Select("select * from support where aId=#{aId} and uId=#{uId}")
    Support findById(@Param("aId") String aId, @Param("uId") String uId)throws Exception;

    //查找该用户点赞总数目
    @Select("select count(*) from support where uId = #{uId}")
    int findSupportNumByuId(String uId)throws Exception;

    //通过文章id删除一条记录
    @Delete("delete from support where aId=#{aId}")
    void delByAid(String aId);
}
