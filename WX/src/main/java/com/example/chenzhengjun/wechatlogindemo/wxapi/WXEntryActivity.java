/**
 * Project Name:WechatLoginDemo
 * File Name:WXEntryActivity.java
 * Package Name:com.example.chenzhengjun.wechatlogindemo.wxapi
 * Date:11/5/2015
 * Copyright (c) 2015, iczjun@gmail.com All Rights Reserved.
 */
package com.example.chenzhengjun.wechatlogindemo.wxapi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.chenzhengjun.wechatlogindemo.DemoApplication;
import com.example.chenzhengjun.wechatlogindemo.R;
import com.example.chenzhengjun.wechatlogindemo.WXManager;
import com.example.chenzhengjun.wechatlogindemo.WxAccessToken;
import com.example.chenzhengjun.wechatlogindemo.WxAccessTokenResp;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/**
 * 此文件必须在项目包名.wxapi下
 *
 * @author chenzhengjun
 *
 */
public class WXEntryActivity extends Activity implements
		IWXAPIEventHandler, WxAccessTokenResp {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		WXManager.instance().handleIntent(getIntent(), this);
	}

	@Override
	public void onReq(BaseReq arg0) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tencent.mm.sdk.openapi.IWXAPIEventHandler#onResp(com.tencent.mm.sdk
	 * .modelbase.BaseResp)
	 */
	@Override
	public void onResp(BaseResp resp) {
		int result = 0;

		switch (resp.errCode) {
		case BaseResp.ErrCode.ERR_OK:
			result = R.string.errcode_success;
			if (resp instanceof SendAuth.Resp) {
				SendAuth.Resp aures = (SendAuth.Resp) resp;
				String code = aures.code;
				//微信授权返回结果，处理授权后操作,获取微信token
				WXManager.instance().getAccessToken(code, this);
				return;
			}
			break;
		case BaseResp.ErrCode.ERR_USER_CANCEL:
			result = R.string.errcode_cancel;
			break;
		case BaseResp.ErrCode.ERR_AUTH_DENIED:
			result = R.string.errcode_deny;
			break;
		default:
			result = R.string.errcode_unknown;
			break;
		}
		finish();
		Toast.makeText(WXEntryActivity.this, result, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onSuccess(WxAccessToken result) {
		//获取的微信token
		DemoApplication.getIns().setWxAccessToken(result);
		finish();
	}

	@Override
	public void onFailed(int statusCode) {
		Toast.makeText(WXEntryActivity.this, R.string.net_error_text, Toast.LENGTH_SHORT).show();
		finish();
	}


}
