package com.syau.dao;

import com.syau.domain.Category;
import com.syau.domain.Slideshow;
import org.apache.ibatis.annotations.*;

import java.util.List;

//分类和轮播图持久层
public interface IndexDao {

    //通过id查询所有分类
    @Select("select * from category where id = #{id}")
    Category findById(String id);

    //查询所有分类
    @Select("select * from category")
    List<Category> findAllCategory()throws Exception;

    //查询轮播图
    @Select("select * from slideshow")
    Slideshow findAllSlideshow()throws Exception;

    //添加分类
    @Insert("insert into category(id,cname) values (#{id},#{cname})")
    void save(@Param("id") String id, @Param("cname") String cname)throws Exception;

    //修改分类
    @Update("update category set cname=#{cname} where id=#{id}")
    void updateCname(@Param("id") String id, @Param("cname") String cname)throws Exception;

    //删除分类
    @Delete("delete from category where id=#{id}")
    void delete(String id)throws Exception;
    //修改第一张
    @Update("update slideshow set picture1=#{fielShowPath}")
    void updateSlideshow1(String fielShowPath);
    @Update("update slideshow set picture2=#{fielShowPath}")
    void updateSlideshow2(String fielShowPath);
    @Update("update slideshow set picture3=#{fielShowPath}")
    void updateSlideshow3(String fielShowPath);
}
