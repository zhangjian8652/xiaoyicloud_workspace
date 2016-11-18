package test;


import com.joker.module.wechat.api.CardVoucherAPI;
import com.joker.module.wechat.domain.Code;
import com.joker.module.wechat.domain.branchstore.BaseInfo;
import com.joker.module.wechat.domain.branchstore.Business;
import com.joker.module.wechat.domain.branchstore.Photo;
import com.joker.module.wechat.domain.branchstore.Store;
import com.joker.module.wechat.util.RetrofitUtil;
import okhttp3.RequestBody;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjian on 2016/10/28.
 */
public class StoreTest extends BaseTest {

    @Test
    public void testCreateStore() {
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setSid("317758652");
        baseInfo.setTelephone("028-84479315");
        baseInfo.setBusinessName("测试");
        baseInfo.setBranchName("成都一店");
        baseInfo.setProvince("四川省");
        baseInfo.setCity("成都");
        baseInfo.setDistrict("金牛");
        baseInfo.setAddress("人民北路金牛万达");

        String[] categries = {"电脑，技术"};
        baseInfo.setCategories(categries);
        baseInfo.setOffsetType(1);
        baseInfo.setLongitude(115.32375);
        baseInfo.setLatitude(25.097486);

        List<Photo> photos = new ArrayList<Photo>();

        Photo photo = new Photo();
        photo.setPhotoUrl(logo.getUrl());

        photos.add(photo);

        baseInfo.setPhotoList(photos);

        baseInfo.setRecommend("麦辣鸡腿堡套餐，麦乐鸡，全家桶");
        baseInfo.setSpecial("免费wifi，外卖服务");
        baseInfo.setIntroduction("麦当劳是全球大型跨国连锁餐厅，1940 年创立于美国，在世界上大约拥有3 万间分店。主要售卖汉堡包，以及薯条、炸鸡、汽水、冰品、沙拉、 水果等快餐食品");
        baseInfo.setOpenTime("8:00-20:00");
        baseInfo.setAvgPrice(35);


        Business business = new Business();
        business.setBaseInfo(baseInfo);

        Store store = new Store();
        store.setBusiness(business);

        CardVoucherAPI cardVoucherService = retrofit.create(CardVoucherAPI.class);


        RequestBody body = RetrofitUtil.createJsonBody(store);
        Call<Code> codeCall = cardVoucherService.addPOI(this.token.getAccessToken(), body);

        try {
            Response<Code> codeResponse = codeCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
