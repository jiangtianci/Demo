/**
 * Project Name:WechatLoginDemo
 * File Name:WxAccessToken.java
 * Package Name:com.example.chenzhengjun.wechatlogindemo
 * Date:11/5/2015
 * Copyright (c) 2015, iczjun@gmail.com All Rights Reserved.
 */
package com.example.chenzhengjun.wechatlogindemo;

import java.io.Serializable;

/**
 * 
 * @author chenzhengjun
 * 
 */
public class WxAccessToken implements Serializable {

	/**
    *
    */
	private static final long serialVersionUID = 1L;
	/**
	 * 接口调用凭证
	 */
	public String access_token;
	/**
	 * access_token接口调用凭证超时时间，单位（秒）
	 */
	public int expires_in;
	/**
	 * 用户刷新access_token
	 */
	public String refresh_token;
	/**
	 * 授权用户唯一标识
	 */
	public String openId;
	/**
	 * 用户授权的作用域，使用逗号（,）分隔
	 */
	public String scope;
	/**
	 * 用户授权的作用域，使用逗号（,）分隔
	 */
	public String unionid;
	/**
	 * 错误码
	 */
	public int errcode;
	/**
	 * 错误信息
	 */
	public String errmsg;

	/**
 * 
 */
	public WxAccessToken() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the access_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * @param access_token
	 *            the access_token to set
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * @return the expires_in
	 */
	public int getExpires_in() {
		return expires_in;
	}

	/**
	 * @param expires_in
	 *            the expires_in to set
	 */
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * @return the refresh_token
	 */
	public String getRefresh_token() {
		return refresh_token;
	}

	/**
	 * @param refresh_token
	 *            the refresh_token to set
	 */
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId
	 *            the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * @param scope
	 *            the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * @return the unionid
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * @param unionid
	 *            the unionid to set
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/**
	 * @return the errcode
	 */
	public int getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode
	 *            the errcode to set
	 */
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	/**
	 * @return the errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}

	/**
	 * @param errmsg
	 *            the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
