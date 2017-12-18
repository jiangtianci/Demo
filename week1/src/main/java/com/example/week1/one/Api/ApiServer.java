package com.example.week1.one.Api;


import com.example.week1.one.bean.News;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by dell on 2017/12/2.
 */

public interface ApiServer {
    @GET("api/data/Android/10/1")
    Observable<News> getDates();

}
