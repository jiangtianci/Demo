package com.baiwei.shenxuesong.shenxuesong1211.model;

import com.baiwei.shenxuesong.shenxuesong1211.Bean.CGSB;
import com.baiwei.shenxuesong.shenxuesong1211.Bean.CartBean;

/**
 * Created by Dell on 2017/12/11.
 */

public interface CartJK {
    public void getCart(String s, String uid, String source, final CGSB<CartBean> cgsb);
}
