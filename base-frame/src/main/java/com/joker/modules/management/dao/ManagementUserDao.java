package com.joker.modules.management.dao;

import com.joker.modules.management.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author zhangjian
 * @Date 2015/9/5
 *
 */
public interface ManagementUserDao {
    /**
     *
     * @return
     */
    List<User> selectAll();

    /**
     *
     * @param user
     * @return
     */
    boolean add(User user);

    /**
     *
     * @param id
     * @return
     */
    User selectById(int id);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     *
     * @param user
     * @return
     */
    boolean update(User user);



    /**
     * 获取分页用户数据带搜索条件
     * @param key 搜索条件
     * @return 当前页所有用户
     */

    List<User> selectByLike(@Param("key") String key);


}
