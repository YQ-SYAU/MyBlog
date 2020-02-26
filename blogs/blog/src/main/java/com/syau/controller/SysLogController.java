package com.syau.controller;

import com.github.pagehelper.PageInfo;
import com.syau.domain.SysLog;
import com.syau.domain.UserInfo;
import com.syau.service.SysLogService;
import com.syau.service.impl.SysLogServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private HttpServletRequest request;

    //跳到管理员页面
    @RequestMapping("/adminIndex")
    public ModelAndView adminIndex(){
        ModelAndView mv = new ModelAndView();
        //从session中获取用户
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        mv.addObject("userInfo",userInfo);
        mv.setViewName("admin-index");
        return mv;
    }

    @RequestMapping("/findAll")
    @RolesAllowed({"ADMIN"})
    public ModelAndView findAll(@RequestParam(name="pageNum",required = true,defaultValue = "1") Integer pageNum,@RequestParam(name="pageSize",required = true,defaultValue = "6") Integer pageSize) throws Exception {
        List<SysLog> logList = sysLogService.findAll(pageNum,pageSize);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(logList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("admin-logs");
        return mv;
    }
}
