package com.test.web.user;


import com.joker.modules.web.dao.UserDao;
import com.joker.modules.web.entity.User;
import com.joker.modules.web.enums.Sex;
import com.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author zhangjian
 * @Date 2015/10/11
 */
public class UserTest extends BaseSpringTest {
    @Autowired
    private UserDao userMapper;

    @Test
    public void testGetAllUser() {
        List<User> list = userMapper.findAllUser();
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            System.out.println(u.getName());
            if (u.getPicture() != null) {
                System.out.println(u.getPicture().getUrl());
            }
            System.out.println(u.getSex());
        }
    }

     @Test
    public void testAddUser() {
        User user = new User("jim", "jim@qq.com", "13644646", Sex.Man, "123456789");
        boolean result = userMapper.addUser(user);
        System.out.println(user);

    }

   @Test
    public void testFindUserByID() {

        User user = userMapper.findUserById(1);
        System.out.println(user.toString());
//        user.setName("vivian zhang");
//        userMapper.updateUser(user);
//
//        user = userMapper.findUserById(1);
//        System.out.println(user.toString());
    }
}
