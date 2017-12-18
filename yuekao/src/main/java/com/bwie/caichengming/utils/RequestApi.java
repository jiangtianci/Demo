package com.bwie.caichengming.utils;

import com.bwie.caichengming.bean.Main_Bean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import rx.Observable;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public interface RequestApi {
    public static final String BASE_URL = "http://api.svipmovie.com/front/";

    //get和RxJava
    @GET("homePageApi/homePage.do")
    Observable<Main_Bean> getData();

    //get和RxJava
    @GET("videoDetailApi/videoDetail.do?mediaId=b6c8438873fd4a0f8880b2def64c6472")
    Observable<Main_Bean> getXiangqing();

    @Streaming
    @POST("{fileName}")
    Call<ResponseBody> downloadFile(@Path("fileName") String fileName, @Header("Range") String range);

    @Streaming
    @POST("{fileName}")
    Call<ResponseBody> getFileLenght(@Path("fileName") String fileName);
}
