/**
 * Project Name:WechatLoginDemo
 * File Name:NetClient.java
 * Package Name:com.example.chenzhengjun.wechatlogindemo
 * Date:11/5/2015
 * Copyright (c) 2015, iczjun@gmail.com All Rights Reserved.
 */
package com.example.chenzhengjun.wechatlogindemo;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * 网络请求类
 * 
 * @author chenzhengjun
 * 
 */
public class NetClient {
	private static NetClient netClient = new NetClient();
	private AsyncHttpClient httpClient = new AsyncHttpClient();

	public static NetClient instance() {
		return netClient;
	}

	private NetClient() {
		httpClient.setURLEncodingEnabled(false);
		httpClient.setTimeout(60000);
	}

	private void post(String url, String paramStr,
			ResponseHandlerInterface responseHandler) {
		if (paramStr == null) {
			if (responseHandler != null)
				responseHandler.sendFailureMessage(0, null, null, null);
		}
		RequestParams params = new RequestParams("request",paramStr);
		httpClient.post(url, params, responseHandler);
	}

	public boolean isInputStreamGZIPCompressed(final PushbackInputStream inputStream) throws IOException {
		if (inputStream == null)
			return false;
		byte[] signature = new byte[2];
		int readStatus = inputStream.read(signature);
		inputStream.unread(signature);
		int streamHeader = ((int) signature[0] & 0xff) | ((signature[1] << 8) & 0xff00);
		return readStatus == 2 && GZIPInputStream.GZIP_MAGIC == streamHeader;
	}

	private String get(String url, String paramStr,
			ResponseHandlerInterface responseHandler) {
		if (paramStr == null) {
			if (responseHandler != null)
				responseHandler.sendFailureMessage(0, null, null, null);
		}
		 // 创建默认的httpClient实例.    
		HttpClient httpclient = new DefaultHttpClient();
        // 创建httppost    
        HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Connection", "Keep-Alive");
		httpPost.addHeader("Accept-Encoding", "gzip");
        // 创建参数队列    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("request", paramStr));
        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httpPost.setEntity(uefEntity);
            HttpResponse httpResponse = httpclient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();  
            if (entity != null) {
				InputStream responseStream;
				InputStream wrappedStream;
				PushbackInputStream pushbackStream;
				wrappedStream = entity.getContent();
				pushbackStream = new PushbackInputStream(wrappedStream, 2);
				if (isInputStreamGZIPCompressed(pushbackStream)) {
					responseStream = new GZIPInputStream(pushbackStream);
				} else {
					responseStream = pushbackStream;
				}

				byte[] buf = new byte[1024];
				ByteArrayOutputStream baos = new ByteArrayOutputStream();

				for (int i; (i = responseStream.read(buf)) != -1;) {
					baos.write(buf, 0, i);
				}
            	String response = baos.toString("UTF-8");
				baos.close();
				responseStream.close();
				wrappedStream.close();
				pushbackStream.close();
                return response;
            }    
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (NumberFormatException e) {
			e.printStackTrace();
		}
        return null;
	}

	/**
	 * 获取微信accesstoken
	 */
	public void getWxAccessToken(String url, WxAccessTokenReq data) {
		httpClient.get(url, data);
	}
}
