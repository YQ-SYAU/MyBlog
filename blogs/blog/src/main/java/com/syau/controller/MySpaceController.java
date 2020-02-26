package com.syau.controller;

import com.syau.domain.Article;
import com.syau.domain.Attention;
import com.syau.domain.Category;
import com.syau.domain.UserInfo;
import com.syau.service.*;
import com.syau.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

//个人主页
@Controller
@RequestMapping("/mySpace")
public class MySpaceController {

    @Autowired
    private UserService userService;
    @Autowired
    private IndexService indexService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private SupportService supportService;
    @Autowired AttentionService attentionService;
    //SpringSecurity用于加密的bean
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private HttpServletRequest request;


    //检查用户名是否重复
    @RequestMapping("/checkUpdateUsername")
    @ResponseBody
    public String checkUpdateUsername(String username,HttpServletRequest request) throws Exception {
        //得到用户信息
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        String uId = userInfo.getId();
        Boolean flag = userService.checkUpdateUsername(username,uId);
        return flag+"";
    }

    //修改用户信息1
    @RequestMapping("/updateUserInfo1")
    @ResponseBody
    public String updateUserInfo1(@RequestParam CommonsMultipartFile uploadFile, UserInfo userInfo,DefaultMultipartHttpServletRequest request) throws Exception {
        //得到用户信息
        UserInfo userInfo2 = (UserInfo) request.getSession().getAttribute("userInfo");
        //重新设置用户信息
        userInfo2.setUsername(userInfo.getUsername());
        userInfo2.setGender(userInfo.getGender());
        userInfo2.setDescription(userInfo.getDescription());
        if(uploadFile!=null){
            //设置文件名
            String fileName = "";
            //得到原始文件名
            String uploadFileName = uploadFile.getOriginalFilename();
            //获取文件扩展名
            String extendName = uploadFileName.substring(uploadFileName.lastIndexOf("."),uploadFileName.length());
            //设置文件名
            fileName=UUIDUtils.getCode()+extendName;
            //获取文件路径
            String bathPath = request.getServletContext().getRealPath("/picture/user");
            //使用MultipartFile接口中的方法，把上传的文件写到指定位置
            File file = new File(bathPath + "/" + fileName);
            uploadFile.transferTo(file);
            userInfo2.setPicture("user/"+fileName);
        }
        userService.update(userInfo2);
        return "";
    }
    //修改用户信息2
    @RequestMapping("/updateUserInfo2")
    @ResponseBody
    public String updateUserInfo2(UserInfo userInfo,DefaultMultipartHttpServletRequest request) throws Exception {
        //得到用户信息
        UserInfo userInfo2 = (UserInfo) request.getSession().getAttribute("userInfo");
        //重新设置用户信息
        userInfo2.setUsername(userInfo.getUsername());
        userInfo2.setGender(userInfo.getGender());
        userInfo2.setDescription(userInfo.getDescription());
        userService.update(userInfo2);
        return "";
    }


    //删除文章
    @RequestMapping("/delArticle")
    @ResponseBody
    public String delArticle(String aId) throws Exception {
        articleService.delArticle(aId);
        return "";
    }

    //显示我的关注
    @RequestMapping("/attention")
    public ModelAndView attention() throws Exception {
        ModelAndView mv = new ModelAndView();
        //得到用户信息
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        String uId =userInfo.getId();
        //查找我的关注
        List<Attention> attentionList = attentionService.findMyAttention(uId);
        mv.addObject("attentionList",attentionList);
        mv.addObject("userInfo",userInfo);


        //查找用户关原创文章数目
        int userArticleNum = articleService.findCountByUid(uId);
        mv.addObject("userArticleNum",userArticleNum);
        //查找该用户点赞总数目
        int supportNum = supportService.findSupportNumByuId(uId);
        mv.addObject("supportNum",supportNum);
        //查找用户评论数目
        int userCommentNum = commentService.findUserCommentNum(uId);
        mv.addObject("userCommentNum",userCommentNum);


        mv.setViewName("attention");

        return mv;
    }

    @RequestMapping("/myArticle")
    public ModelAndView myArticle() throws Exception {
        ModelAndView mv = new ModelAndView();
        //得到用户信息
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        String uId = userInfo.getId();
        List<Article> articleList = articleService.findMyArticle(uId);
        mv.addObject("articleList",articleList);
        //查找用户关原创文章数目
        int userArticleNum = articleService.findCountByUid(uId);
        mv.addObject("userArticleNum",userArticleNum);
        //查找该用户点赞总数目
        int supportNum = supportService.findSupportNumByuId(uId);
        mv.addObject("supportNum",supportNum);
        //查找用户评论数目
        int userCommentNum = commentService.findUserCommentNum(uId);
        mv.addObject("userCommentNum",userCommentNum);
        mv.setViewName("myArticle");
        return mv;
    }


    //保存文章信息
    @PostMapping("/publish")
    public String publish(@RequestParam CommonsMultipartFile uploadFile, Article article, DefaultMultipartHttpServletRequest request) throws Exception {

        if(!uploadFile.isEmpty()) {
           //定义文件名
           String fileName = "";
           //获取原始文件名
           String uploadFileName = uploadFile.getOriginalFilename();
           //截取文件扩展名
           String extendName = uploadFileName.substring(uploadFileName.lastIndexOf("."), uploadFileName.length());
           //设置文件名
           fileName = UUIDUtils.getCode() + extendName;
           //获取文件路径
           String bathPath = request.getServletContext().getRealPath("/picture/article");
           //5.使用MultipartFile接口中的方法，把上传的文件写到指定位置
           File file = new File(bathPath + "/" + fileName);
           uploadFile.transferTo(file);
           //设置图片路径
           String articlePath = "article/" + fileName;
           article.setPicture(articlePath);
       }
           //得到用户信息
           UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
           article.setUser(userInfo);
           articleService.save(article);


            request.setAttribute("msg","添加成功！");
           return "forward:findAllCategory";
    }

    //查找用户信息
    @RequestMapping("/showInfo")
    public ModelAndView showInfo(String uId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //查找用户
        UserInfo userInfo = userService.findById(uId);
        mv.addObject("userInfo",userInfo);

        //查找用户关原创文章数目
        int userArticleNum = articleService.findCountByUid(uId);
        mv.addObject("userArticleNum",userArticleNum);
        //我的关注数
        int attentionNum = attentionService.findCount(uId);
        mv.addObject("attentionNum",attentionNum);
        mv.setViewName("my-space");
        return mv;
    }

    //查找分类
    @RequestMapping("/findAllCategory")
    public ModelAndView findAllCategory() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Category> categoryList = indexService.findAllCategory();
        mv.addObject("categoryList",categoryList);
        mv.setViewName("publish");
        return mv;
    }
    //检查密码
    @RequestMapping("/checkOldPassword")
    @ResponseBody
    public String checkOldPassword(String oldPassword){
        //得到用户信息

        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        if(userInfo!=null){
            if(!bCryptPasswordEncoder.matches(oldPassword,userInfo.getPassword())){
                return "false";
            }
        }
            return "true";
    }

    //修改密码
    @RequestMapping("/updatePassword")
    @ResponseBody
    public String updatePassword(String newPassword) throws Exception {
        //得到用户信息
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
            //密码加密
            userInfo.setPassword(bCryptPasswordEncoder.encode(newPassword));
            userService.update(userInfo);
            return "true";

    }
}
