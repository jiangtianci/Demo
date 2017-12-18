package com.example.demo.model;

import android.util.Log;

import com.example.demo.api.APi;
import com.example.demo.api.APiService;
import com.example.demo.bean.Bean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 姜天赐 on 2017/12/6.
 */

public class Model implements Imodel {
    @Override
    public void RequestSuccess(String url, int start, int count, Onselect onselect) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(APi.PHOD)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        APiService aPiService = retrofit.create(APiService.class);
        Observable<Bean> getdata = aPiService.getdata(1, 3);
        getdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("ssssss失败",e.toString());
                    }

                    @Override
                    public void onNext(Bean bean) {
                        Log.i("ssssss",bean.toString());
                    }
                });

    }
}
