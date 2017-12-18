package com.bwie.caichengming.presenter;

import android.util.Log;

import com.bwie.caichengming.bean.Main_Bean;
import com.bwie.caichengming.model.IRecyModel;
import com.bwie.caichengming.model.RecyModel;
import com.bwie.caichengming.view.IRecyView;

import rx.Observer;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class RecyPresenter {
    private IRecyView view;
    private IRecyModel model;


    public RecyPresenter(IRecyView view) {
        this.view = view;
        model = new RecyModel();
    }

    public void showRecy(){
        model.recy(new Observer<Main_Bean>() {
            @Override
            public void onCompleted() {
                Log.i("我用retrofit+RxJava好使啦", "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("我用retrofit+RxJava好使啦", "onError: ");
            }

            @Override
            public void onNext(Main_Bean main_bean) {
                Log.i("我用retrofit+RxJava好使啦", "onNext: ");
                view.showRecy(main_bean);
            }
        });
    }

    //解绑
    public void onDestory(){
        view = null;
    }
}
