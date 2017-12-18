/**
 * Project Name:WechatLoginDemo
 * File Name:WxAccessTokenReq.java
 * Package Name:com.example.chenzhengjun.wechatlogindemo
 * Date:11/5/2015
 * Copyright (c) 2015, iczjun@gmail.com All Rights Reserved.
 */
package com.example.chenzhengjun.wechatlogindemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

/**
 *
 * @author chenzhengjun
 *
 */
public class WxAccessTokenReq extends TextHttpResponseHandler {

	private WxAccessTokenResp resp;

	/**
	*
	*/
	public WxAccessTokenReq(WxAccessTokenResp resp) {
		this.resp = resp;
	}

	@Override
	public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

	}

	@Override
	public void onSuccess(int statusCode, Header[] headers, String responseString) {
		try {

			JSONObject json = JSON.parseObject(responseString);
			if (json == null) {
				if (resp != null)
					resp.onFailed(statusCode);
			} else {
				WxAccessToken result = null;
				try {
					result = JSON.toJavaObject(json, WxAccessToken.class);
					if (resp != null)
						resp.onSuccess(result);
				} catch (JSONException e) {
					e.printStackTrace();
					if (resp != null)
						resp.onFailed(statusCode);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			if (resp != null)
				resp.onFailed(statusCode);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.loopj.android.http.AsyncHttpResponseHandler#onFinish()
	 */
	@Override
	public void onFinish() {
		// TODO Auto-generated method stub
		super.onFinish();
	}
}
