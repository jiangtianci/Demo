package com.bwie.caichengming.model;

import com.bwie.caichengming.bean.Main_Bean;
import com.bwie.caichengming.utils.RetrofitUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class RecyModel implements IRecyModel {
    @Override
    public void recy(Observer<Main_Bean> observer) {
        RetrofitUtils.getNetDatas().getData()
                .subscribeOn(Schedulers.io())   //定义被观察者在子线程执行
                .observeOn(AndroidSchedulers.mainThread())  //定义观察者在主线程执行
                .subscribe(observer);
    }
}
