package com.syau.service.impl;

import com.syau.dao.AttentionDao;
import com.syau.domain.Article;
import com.syau.domain.Attention;
import com.syau.service.AttentionService;
import com.syau.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//关注
@Service
@Transactional
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    private AttentionDao attentionDao;


    //保存一条关注记录
    @Override
    public void save(Attention attention) throws Exception {
        //设置id
        attention.setId(UUIDUtils.getId());
        attentionDao.save(attention);
    }

    //删除一条关注记录
    @Override
    public void delete(Attention attention) throws Exception {
        attentionDao.delete(attention);
    }

    //通过(关注者和被关注者的)id查找一条记录
    @Override
    public Attention findById(String oId, String uId) throws Exception {
        return attentionDao.findById(oId,uId);
    }

    //获取我的关注数
    @Override
    public int findCount(String uId) throws Exception {
        return attentionDao.findCount(uId);
    }

    //查找我的关注
    @Override
    public List<Attention> findMyAttention(String uId) throws Exception {
        return attentionDao.findMyAttention(uId);
    }

}
