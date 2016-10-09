package com.joker.modules.web.service;


import com.joker.modules.web.entity.User;

/**
 * @Author zhangjian
 * @Date 2015/10/20
 */
public interface LoginService {
    public boolean authUser(User user);
}
