package com.syau.service.impl;

import com.syau.dao.SupportDao;
import com.syau.domain.Support;
import com.syau.service.SupportService;
import com.syau.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SupportServiceImpl implements SupportService {

    @Autowired
    private SupportDao supportDao;

    //保存一条点赞记录
    @Override
    public void save(Support support) throws Exception {
        //设置id
        support.setId(UUIDUtils.getId());
        supportDao.save(support);
    }

    //删除一条点赞记录
    @Override
    public void delete(Support support) throws Exception {
        supportDao.delete(support);
    }

    //查找用户是否有点赞记录
    @Override
    public Support findById(String aId, String uId) throws Exception {
        return supportDao.findById(aId,uId);
    }

    //查找该用户点赞总数目
    @Override
    public int findSupportNumByuId(String uId) throws Exception {
        return supportDao.findSupportNumByuId(uId);
    }

    //通过文章id删除一条记录
    @Override
    public void delByAid(String aId) throws Exception {

        supportDao.delByAid(aId);
    }
}
