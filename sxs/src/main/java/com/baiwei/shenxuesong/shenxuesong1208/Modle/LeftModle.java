package com.baiwei.shenxuesong.shenxuesong1208.Modle;

import com.baiwei.shenxuesong.shenxuesong1208.Bean.LeftBean;
import com.baiwei.shenxuesong.shenxuesong1208.Bean.RightBean;
import com.baiwei.shenxuesong.shenxuesong1208.net.CGSB;
import com.baiwei.shenxuesong.shenxuesong1208.net.RetrofitHelper;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Dell on 2017/12/8.
 */

public class LeftModle implements LeftJK {
    public void getModel(String s, final CGSB<LeftBean> cgsb){
        Flowable<LeftBean> flowable = RetrofitHelper.getServiceAPI().getLeft(s);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LeftBean>() {
                    @Override
                    public void accept(LeftBean leftBean) throws Exception {
                        cgsb.chengGong(leftBean);
                    }
                });
    }

    @Override
    public void getRight(String s, int p, final CGSB<RightBean> cgsb) {
        Flowable<RightBean> flowable = RetrofitHelper.getServiceAPI().getRight(s, p);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<RightBean>() {
                    @Override
                    public void accept(RightBean rightBean) throws Exception {
                        cgsb.chengGong(rightBean);
                    }
                });
    }
}
