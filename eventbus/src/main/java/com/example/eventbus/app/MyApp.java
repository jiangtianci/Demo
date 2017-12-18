package com.example.eventbus.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 姜天赐 on 2017/12/18.
 */

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //初始化fresco
        Fresco.initialize(this);
    }
}
