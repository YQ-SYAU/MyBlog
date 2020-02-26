package com.syau.service;


import com.syau.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


    List<UserInfo> findAll(int page,int size)throws Exception;

    void save(UserInfo userInfo,String qq)throws Exception;

    void updateStatus(String id,Integer status)throws Exception;

    boolean checkUsername(String username)throws Exception;

    UserInfo findById(String id)throws Exception;

    void update(UserInfo userInfo)throws Exception;

    Boolean checkUpdateUsername(String username, String uId)throws Exception;
}
