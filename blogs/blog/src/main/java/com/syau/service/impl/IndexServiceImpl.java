package com.syau.service.impl;

import com.syau.dao.ArticleDao;
import com.syau.dao.IndexDao;
import com.syau.domain.Category;
import com.syau.domain.Slideshow;
import com.syau.service.IndexService;
import com.syau.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexDao indexDao;
    @Autowired
    private ArticleDao articleDao;


    @Override
    //查找所有分类
    public List<Category> findAllCategory() throws Exception {
        return indexDao.findAllCategory();
    }

    @Override
    //查找轮播图
    public Slideshow findAllSlideshow() throws Exception {
        return indexDao.findAllSlideshow();
    }

    @Override
    //添加分类
    public void save(String cname) throws Exception {
        //设置id
        String id = UUIDUtils.getId();
        indexDao.save(id,cname);
    }

    @Override
    //修改分类
    public void updateCname(String id, String cname) throws Exception {
        indexDao.updateCname(id,cname);
    }

    @Override
    //删除分类
    public void delete(String id) throws Exception {

        //先删除引用改分类的文章
        articleDao.delByCid(id);
        //再删除分类
        indexDao.delete(id);
    }

    //更换轮播图
    @Override
    public void updateSlideshow(String fielShowPath, String flag) throws Exception {
        if("1".equals(flag)){
            indexDao.updateSlideshow1(fielShowPath);
        }else if("2".equals(flag)){
            indexDao.updateSlideshow2(fielShowPath);
        }else{
            indexDao.updateSlideshow3(fielShowPath);
        }
    }
}
