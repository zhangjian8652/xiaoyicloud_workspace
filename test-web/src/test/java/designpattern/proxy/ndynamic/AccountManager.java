package designpattern.proxy.ndynamic;

/**
 * Created by zhangjian on 2017/2/3.
 */
public interface AccountManager {


    boolean addAccount(Account account);

    boolean delAccount(String id);

    Account updateAccount(Account account);

}
