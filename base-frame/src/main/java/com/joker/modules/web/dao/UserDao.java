package com.joker.modules.web.dao;


import com.joker.modules.web.entity.User;

import java.util.List;

/**
 * @Author zhangjian
 * @Date 2015/9/5
 *
 */
public interface UserDao {
    /**
     *
     * @return
     */
    List<User> findAllUser();

    /**
     *
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     *
     * @param id
     * @return
     */
    User findUserById(int id);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);

    /**
     *
     * @param user
     * @return
     */
    boolean updateUser(User user);
}
