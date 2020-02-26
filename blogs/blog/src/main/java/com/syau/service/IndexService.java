package com.syau.service;

import com.syau.domain.Category;
import com.syau.domain.Slideshow;

import java.util.List;

public interface IndexService {

    List<Category> findAllCategory()throws Exception;

    Slideshow findAllSlideshow()throws Exception;

    void save(String cname)throws Exception;

    void updateCname(String id, String cname)throws Exception;

    void delete(String id)throws Exception;

    void updateSlideshow(String fielShowPath, String flag)throws Exception;
}
