/**
 * Project Name:WechatLoginDemo
 * File Name:DemoApplication.java
 * Package Name:com.example.chenzhengjun.wechatlogindemo
 * Date:11/5/2015
 * Copyright (c) 2015, iczjun@gmail.com All Rights Reserved.
 */
package com.example.chenzhengjun.wechatlogindemo;

import android.app.Application;

import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

/**
 * @author chenzhengjun
 *         Created on 11/5/2015
 */
public class DemoApplication extends Application {
    // 微信开放平台appid
    public static final String WX_APP_ID = "申请的app_id";
    public static final String WX_APP_SECRET = "申请的app_secret";
    private static DemoApplication ins;

    private WxAccessToken wxAccessToken;

    public static DemoApplication getIns() {
        return ins;
    }

    /**
     * set Application instance
     */
    private void setIns() {
        ins = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setIns();
        regToWx();
    }

    /**
     * 将应用的注册到微信
     */
    private void regToWx() {
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        IWXAPI wxApi = WXAPIFactory.createWXAPI(this, WX_APP_ID, true);
        // 将应用的注册到微信
        wxApi.registerApp(WX_APP_ID);
        WXManager.instance().setApi(wxApi);
    }

    /**
     * @return the wxAccessToken
     */
    public WxAccessToken getWxAccessToken() {
        return wxAccessToken;
    }

    /**
     * @param wxAccessToken the wxAccessToken to set
     */
    public void setWxAccessToken(WxAccessToken wxAccessToken) {
        this.wxAccessToken = wxAccessToken;
    }


}
