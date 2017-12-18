package com.example.week1.one;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.week1.gen.DaoMaster;
import com.example.week1.gen.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;


/**
 * Created by dell on 2017/12/2.
 */

public class GreenDao extends Application{
    private static GreenDao init_api;
    private DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        init_api = this;
        setGreendao();
    }
    public static GreenDao getInit_api(){
        return init_api;
    }
    private void setGreendao() {
        DaoMaster.DevOpenHelper db = new DaoMaster.DevOpenHelper(this, "db", null);
        SQLiteDatabase writableDatabase = db.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        daoSession = daoMaster.newSession();
    }
    public DaoSession getDaoSession(){
        return daoSession;
    }

}