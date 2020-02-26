package com.syau.service.impl;

import com.syau.dao.CommentDao;
import com.syau.domain.Comments;
import com.syau.service.CommentService;
import com.syau.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//评论文章
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    //保存一条评论信息
    @Override
    public void save(Comments comments) throws Exception {
        //设置id
        comments.setId(UUIDUtils.getId());
        //设置时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        comments.setcTime(sdf.format(date));
        commentDao.save(comments);
    }

    //通过文章id评论
    @Override
    public List<Comments> findCommentsById(String id) throws Exception {
        return commentDao.findCommentsById(id);
    }

    //查询文章评论总数
    @Override
    public int findCountById(String id) throws Exception {
        return commentDao.findCountById(id);
    }

    //查找用户评论数目
    @Override
    public int findUserCommentNum(String uId) throws Exception {
        return commentDao.findUserCommentNum(uId);
    }

    //通过文章id删除一条记录
    @Override
    public void delByAid(String aId) throws Exception {
        commentDao.delByAid(aId);
    }
}
