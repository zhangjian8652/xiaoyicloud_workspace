package com.test.web.picture;

import com.joker.modules.web.dao.PictureDao;
import com.joker.modules.web.entity.Picture;
import com.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author zhangjian
 * @Date 2015/10/13
 */
public class PictureTest extends BaseSpringTest{

    @Autowired
    private PictureDao pictureDao;
    @Test
    public void testGetPicture(){
            Picture picture = pictureDao.findPictureByUserId(1);
            System.out.println(picture);
    }


    @Test
    public void addPicture(){
        Picture picture = new Picture(3,"/xxx/sss/jpg","ggPicture");
        boolean result =   pictureDao.addPicture(picture);
        System.out.println(picture);
    }

    @Test
    public void deletePicture(){
        Boolean result =   pictureDao.deletePictureById(2);
        System.out.println(result);
    }
}
