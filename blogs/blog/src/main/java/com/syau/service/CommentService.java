package com.syau.service;

import com.syau.domain.Article;
import com.syau.domain.Comments;

import java.util.List;

public interface CommentService {
    void save(Comments comments)throws Exception;

    List<Comments> findCommentsById(String id)throws Exception;

    int findCountById(String id)throws Exception;

    int findUserCommentNum(String uId)throws Exception;

    void delByAid(String aId)throws Exception;
}
