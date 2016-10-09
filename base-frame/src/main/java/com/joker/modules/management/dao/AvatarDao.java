package com.joker.modules.management.dao;


import com.joker.modules.management.entity.Avatar;

import java.util.List;

/**
 * @Author zhangjian
 * @Date 2015/11/21
 */
public interface AvatarDao {
    List<Avatar> findAllAvatar();
    Avatar findAvatarById(int id);
    boolean addAvatar(Avatar avator);
    boolean updateAvatarById(Avatar avator);
}
