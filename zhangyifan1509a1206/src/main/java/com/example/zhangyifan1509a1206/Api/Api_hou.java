package com.example.zhangyifan1509a1206.Api;

import com.example.zhangyifan1509a1206.modl.Bean;

import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/12/6.
 */

public interface Api_hou {
    @GET("nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10")
    rx.Observable<Bean> getmyApi_hou();
}
