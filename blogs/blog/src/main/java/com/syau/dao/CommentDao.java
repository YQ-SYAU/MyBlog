package com.syau.dao;

import com.syau.domain.Article;
import com.syau.domain.Comments;
import com.syau.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CommentDao {
    //保存一条评论信息
    @Insert("insert into comments(id,u_id,a_id,c_time,content) values(#{id},#{userInfo.id},#{aId},#{cTime},#{content})")
    void save(Comments comments)throws Exception;

    @Results(id="commentMap",
            value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "cTime",column = "c_time"),
            @Result(property = "content",column = "content"),
            @Result(property = "aId",column = "a_id"),
            @Result(property = "userInfo",column = "u_id", javaType = UserInfo.class,
                    many = @Many(select = "com.syau.dao.UserDao.findById",fetchType = FetchType.EAGER)),
    })
    @Select("select * from comments where a_id = #{id} order by c_time asc")
    List<Comments> findCommentsById(String id)throws Exception;

    //查询文章评论总数
    @Select("select count(*) from comments where a_id =#{id}")
    int findCountById(String id)throws Exception;

    //查找用户评论数目
    @Select("select count(*) from comments where u_id=#{uId}")
    int findUserCommentNum(String uId)throws Exception;

    //通过文章id删除一条信息
    @Delete("delete from comments where a_id =#{aId}")
    void delByAid(String aId)throws Exception;
}
