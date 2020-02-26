package com.syau.controller;

import com.syau.domain.Article;
import com.syau.domain.Comments;
import com.syau.service.ArticleService;
import com.syau.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//评论
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/save")
    public String save(Comments comments) throws Exception {
        //查找文章
        Article article = articleService.findById(comments.getaId());

        //修改文章评论数目
        article.setCommentNum(article.getCommentNum()+1);
        articleService.update(article);

        commentService.save(comments);
        return "redirect:/index/findById?id="+comments.getaId();
    }
}
