package designpattern.proxy.dynamic;

/**
 * Created by zhangjian on 2017/1/26.
 */
public class Client {
    public static void main(String[] args){
        LogHandler logHandler=new LogHandler();
        UserManager userManager=(UserManager)logHandler.newProxyInstance(new UserManagerImpl());
        //UserManager userManager=new UserManagerImpl();
        userManager.addUser("1111", "张三");
    }
}
