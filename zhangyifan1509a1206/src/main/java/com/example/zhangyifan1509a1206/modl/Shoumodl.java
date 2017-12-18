package com.example.zhangyifan1509a1206.modl;

import android.util.Log;

import com.example.zhangyifan1509a1206.Api.Api_hou;
import com.example.zhangyifan1509a1206.Api.Api_qian1;
import com.example.zhangyifan1509a1206.presenter.Ipresenter;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/6.
 */

public class Shoumodl implements Imodl {
    @Override
    public void getimodl(final Ipresenter ipresenter) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api_qian1.Api_qian)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        Api_hou api_hou = retrofit.create(Api_hou.class);
        Observable<Bean> observable = api_hou.getmyApi_hou();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        Log.i("ssssssssssss",bean.getNewslist().get(0).getTitle());
                        ipresenter.getipresenter(bean);
                        
                    }
                });
    }
}
