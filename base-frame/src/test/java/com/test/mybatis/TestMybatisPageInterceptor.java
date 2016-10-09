package com.test.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.joker.modules.management.dao.ManagementUserDao;
import com.joker.modules.management.entity.User;
import com.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * author:zhangjian
 * date:2016-04-21
 * describe:
 **/
public class TestMybatisPageInterceptor extends BaseSpringTest{

    @Autowired
    private ManagementUserDao managementUserDao;

    @Test
    public void testFindAll(){
        PageHelper.startPage(1,10);
        List<User> users = managementUserDao.selectAll();
        PageInfo<User> page = new PageInfo(users);
        System.out.println(users.size());
        System.out.println("");
    }
}
