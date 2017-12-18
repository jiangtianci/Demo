/**
 * Project Name:WechatLoginDemo
 * File Name:WxAccessTokenResp.java
 * Package Name:com.example.chenzhengjun.wechatlogindemo
 * Date:11/5/2015
 * Copyright (c) 2015, iczjun@gmail.com All Rights Reserved.
 */
package com.example.chenzhengjun.wechatlogindemo;

/**
 *
 * @author chenzhengjun
 *
 */
public interface WxAccessTokenResp {
	void onSuccess(WxAccessToken result);

	void onFailed(int statusCode);
}
