/**
 * Project Name:WechatLoginDemo
 * File Name:WXManager.java
 * Package Name:com.example.chenzhengjun.wechatlogindemo
 * Date:11/5/2015
 * Copyright (c) 2015, iczjun@gmail.com All Rights Reserved.
 */
package com.example.chenzhengjun.wechatlogindemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXVideoObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

import java.io.File;

/**
 *
 * @author chenzhengjun
 *
 */
public class WXManager {
	private static final String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?";
	private static final String URL_REFRESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token?";
	private static final int THUMB_SIZE = 150;
	private static WXManager mWXManager = new WXManager();

	private IWXAPI api;

	public static WXManager instance() {
		return mWXManager;
	}

	/**
	 * @param api
	 *            the api to set
	 */
	public void setApi(IWXAPI api) {
		this.api = api;
	}

	private String buildTransaction(final String type) {
		return (type == null) ? String.valueOf(System.currentTimeMillis())
				: type + System.currentTimeMillis();
	}

	public boolean handleIntent(Intent arg0, IWXAPIEventHandler arg1) {
		if (api == null)
			return false;
		return api.handleIntent(arg0, arg1);
	}

	public boolean isWXAppInstalled() {
		if (api == null)
			return false;
		return api.isWXAppInstalled();
	}

	public boolean isWXAppSupportAPI() {
		if (api == null)
			return false;
		return api.isWXAppSupportAPI();
	}

	public boolean sendReq(BaseReq arg0) {
		if (api == null)
			return false;
		return api.sendReq(arg0);
	}

	/**
	 * 分享文本到微信
	 * 
	 * @param isTimelineCb
	 *            是否分享到朋友圈
	 * @param text
	 *            分享到微信的文本内容
	 * @return true 成功，false失败
	 */
	public boolean sendTextToWX(boolean isTimelineCb, String text) {
		if (api == null)
			return false;
		if (TextUtils.isEmpty(text)) {
			return false;
		}

		// 初始化一个WXTextObject对象
		WXTextObject textObj = new WXTextObject();
		textObj.text = text;

		// 用WXTextObject对象初始化一个WXMediaMessage对象
		WXMediaMessage msg = new WXMediaMessage();
		msg.mediaObject = textObj;
		msg.description = text;

		// 构造一个Req
		SendMessageToWX.Req req = new SendMessageToWX.Req();
		req.transaction = buildTransaction("text"); // transaction字段用于唯一标识一个请求
		req.message = msg;
		req.scene = isTimelineCb ? SendMessageToWX.Req.WXSceneTimeline
				: SendMessageToWX.Req.WXSceneSession;

		// 调用api接口发送数据到微信
		return api.sendReq(req);
	}

	/**
	 * 分享图片
	 */
	public boolean sendImageToWX(boolean isTimelineCb, String imagePath,
			String imageUrl) {
		if (api == null)
			return false;
		// 本地图片
		if (imagePath != null) {
			File file = new File(imagePath);
			if (!file.exists()) {
				return false;
			}

			WXImageObject imgObj = new WXImageObject();
			imgObj.setImagePath(imagePath);

			WXMediaMessage msg = new WXMediaMessage();
			msg.mediaObject = imgObj;
			Bitmap bmp = BitmapFactory.decodeFile(imagePath);
			Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE,
					THUMB_SIZE, true);
			bmp.recycle();
			msg.thumbData = Util.bmpToByteArray(thumbBmp, true);

			SendMessageToWX.Req req = new SendMessageToWX.Req();
			req.transaction = buildTransaction("img");
			req.message = msg;
			req.scene = isTimelineCb ? SendMessageToWX.Req.WXSceneTimeline
					: SendMessageToWX.Req.WXSceneSession;
			return api.sendReq(req);
		}
		return false;
	}

	/**
	 * 分享视频到微信
	 * 
	 * @param isTimelineCb
	 *            是否分享到朋友圈
	 * @return true 成功，false失败
	 */
	public boolean sendVideoToWX(boolean isTimelineCb, String videoLowBandUrl,
			String videoUrl, String imagePath, String title,
			String description) {
		if (api == null)
			return false;
		WXVideoObject video = new WXVideoObject();
		if (videoUrl != null) {
			video.videoUrl = videoUrl;
		}
		// 低带宽
		else {
			video.videoLowBandUrl = videoLowBandUrl;
		}
		WXMediaMessage msg = new WXMediaMessage(video);
		msg.title = title;
		msg.description = description;
		Bitmap thumb = BitmapFactory.decodeFile(imagePath);
		msg.thumbData = Util.bmpToByteArray(thumb, true);

		SendMessageToWX.Req req = new SendMessageToWX.Req();
		req.transaction = buildTransaction("video");
		req.message = msg;
		req.scene = isTimelineCb ? SendMessageToWX.Req.WXSceneTimeline
				: SendMessageToWX.Req.WXSceneSession;
		return api.sendReq(req);
	}

	/**
	 * 分享网页到微信
	 * 
	 * @param isTimelineCb
	 *            是否分享到朋友圈
	 * @param webpageUrl
	 * 网页url
	 * @param imagePath
	 *            网页封面图片路径
	 * @param title
	 *            分享网页的标题
	 * @param description
	 *            分享描述文字
	 * @return true 成功，false失败
	 */
	public boolean sendWebPageToWX(boolean isTimelineCb, String webpageUrl,
			String imagePath, String title, String description) {
		if (api == null)
			return false;
		WXWebpageObject webpage = new WXWebpageObject();
		webpage.webpageUrl = webpageUrl;
		WXMediaMessage msg = new WXMediaMessage(webpage);
		msg.title = title;
		msg.description = description;
		Bitmap thumb = BitmapFactory.decodeFile(imagePath);
		msg.thumbData = Util.bmpToByteArray(thumb, true);

		SendMessageToWX.Req req = new SendMessageToWX.Req();
		req.transaction = buildTransaction("webpage");
		req.message = msg;
		req.scene = isTimelineCb ? SendMessageToWX.Req.WXSceneTimeline
				: SendMessageToWX.Req.WXSceneSession;
		return api.sendReq(req);
	}

	public boolean sendWebPageToWX(boolean isTimelineCb, String webpageUrl,
			Bitmap image, String title, String description) {
		if (api == null)
			return false;
		WXWebpageObject webpage = new WXWebpageObject();
		webpage.webpageUrl = webpageUrl;
		WXMediaMessage msg = new WXMediaMessage(webpage);
		msg.title = title;
		msg.description = description;
		// Bitmap thumb = BitmapFactory.decodeFile(imagePath);
		msg.thumbData = Util.bmpToByteArray(image, false);

		SendMessageToWX.Req req = new SendMessageToWX.Req();
		req.transaction = buildTransaction("webpage");
		req.message = msg;
		req.scene = isTimelineCb ? SendMessageToWX.Req.WXSceneTimeline
				: SendMessageToWX.Req.WXSceneSession;
		return api.sendReq(req);
	}

	public boolean sendAppMsgToWX(boolean isTimelineCb, String webpageUrl,
			String imageUrl) {
		if (api == null)
			return false;
		final WXAppExtendObject appdata = new WXAppExtendObject();
		final String path = "sdcard/test.jpg";
		appdata.fileData = Util.readFromFile(path, 0, -1);
		appdata.extInfo = "this is ext info";

		final WXMediaMessage msg = new WXMediaMessage();
		msg.setThumbImage(Util.extractThumbNail(path, 150, 150, true));
		msg.title = "this is title";
		msg.description = "this is description";
		msg.mediaObject = appdata;

		SendMessageToWX.Req req = new SendMessageToWX.Req();
		req.transaction = buildTransaction("appdata");
		req.message = msg;
		req.scene = isTimelineCb ? SendMessageToWX.Req.WXSceneTimeline
				: SendMessageToWX.Req.WXSceneSession;
		return api.sendReq(req);
	}

	public void getAccessToken(String code, WxAccessTokenResp resp) {
		WxAccessTokenReq req = new WxAccessTokenReq(resp);
		StringBuilder sb = new StringBuilder();
		sb.append(URL_ACCESS_TOKEN).append("appid=")
				.append(DemoApplication.WX_APP_ID).append("&secret=")
				.append(DemoApplication.WX_APP_SECRET).append("&code=")
				.append(code).append("&grant_type=authorization_code");
		NetClient.instance().getWxAccessToken(sb.toString(), req);
	}

	public void refreshAccessToken(WxAccessTokenResp resp) {
		WxAccessTokenReq req = new WxAccessTokenReq(resp);
		StringBuilder sb = new StringBuilder();
		sb.append(URL_REFRESH_TOKEN).append("appid=")
				.append(DemoApplication.WX_APP_ID)
				.append("&grant_type=refresh_token&refresh_token=REFRESH_TOKEN");
		NetClient.instance().getWxAccessToken(sb.toString(), req);
	}

	public void getWxUserInfo(WxAccessTokenResp resp) {
		WxAccessTokenReq req = new WxAccessTokenReq(resp);
		StringBuilder sb = new StringBuilder();
		sb.append("https://api.weixin.qq.com/sns/userinfo?access_token=")
				.append(DemoApplication.getIns().getWxAccessToken().access_token)
				.append("&openid=")
				.append(DemoApplication.getIns().getWxAccessToken().getOpenId());
		NetClient.instance().getWxAccessToken(sb.toString(), req);
	}
}
