package com.example.eventbus.model;

import android.util.Log;

import com.example.eventbus.api.ApiService;
import com.example.eventbus.bean.MovieBean;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 姜天赐 on 2017/12/18.
 */

public class HttpModel implements Imodel {
    @Override
    public void getHttpData(String url, String catalogId, String pnum, final OnClick onClick) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Observable<MovieBean> movieData = apiService.getMovieData(catalogId, pnum);
        movieData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MovieBean movieBean) {
                        List<MovieBean.RetBean.ListBean> list = movieBean.ret.list;
                        onClick.Success(list);


                    }
                });
    }


}