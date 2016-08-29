package com.joker.module.shortlongurl.thread;

import com.joker.module.shortlongurl.domain.WechatToken;
import com.joker.module.shortlongurl.exception.WechatTokenException;
import com.joker.module.shortlongurl.factory.TokenFactory;

/**
 * Created by zhangjian on 2016/8/28.
 */
public class TokenVindicator {

    private WechatToken wechatToken;

    public TokenVindicator(WechatToken wechatToken) {
        this.wechatToken = wechatToken;
        tokenTimer();
    }


    public TokenVindicator() {
    }

    public WechatToken getWechatToken() {
        if (wechatToken != null && wechatToken.getExpiresIn() > 0) {
            return wechatToken;
        }

        newWechatToken();

        return wechatToken;
    }

    private void newWechatToken() {
        try {
            wechatToken = TokenFactory.getInstance().produceWechatToken();
        } catch (WechatTokenException e) {
            e.printStackTrace();
        }

        tokenTimer();
    }

    private void tokenTimer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (wechatToken.getExpiresIn() > 0) {
                    wechatToken.setExpiresIn(wechatToken.getExpiresIn() - 1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
