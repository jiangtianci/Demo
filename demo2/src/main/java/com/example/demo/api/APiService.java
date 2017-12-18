package com.example.demo.api;
import com.example.demo.bean.Bean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
/**
 * Created by 姜天赐 on 2017/12/6.
 */
public interface APiService {
    @FormUrlEncoded
    @POST("v2/movie/top250")
    Observable<Bean> getdata(@Field("start") int start, @Field("count") int count);
}
