package designpattern.proxy.ndynamic;

/**
 * Created by zhangjian on 2017/2/3.
 */
public class AccountManagerImpl implements AccountManager {
    @Override
    public boolean addAccount(Account account) {

        System.out.println("AccountManagerImpl.addAccount");
        return false;
    }

    @Override
    public boolean delAccount(String id) {
        System.out.println("AccountManagerImpl.delAccount");
        return false;
    }

    @Override
    public Account updateAccount(Account account) {
        System.out.println("AccountManagerImpl.updateAccount");
        return null;
    }
}
