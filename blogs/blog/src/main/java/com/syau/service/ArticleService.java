package com.syau.service;

import com.syau.domain.Article;

import java.util.List;

public interface ArticleService {

    void delByCid(String cid)throws Exception;

    List<Article> findSupport()throws Exception;

    List<Article> findNew()throws Exception;

    List<Article> findBrowse()throws Exception;

    List<Article> findByCid(String cid,int pageNum,int pageSize)throws Exception;

    Article findById(String id)throws Exception;

    int findCountByUId(String id)throws Exception;

    void update(Article article)throws Exception;

    List<Article> findByUid(String uId)throws Exception;

    int findCountByUid(String id)throws Exception;

    void save(Article article)throws Exception;

    List<Article> findMyArticle(String id)throws Exception;

    void delArticle(String aId)throws Exception;
}
