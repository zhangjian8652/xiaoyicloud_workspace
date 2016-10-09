package com.joker.modules.web.service.serviceImpl;


import com.joker.modules.web.dao.UserDao;
import com.joker.modules.web.entity.User;
import com.joker.modules.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhangjian
 * @Date 2015/10/20
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean authUser(User user) {
        if (user == null) {
            return false;
        }

        User dbUser = userDao.findUserById(user.getId());
        if(dbUser == null){
            return false;
        }

        if(!dbUser.getPassword().equals(user.getPassword())){
            return false;
        }

        return true;
    }

}
