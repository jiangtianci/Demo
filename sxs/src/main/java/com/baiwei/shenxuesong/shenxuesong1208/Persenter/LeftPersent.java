package com.baiwei.shenxuesong.shenxuesong1208.Persenter;

import com.baiwei.shenxuesong.shenxuesong1208.Bean.LeftBean;
import com.baiwei.shenxuesong.shenxuesong1208.Bean.RightBean;
import com.baiwei.shenxuesong.shenxuesong1208.Modle.LeftModle;
import com.baiwei.shenxuesong.shenxuesong1208.View.IMain;
import com.baiwei.shenxuesong.shenxuesong1208.net.CGSB;

/**
 * Created by Dell on 2017/12/8.
 */

public class LeftPersent {

    private final LeftModle leftModle;
     private IMain iMain;
    public LeftPersent(IMain iMain) {
        this.iMain=iMain;
        leftModle = new LeftModle();

    }
    public void getLeft(String s){
        leftModle.getModel(s, new CGSB<LeftBean>() {
            @Override
            public void chengGong(LeftBean leftBean) {
                iMain.showBean(leftBean);
            }
        });
    }
    public void getRight(String s,int p){
        leftModle.getRight(s, p, new CGSB<RightBean>() {
            @Override
            public void chengGong(RightBean rightBean) {
                iMain.showRight(rightBean);
            }
        });
    }
}
