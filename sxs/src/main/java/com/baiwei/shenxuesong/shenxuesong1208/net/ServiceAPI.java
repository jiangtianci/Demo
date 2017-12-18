package com.baiwei.shenxuesong.shenxuesong1208.net;

import com.baiwei.shenxuesong.shenxuesong1208.Bean.LeftBean;
import com.baiwei.shenxuesong.shenxuesong1208.Bean.RightBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Dell on 2017/12/8.
 */

public interface ServiceAPI {
    @GET("{getCatagory}")
    public Flowable<LeftBean> getLeft(@Path("getCatagory") String s);
    @GET("{getCatagory}")
    public Flowable<RightBean> getRight(@Path("getCatagory") String s, @Query("cid")int p);
}
