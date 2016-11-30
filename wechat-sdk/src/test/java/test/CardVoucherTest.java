package test;

import com.joker.module.wechat.api.CardVoucherAPI;
import com.joker.module.wechat.api.result.BaseResult;
import com.joker.module.wechat.api.result.CardVoucherAPIResult;
import com.joker.module.wechat.domain.cardvoucher.*;
import com.joker.module.wechat.util.RetrofitUtil;
import okhttp3.RequestBody;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by zhangjian on 2016/11/18.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CardVoucherTest extends BaseTest{


    private static String cardId;



    @Test
    public void testACreateMemberCard(){
        MemberCard card = new MemberCard();


        //会员卡
        MemberCard.Member memberCard = card.new Member();

        //会员卡基础信息
        BaseInfo baseInfo = new BaseInfo();


        baseInfo.setLogoUrl(logo.getUrl());
        baseInfo.setBrandName("小易云");
        baseInfo.setCodeType(BaseInfo.CodeType.CODE_TYPE_TEXT);
        baseInfo.setTitle("小易云会员卡");
        baseInfo.setColor(BaseInfo.Color.Color020);
        baseInfo.setNotice("使用时向服务员出示");
        baseInfo.setServicePhone("8618328358153");
        baseInfo.setDescription("不可与其他优惠同享");

        BaseInfo.DateInfo dateInfo = baseInfo.new DateInfo();
        dateInfo.setType(BaseInfo.DateType.DATE_TYPE_PERMANENT);
        baseInfo.setDateInfo(dateInfo);

        BaseInfo.Sku sku = baseInfo.new Sku();
        sku.setQuantity(1000000);
        baseInfo.setSku(sku);

        baseInfo.setGetLimit(1);
        baseInfo.setCustomUrlName("立即使用");
        baseInfo.setCustomUrl("http://weixin.qq.com");
        baseInfo.setCustomUrlSubTitle("6汉子tips");
        baseInfo.setPromotionUrlName("营销入口1");
        baseInfo.setPromotionUrl("http://weixin..com");
        baseInfo.setNeedPushOnView(true);

        memberCard.setBaseInfo(baseInfo);
        //激活会员卡的链接


        memberCard.setSupplyBonus(true);
        memberCard.setSupplyBalance(false);
        memberCard.setPrerogative("test_prerogative");
        memberCard.setAutoActivate(false);
        memberCard.setWxActivate(true);

        MemberCard.CustomField customField = card.new CustomField();
        customField.setNameType(MemberCard.CustomFieldNameType.FIELD_NAME_TYPE_LEVEL);
        memberCard.setCustomField1(customField);

        memberCard.setActivateUrl("http://www.qq.com");

        MemberCard.CustomCell customCell = card.new CustomCell();
        customCell.setName("使用入口二");
        customCell.setTips("激活后显示");
        customCell.setUrl("http://weixin.qq.com");

        memberCard.setCustomCell1(customCell);


        MemberCard.BonusRule bonusRule = card.new BonusRule();
        bonusRule.setCostMoneyUnit(100);
        bonusRule.setIncreaseBonus(1);
        bonusRule.setMaxIncreaseBonus(200);
        bonusRule.setInitIncreaseBonus(10);
        bonusRule.setCostBonusUnit(5);
        bonusRule.setReduceMoney(100);
        bonusRule.setLeastMoneyToUseBonus(1000);
        bonusRule.setMaxReduceBonus(50);

        memberCard.setBonusRule(bonusRule);

        memberCard.setDiscount(10);

        card.setMemberCard(memberCard);

        CardVoucherAPI cardVoucherService = retrofit.create(CardVoucherAPI.class);


        CardNode cardNode = new CardNode<Card>(card);

        RequestBody body = RetrofitUtil.createJsonBody(cardNode);
        Call<CardVoucherAPIResult> cardVoucherAPIResultCall = cardVoucherService.createCardVoucher(this.token.getAccessToken(), body);

        try {
            Response<CardVoucherAPIResult> cardVoucherAPIResultResponse = cardVoucherAPIResultCall.execute();

            CardVoucherAPIResult result = cardVoucherAPIResultResponse.body();

            if (result.isSuccess()) {
                System.out.println("創建卡圈成功");
            }
            cardId = result.getCardId();
            System.out.println(result.getErrcode());
            System.out.println(result.getErrmsg());
            System.out.println(result.getCardId());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testBActiveMemberCard() throws Exception {
        MemberCardActiveInfo memberCardActiveInfo = new MemberCardActiveInfo();
        memberCardActiveInfo.setCardId(cardId);

        MemberCardActiveInfo.BindOldCard bindOldCard = memberCardActiveInfo.new BindOldCard();
        bindOldCard.setName("老会员绑定");
        bindOldCard.setName("https://www.qq.com");
        memberCardActiveInfo.setBindOldCard(bindOldCard);

        MemberCardActiveInfo.ServiceStatement serviceStatement = memberCardActiveInfo.new ServiceStatement();
        serviceStatement.setName("会员守则");
        serviceStatement.setUrl("https://www.qq.com");

        memberCardActiveInfo.setServiceStatement(serviceStatement);


        MemberCardActiveInfo.RequiredForm requiredForm = memberCardActiveInfo.new RequiredForm();
        requiredForm.setCanModify(false);

        MemberCardActiveInfo.RichField richField = memberCardActiveInfo.new RichField();
        richField.setName("兴趣");
        richField.setType(MemberCardActiveInfo.RichFieldType.FORM_FIELD_RADIO);
        String[] values = {"钢琴","舞蹈","足球"};
        richField.setValues(values);



        MemberCardActiveInfo.RichField richField2 = memberCardActiveInfo.new RichField();
        richField.setName("喜好");
        richField.setType(MemberCardActiveInfo.RichFieldType.FORM_FIELD_SELECT);
        String[] values2 = {"郭敬明","韩寒","南派三叔"};
        richField.setValues(values2);

        MemberCardActiveInfo.RichField richField3 = memberCardActiveInfo.new RichField();
        richField.setName("职业");
        richField.setType(MemberCardActiveInfo.RichFieldType.FORM_FIELD_SELECT);
        String[] values3 = {"赛车手","旅行家"};
        richField.setValues(values3);


        MemberCardActiveInfo.RichField[] richFields = {richField,richField2,richField3};
        requiredForm.setRichFieldList(richFields);

        MemberCardActiveInfo.CommonFieldId[] commonFieldIds = {MemberCardActiveInfo.CommonFieldId.USER_FORM_INFO_FLAG_MOBILE, MemberCardActiveInfo.CommonFieldId.USER_FORM_INFO_FLAG_NAME};
        requiredForm.setCommonFieldIdList(commonFieldIds);
        memberCardActiveInfo.setRequiredForm(requiredForm);


        MemberCardActiveInfo.CommonFieldId[] commonFieldIds2 = {MemberCardActiveInfo.CommonFieldId.USER_FORM_INFO_FLAG_LOCATION, MemberCardActiveInfo.CommonFieldId.USER_FORM_INFO_FLAG_BIRTHDAY};
        MemberCardActiveInfo.OptionalForm optionalForm = memberCardActiveInfo.new OptionalForm();
        optionalForm.setCanModify(false);
        optionalForm.setCommonFieldIdList(commonFieldIds2);

        String[] customFieldList = {"喜欢看电影"};
        optionalForm.setCustomFieldList(customFieldList);

        memberCardActiveInfo.setOptionalForm(optionalForm);


        CardVoucherAPI cardVoucherService = retrofit.create(CardVoucherAPI.class);


        RequestBody body = RetrofitUtil.createJsonBody(memberCardActiveInfo);
        Call<BaseResult> cardVoucherAPIResultCall = cardVoucherService.setActiveMemberCardForm(this.token.getAccessToken(), body);


            Response<BaseResult> baseResultResponse = cardVoucherAPIResultCall.execute();

            BaseResult result = baseResultResponse.body();

            if(!result.isSuccess()){
                throw new Exception("设置激活会员配置api调用失败");
            }


    }

    @Test
    public void testCUpdateMemberCard(){
        MemberCardUpdateInfo memberCardUpdateInfo = new MemberCardUpdateInfo();


    }

}
