package com.joker.modules.web.dao;



import com.joker.modules.web.entity.Picture;

/**
 * @Author zhangjian
 * @Date 2015/10/12
 *
 */
public interface PictureDao {

    /**
     *
     *添加用户头像
     * @param picture
     * @return
     */
    boolean addPicture(Picture picture);

    /**
     * 根据用户id查找头像照片
     * @param i 用户id
     * @return
     */
    Picture findPictureByUserId(int i);

    /**
     * 更新用户头像
     * @param picture
     * @return
     */
    boolean updatePicture(Picture picture);

    /**
     * 删除用户头像
     * @param id
     * @return
     */
    boolean deletePictureById(int id);
}
