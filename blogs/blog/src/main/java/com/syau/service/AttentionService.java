package com.syau.service;

import com.syau.domain.Article;
import com.syau.domain.Attention;

import java.util.List;

public interface AttentionService {
    void save(Attention attention)throws Exception;

    void delete(Attention attention)throws Exception;

    Attention findById(String id, String id1)throws Exception;

    int findCount(String uId)throws Exception;

    List<Attention> findMyAttention(String uId)throws Exception;
}
