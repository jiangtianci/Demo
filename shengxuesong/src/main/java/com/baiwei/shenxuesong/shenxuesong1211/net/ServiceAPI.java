package com.baiwei.shenxuesong.shenxuesong1211.net;

import com.baiwei.shenxuesong.shenxuesong1211.Bean.CartBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Dell on 2017/12/11.
 */

public interface ServiceAPI {
    //购物车
    //http://120.27.23.105/product/getCarts?uid=71&source=android
    @GET("{getCarts}")
    Flowable<CartBean> getCart(@Path("getCarts")String s, @Query("uid")String uid,@Query("source")String source);
}
