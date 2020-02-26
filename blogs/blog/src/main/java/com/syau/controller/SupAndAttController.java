package com.syau.controller;

import com.syau.domain.Article;
import com.syau.domain.Attention;
import com.syau.domain.Support;
import com.syau.domain.UserInfo;
import com.syau.service.ArticleService;
import com.syau.service.AttentionService;
import com.syau.service.SupportService;
import com.syau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


//处理点赞和关注
@Controller
@RequestMapping("/supAndAtt")
@ResponseBody
public class SupAndAttController {

    @Autowired
    private SupportService supportService;
    @Autowired
    private AttentionService attentionService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    //关注
    @RequestMapping("/saveAttention")
    public void saveAttention(Attention attention) throws Exception {
        //保存关注信息
        attentionService.save(attention);
        //改变用户粉丝数据
        UserInfo userInfo = userService.findById(attention.getOther().getId());
        userInfo.setFans(userInfo.getFans()+1);
        userService.update(userInfo);
        request.setAttribute("aflag","1");
    }

    //取消关注
    @RequestMapping("/delAttention")
    public void delAttention(Attention attention) throws Exception {
       //删除关注信息
        attentionService.delete(attention);
        //改变用户粉丝数据
        UserInfo userInfo = userService.findById(attention.getOther().getId());
        userInfo.setFans(userInfo.getFans()-1);
        userService.update(userInfo);
        request.setAttribute("aflag","0");
    }

    //点赞
    @RequestMapping("/saveSupport")
    public void saveSupport(Support support) throws Exception {
        supportService.save(support);
        //改变文章点赞数据
        Article article = articleService.findById(support.getaId());
        article.setSupport(article.getSupport()+1);
        articleService.update(article);
        request.setAttribute("flag","1");
    }

    //取消赞
    @RequestMapping("/delSupport")
    public void delSupport(Support support) throws Exception {
        supportService.delete(support);
        //改变文章点赞数据
        Article article = articleService.findById(support.getaId());
        article.setSupport(article.getSupport()-1);
        articleService.update(article);
        request.setAttribute("flag","0");
    }
}
