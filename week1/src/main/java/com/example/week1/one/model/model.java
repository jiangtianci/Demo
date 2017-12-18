package com.example.week1.one.model;

import com.example.week1.one.Api.ApiServer;
import com.example.week1.one.bean.News;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dell on 2017/12/2.
 */

public class model implements Imodel {


    @Override
    public void RequestSuccess(String url, final Onselect onselect) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<News> dates = apiServer.getDates();

        dates.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BannerBean>() {
//                .subscribe(new Subscriber<News>() {
                .subscribe(new Subscriber<News>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(News news) {
                        List<News.ResultsBean> results = news.getResults();
                        onselect.dataSuccess(results);
                    }
                });
    }
}
