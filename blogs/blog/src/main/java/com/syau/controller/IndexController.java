package com.syau.controller;


import com.github.pagehelper.PageInfo;
import com.syau.dao.Constant;
import com.syau.domain.*;
import com.syau.service.*;
import com.syau.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

//分类和轮播图
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CommentService commentService;
    @Autowired
    private SupportService supportService;
    @Autowired
    private AttentionService attentionService;
    @Autowired
    private UserService userService;


    //查看他人发布的文章信息
    @RequestMapping("/otherPublish")
    public ModelAndView otherPublish(String uId) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(uId);
        mv.addObject("userInfo",userInfo);
        List<Article> articleList = articleService.findByUid(uId);
        mv.addObject("articleList",articleList);
        //把用户信息传到页面
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


        //得到用户信息
        UserInfo oUser = (UserInfo) request.getSession().getAttribute("userInfo");
        int aflag=0;
        if(oUser!=null){
            //判断用户是否关注
            Attention attention = attentionService.findById(uId,oUser.getId());
            if(attention==null){
                //未关注
                aflag = 0;
            }else{
                //关注
                aflag =1;
            }
        }
        mv.addObject("aflag",aflag);
        mv.addObject("oUser",oUser);
        mv.setViewName("articleList");
        return mv;
    }

    //通过id查找文章
    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        //查找分类
        List<Category> categoryList = indexService.findAllCategory();
        mv.addObject("categoryList",categoryList);
        //查找文章
        Article article = articleService.findById(id);

        //修改文章信息（此处浏览量+1）
        article.setBrowse(article.getBrowse()+1);
        articleService.update(article);

        mv.addObject("article",article);

        //通过用户ID查找发布文章总数
        int count = articleService.findCountByUId(article.getUser().getId());
        mv.addObject("count",count);

        //通过文章id查找评论内容
        List<Comments>  commentsList = commentService.findCommentsById(id);
        mv.addObject("commentsList",commentsList);
        //通过文章id查找评论总数
        int commentCount = commentService.findCountById(id);
        mv.addObject("commentCount",commentCount);

        //得到用户信息
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        mv.addObject("userInfo",userInfo);

        int flag = 0;
        int aflag=0;
        if(userInfo!=null){
            //判断用户是否点赞过
            Support support = supportService.findById(article.getId(),userInfo.getId());
            if(support==null){
                //未点赞
                flag = 0;
            }else{
                //点赞
                flag =1;
            }
            //判断用户是否关注
            Attention attention = attentionService.findById(article.getUser().getId(),userInfo.getId());
            if(attention==null){
                //未关注
                aflag = 0;
            }else{
                //关注
                aflag =1;
            }
        }
        mv.addObject("flag",flag);
        mv.addObject("aflag",aflag);
        mv.setViewName("article-info");
        return mv;
    }

    //通过分类id查询文章数据
    @RequestMapping("/findByCid")
    public ModelAndView findByCid(@RequestParam(name="pageNum",required = true,defaultValue = "1")Integer pageNUm,@RequestParam(name="cid") String cid) throws Exception {
        ModelAndView mv = new ModelAndView();
        //获取分类数据
        List<Category> categoryList = indexService.findAllCategory();
        mv.addObject("categoryList",categoryList);
        //获取分类下的文章数据
        List<Article> articleCList = articleService.findByCid(cid,pageNUm, Constant.ARTICLE_PAGE_SIZE);
        PageInfo pageInfo = new PageInfo(articleCList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("category-article");
        return mv;
    }

    //查询首页需要的数据
    @RequestMapping("/showIndex")//@RequestParam(name="num",required = true,defaultValue = "")int num
    public ModelAndView showIndex() throws Exception {
        ModelAndView mv = new ModelAndView();
        //获取分类数据
        List<Category> categoryList = indexService.findAllCategory();
        mv.addObject("categoryList",categoryList);
        //获取轮播图
        Slideshow slideshow = indexService.findAllSlideshow();
        mv.addObject("slideshow",slideshow);
        //获取排行榜数据点赞最多
        List<Article> supportList = articleService.findSupport();
        mv.addObject("supportList",supportList);
        //获取排行榜数浏览最多
        List<Article> browseList = articleService.findBrowse();
        mv.addObject("browseList",browseList);
        //获取最新发布的数据
        List<Article> newList = articleService.findNew();
        mv.addObject("newList",newList);

        //得到用户信息
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        mv.addObject("userInfo",userInfo);

        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/show")
    @RolesAllowed({"ADMIN"})
    //展示分类和轮播图
    public ModelAndView show() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Category> category = indexService.findAllCategory();
        Slideshow slideshow = indexService.findAllSlideshow();
        mv.addObject("category",category);
        mv.addObject("slideshow",slideshow);
        mv.setViewName("admin-category");
        return mv;
    }
    //添加分类
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/save")
    public String save(String cname) throws Exception {
        indexService.save(cname);
        return "redirect:show";
    }
    //修改分类名
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/update")
    public String update(String id, String cname)throws Exception{
        System.out.println(cname+" cname");
        indexService.updateCname(id,cname);
        return "redirect:show";
    }
    //删除分类
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/delete")
    public String delete(String id)throws Exception{
        indexService.delete(id);
        return "redirect:show";
    }

    //修改轮播图
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/slideshow")
    public String slideshow(@RequestParam CommonsMultipartFile uploadFile, String flag, DefaultMultipartHttpServletRequest request) throws Exception {
        //定义文件名
        String fileName = "";
        //1.获取原始文件名
        String uploadFileName = uploadFile.getOriginalFilename();
        //2.截取文件扩展名
        String extendName = uploadFileName.substring(uploadFileName.lastIndexOf("."),uploadFileName.length());
        //3.设置文件名
        fileName = UUIDUtils.getCode()+extendName;
        //4.获取文件路径      ServletContext代表整个应用（1：当前应用，多个servlet共享数据2：获取全局配置信息3：获取资源路径）
        String bathPath = request.getServletContext().getRealPath("/picture/slideshow");
        //5.使用MultipartFile接口中的方法，把上传的文件写到指定位置
        File file = new File(bathPath+"/"+fileName);
        uploadFile.transferTo(file);
        System.out.println(bathPath+"/"+fileName);
        //6.更换数据库文件路径
        String fielShowPath = "slideshow/"+fileName;
        indexService.updateSlideshow(fielShowPath,flag);
        return "redirect:show";
    }
}
