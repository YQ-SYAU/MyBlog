package com.syau.service.impl;


import com.github.pagehelper.PageHelper;
import com.syau.dao.ArticleDao;
import com.syau.domain.Article;
import com.syau.service.ArticleService;
import com.syau.service.CommentService;
import com.syau.service.SupportService;
import com.syau.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CommentService commentService;
    @Autowired
    private SupportService supportService;

    //通过分类id删除所有文章
    public void delByCid(String cid)throws Exception{
        articleDao.delByCid(cid);
    }

    //获取排行榜数据 点赞最多
    @Override
    public List<Article> findSupport() throws Exception {
        return articleDao.findSupport();
    }

    //查询最新数据
    @Override
    public List<Article> findNew() throws Exception {
        return articleDao.findNew();
    }

    //获取浏览最多
    @Override
    public List<Article> findBrowse() throws Exception {
        return articleDao.findBrowse();
    }

    //分类获取文章数据
    @Override
    public List<Article> findByCid(String cid,int pageNum,int pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return articleDao.findByCid(cid);
    }

    //通过id查找文章数据
    @Override
    public Article findById(String id) throws Exception {
        return articleDao.findById(id);
    }

    @Override
    public int findCountByUId(String id) throws Exception {
        return articleDao.findCountByUId(id);
    }

    //更新文章
    @Override
    public void update(Article article) throws Exception {
        articleDao.update(article);
    }

    //通过用户id查找用户发布的所有文章
    @Override
    public List<Article> findByUid(String uId) throws Exception {
        return articleDao.findByUid(uId);
    }

    //查找用户关原创文章数目
    @Override
    public int findCountByUid(String uId) throws Exception {
        return articleDao.findCountByUid(uId);
    }

    //保存文章信息
    @Override
    public void save(Article article) throws Exception {
        //设置id
        article.setId(UUIDUtils.getId());
        //设置信息
        article.setSupport(0);
        article.setBrowse(0);
        article.setCommentNum(0);
        //设置默认照片
        if(article.getPicture()==null){
            article.setPicture("article/201610181739277776.jpg");
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        article.setPublishTime(sdf.format(date));
        articleDao.save(article);
    }

    //获取我发布的文章信息
    @Override
    public  List<Article> findMyArticle(String uId) throws Exception {
       return articleDao.findMyArticle(uId);
    }


    //删除文章信息
    @Override
    public void delArticle(String aId) throws Exception {
        //删除评论表
        commentService.delByAid(aId);
        //删除点赞表
        supportService.delByAid(aId);
        articleDao.delArticle(aId);
    }
}
