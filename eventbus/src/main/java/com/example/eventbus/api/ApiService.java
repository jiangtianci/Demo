package com.example.eventbus.api;

import com.example.eventbus.bean.MovieBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 姜天赐 on 2017/12/18.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("columns/getVideoList.do")
    Observable<MovieBean> getMovieData(@Field("catalogId") String catalogId, @Field("pnum") String pnum);

}
