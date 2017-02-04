package designpattern.proxy.ndynamic;

/**
 * Created by zhangjian on 2017/2/3.
 */
public class ClientTest {
    public static void main(String[] args) {
        AccountManager accountManager = (AccountManager) new OperationHandler().newProxyIntance(new AccountManagerImpl());
        accountManager.delAccount("aaa");

    }
}
