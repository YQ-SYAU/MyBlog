package com.syau.controller;

import com.github.pagehelper.PageInfo;
import com.syau.domain.UserInfo;
import com.syau.service.UserService;
import com.syau.utils.RanDomUtil;
import com.syau.utils.SendMailUtil1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//用户模块
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    //检查用户名是否存在
    @RequestMapping("/checkUsername")
    @ResponseBody
    public String checkUsername(String username) throws Exception {
        boolean flag = userService.checkUsername(username);
        return flag+"";
    }


    //修改用户状态
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/updateStatus")
    public String updateStatus(String id,Integer status) throws Exception {
        userService.updateStatus(id,status);
        return "redirect:showAll";
    }

    //查找所有用户
    @RolesAllowed({"ADMIN"})
    @RequestMapping("/showAll")
    public ModelAndView showAll(@RequestParam(name="pageNum",required = true,defaultValue = "1")Integer page,@RequestParam(name="pageSize",required = true,defaultValue = "4")Integer size)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll(page,size);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(users);

        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("admin-user");
        return mv;
    }

    //用户注册

    @RequestMapping("/register")
    public String register(UserInfo userInfo,HttpServletRequest request,Model model) throws Exception {
        String random1 = request.getParameter("random");
        HttpSession session = request.getSession();
        String random2 = (String) session.getAttribute("random");
        if(random2!=null){
            if(random2.equals(random1)){//注册验证码正确
                String qq = (String) session.getAttribute("qq");
                userService.save(userInfo,qq);
                model.addAttribute("msg","注册成功");
                model.addAttribute("userInfo",userInfo);
                return "forward:/pages/register.jsp";
            }
        }
        model.addAttribute("msg","注册失败");
        return "forward:/pages/register.jsp";
    }
    //用户获取注册的验证码    produces = "text/html;charset=utf-8"解决响应编码问题
    @RequestMapping(value="/getRegistrationCode",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getRandom(String qq,HttpServletRequest request,HttpServletRequest res){
        //获取随机数
        String random =RanDomUtil.getRandom6();
        //保存随机数和用户绑定的qq号到session中
        HttpSession session = request.getSession();
        session.setAttribute("random",random);
        session.setAttribute("qq",qq);
        //设置session存在时间为60秒
        session.setMaxInactiveInterval(60);
        //发送邮箱
        try {
            SendMailUtil1.Send(random,qq);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "获取注册码失败";
        }
        return "发送成功，请在60秒内完成操作";
    }
}
