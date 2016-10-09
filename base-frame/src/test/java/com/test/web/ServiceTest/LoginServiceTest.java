package com.test.web.ServiceTest;


import com.joker.modules.web.entity.User;
import com.joker.modules.web.enums.Sex;
import com.joker.modules.web.service.LoginService;
import com.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author zhangjian
 * @Date 2015/10/20
 */
public class LoginServiceTest extends BaseSpringTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void testAuth() {
        User user = new User("jim", "jim@qq.com", "11111", Sex.Man, "123456");
        user.setId(1);
        System.out.println(loginService.authUser(user));

    }
}
