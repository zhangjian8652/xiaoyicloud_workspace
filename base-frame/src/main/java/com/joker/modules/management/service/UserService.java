package com.joker.modules.management.service;


import com.github.pagehelper.PageInfo;
import com.joker.modules.management.entity.User;

/**
 * @Author zhangjian
 * @Date 2015/12/9
 */
public interface UserService {
    /**
     * 获取分页用户
     * @param start 起始下标
     * @param length 长度
     * @return
     */
    PageInfo<User> findUserByPage(int start, int length, String searchValue);

    User findUserByUsername(String username);
}
