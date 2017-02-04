package designpattern.proxy.dynamic;

/**
 * Created by zhangjian on 2017/1/26.
 */
public interface UserManager {


     void addUser(String userId, String userName) ;


     void delUser(String userId) ;


     String findUser(String userId);

     void modifyUser(String userId, String userName);
}
