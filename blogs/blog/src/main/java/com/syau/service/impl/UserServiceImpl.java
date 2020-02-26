package com.syau.service.impl;

import com.github.pagehelper.PageHelper;
import com.syau.dao.UserDao;
import com.syau.domain.Role;
import com.syau.domain.UserInfo;
import com.syau.service.UserService;
import com.syau.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;
    //SpringSecurity用于加密的bean
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private HttpServletRequest request;


    //查找所有用户
    @Override
    public List<UserInfo> findAll(int page,int size) throws Exception {
        //参数pageNum是页码值（从那页开始）,pageSize每页显示几条
        PageHelper.startPage(page,size);
        return userDao.findAll();
    }

    //用户注册，保存用户
    @Override
    public void save(UserInfo userInfo,String qq) throws Exception {
        //设置id
        userInfo.setId(UUIDUtils.getId());
        //设置默认头像
        userInfo.setPicture("user/-200.jpeg");
        //设置默认粉丝数
        userInfo.setFans(0);
        //设置状态
        userInfo.setStatus(1);
        //设置性别
        userInfo.setGender("男");
        //设置qq
        userInfo.setQq(qq);
        //对密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
        //设置角色
        userDao.setUserRole(userInfo.getId());

    }

    //修改用户状态
    @Override
    public void updateStatus(String id,Integer status) throws Exception {
        if(status==0){
            status=1;
        }else{
            status=0;
        }
        userDao.updateStatus(id,status);
    }

    //检查用户名是否存在
    @Override
    public boolean checkUsername(String username) throws Exception {
        UserInfo userInfo = userDao.findByUsername(username);
        if(userInfo==null){
            return true;
        }
        return false;
    }

    //通过id查找用户
    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @throws Exception
     */
    @Override
    public void update(UserInfo userInfo) throws Exception {
        userDao.update(userInfo);
    }

    //检查用户名是否重复（更换用户名）
    @Override
    public Boolean checkUpdateUsername(String username, String uId) throws Exception {
        List<UserInfo> userInfoList = userDao.checkUpdateUsername(username,uId);
        if(userInfoList==null || userInfoList.size()==0){
            return true;
        }
        return false;
    }

    //认证用户登录
    @Override
    public UserDetails loadUserByUsername(String username){
        UserInfo userInfo = null;
        User user=null;
        try {
            userInfo = userDao.findByUsername(username);

            //保存到session中
            request.getSession().setAttribute("userInfo",userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户封装成UserDetails
        user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    //作用返回一个Set集合，集合装入角色描述 TreeSet可以做排序，HashSet不允许元素重复
    private Set<SimpleGrantedAuthority> getAuthority(Set<Role> roles) {
        Set<SimpleGrantedAuthority> set = new HashSet<>();
        for (Role role : roles) {
            set.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return set;
    }


}
