package test;

import com.joker.module.wechat.api.CardVoucherAPI;
import com.joker.module.wechat.api.TokenAPI;
import com.joker.module.wechat.domain.Logo;
import com.joker.module.wechat.domain.Token;
import com.joker.module.wechat.factory.RetrofitFactory;
import com.joker.module.wechat.util.RetrofitUtil;
import okhttp3.MultipartBody;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by zhangjian on 2016/11/18.
 */
public class BaseTest {

    protected Retrofit retrofit;

    protected Token token;
    protected Logo logo;

    public BaseTest() {
            this.retrofit = RetrofitFactory.wechatAPIRetrofit();
    }

    @Before
    public void init() {
        testGetAccessToken();
        testUploadLogo();
    }

    public void testGetAccessToken() {
        TokenAPI service = retrofit.create(TokenAPI.class);

        Call<Token> tokenCall = service.getToken("client_credential", "wxe093b205a79538ed", "509100ac1642334fd29273f9e6b19e57");
        try {
            Response<Token> response = tokenCall.execute();
            this.token = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void testUploadLogo() {
        CardVoucherAPI cardVoucherService = retrofit.create(CardVoucherAPI.class);

        // use the FileUtils to get the actual file by uri

        URL url = BaseTest.class.getClassLoader().getResource("qrcode.jpg");
        File file = new File(url.getFile());
        MultipartBody.Part body = RetrofitUtil.createFilePart("buffer", file);
        Call<Logo> logoCall = cardVoucherService.uploadLogo(token.getAccessToken(), "image", body);

        try {
            Response<Logo> logoResponse = logoCall.execute();
            this.logo = logoResponse.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test1(){
        URL url = BaseTest.class.getClassLoader().getResource("qrcode.jpg");
        File file = new File(url.getFile());

        System.out.println(file.getAbsolutePath());
    }

}
