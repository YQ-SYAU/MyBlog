package com.syau.dao;

import com.syau.domain.Article;

import java.util.List;

public interface ArticleDao {

    void delByCid(String cid)throws Exception;

    List<Article> findSupport()throws Exception;

    List<Article> findNew()throws Exception;

    List<Article> findBrowse()throws Exception;

    List<Article> findByCid(String cid)throws Exception;

    Article findById(String id)throws Exception;

    int findCountByUId(String id)throws Exception;

    void update(Article article)throws Exception;

    List<Article> findByUid(String uId)throws Exception;

    int findCountByUid(String uId)throws Exception;;

    void save(Article article)throws Exception;;

    List<Article> findMyArticle(String uId)throws Exception;

    void delArticle(String aId)throws Exception;
}
