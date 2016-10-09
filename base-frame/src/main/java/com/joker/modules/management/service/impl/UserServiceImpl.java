package com.joker.modules.management.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.joker.modules.management.dao.ManagementUserDao;
import com.joker.modules.management.entity.User;
import com.joker.modules.management.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhangjian
 * @Date 2015/12/9
 */
@Service("managementUserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private ManagementUserDao managementUserDao;

    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Override
    public PageInfo<User> findUserByPage(int offset, int pagesize, String searchValue) {
        PageHelper.startPage(offset/pagesize,pagesize);
        List<User> userList= managementUserDao.selectByLike(searchValue);
        PageInfo<User> page = new PageInfo(userList);
        return page;
    }

    @Override
    public User findUserByUsername(String username) {
        return managementUserDao.selectByUsername(username);
    }

}
