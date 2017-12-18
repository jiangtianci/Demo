package com.baiwei.shenxuesong.shenxuesong1211.model;

import com.baiwei.shenxuesong.shenxuesong1211.Bean.CGSB;
import com.baiwei.shenxuesong.shenxuesong1211.Bean.CartBean;
import com.baiwei.shenxuesong.shenxuesong1211.net.RetrofitHepler;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Dell on 2017/12/11.
 */

public class CartModel implements CartJK{
    /**
     * 购物车的modle
     * @param s
     * @param uid
     * @param source
     * @param cgsb
     */
    @Override
    public void getCart(String s, String uid, String source, final CGSB<CartBean> cgsb){
        Flowable<CartBean> flowable = RetrofitHepler.getSerViceAPI().getCart(s, uid, source);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CartBean>() {
                    @Override
                    public void accept(CartBean cartBean) throws Exception {
                        cgsb.chengGong(cartBean);
                    }
                });
       }
}
