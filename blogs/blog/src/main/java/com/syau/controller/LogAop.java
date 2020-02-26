package com.syau.controller;

import com.syau.domain.SysLog;
import com.syau.service.SysLogService;
import com.syau.utils.UUIDUtils;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    private Date visitTime;//开始访问的时间
    private Class clazz;//访问的类
    private Method method;//访问的方法

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogService sysLogService;

    //配置切入点表达式
    @Pointcut("execution(* com.syau.controller.*.*(..))")
    private void pt1(){ }

    //前置通知  主要获取开始时间，执行的类是哪一个，执行的哪一个方法
    @Before("pt1()")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();//当前时间就是开始访问时间
        clazz = jp.getTarget().getClass();//具体要访问的类
        String methodName=jp.getSignature().getName();//获取访问方法的名称
        Object[] args = jp.getArgs();//获取访问的方法的参数

        //获取具体执行的方法的Method
        if(args==null || args.length==0){
            method = clazz.getMethod(methodName);//获取无参数的方法
        }else{
            //获取有参数的方法

            Class[] classArgs =  new Class[args.length];
            for(int i=0;i<args.length;i++){
                if(args[i]==null){//二进制
                    return;
                }else {
                    classArgs[i] = args[i].getClass();
                }
            }
            method = clazz.getMethod(methodName,classArgs);

        }
    }

    //后置通知
    @After("pt1()")
    public void doAfter() throws Exception {
        //获取当前操作的用户
        String username="";
        SecurityContext context = SecurityContextHolder.getContext();//   第二种：request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        Authentication authentication = context.getAuthentication();

        if(authentication!=null){
            Object object =  authentication.getPrincipal();
            //anonymousUser

            if(object instanceof User) {
                User user = (User) object;
                username   = user.getUsername();
            }else{
                username = "匿名用户";
            }
        }



        //获取url
        String url="";
        if(clazz!=null&&method!=null&&clazz!=SysLog.class&&clazz!=SysLogController.class&&clazz!=UserController.class){

            //1.获取类上的@RequestMapping("/...")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null){
                String[] classValue = classAnnotation.value();

                //2.获取方法上的@RequestMapping("/...")
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null){
                    String[] methodValue = methodAnnotation.value();
                    url= classValue[0]+methodValue[0];

                    //获取访问的ip
                    String ip = request.getRemoteAddr();

                    //获取执行时间
                    long executionTime = new Date().getTime()-visitTime.getTime();
                    //将访问时间格式化
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    //将日志信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setId(UUIDUtils.getId());
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名] "+clazz.getName()+"[方法名] "+method.getName());
                    sysLog.setUsername(username);
                    sysLog.setUrl(url);
                    sysLog.setVisitTime(format.format(visitTime));

                    //保存
                    sysLogService.save(sysLog);
                }
            }
        }

    }
}
