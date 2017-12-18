package com.baiwei.shenxuesong.shenxuesong1208.Modle;

import com.baiwei.shenxuesong.shenxuesong1208.Bean.LeftBean;
import com.baiwei.shenxuesong.shenxuesong1208.Bean.RightBean;
import com.baiwei.shenxuesong.shenxuesong1208.net.CGSB;

/**
 * Created by Dell on 2017/12/8.
 */

public interface LeftJK {
    void getModel(String s, final CGSB<LeftBean> cgsb);
    void getRight(String s, int p, CGSB<RightBean> cgsb);
}
