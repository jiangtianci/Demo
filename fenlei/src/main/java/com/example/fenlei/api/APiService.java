package com.example.fenlei.api;

import android.database.Observable;

import com.example.fenlei.bean.Bean1;
import com.example.fenlei.bean.Bean2;

import retrofit2.http.GET;

/**
 * Created by 姜天赐 on 2017/12/8.
 */

public interface APiService {
    @GET("getCatagory")
    Observable<Bean1>fenlei1();
    @GET("getProductCatagory")
    Observable<Bean2> fenlei2();
}
