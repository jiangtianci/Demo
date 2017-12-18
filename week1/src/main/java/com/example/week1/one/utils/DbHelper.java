package com.example.week1.one.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.week1.gen.DaoMaster;
import com.example.week1.gen.DaoSession;
import com.example.week1.gen.News_beanDao;

/**
 * Created by dell on 2017/12/2.
 */

public class DbHelper {
    private static volatile DbHelper instance;
    private final DaoSession daoSession;
    private final DaoMaster daoMaster;


    private DbHelper(Context context) {
        // 初始化数据库的一些配置
        DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(context, "user", null);
        // 获取数据库操作对象
        SQLiteDatabase db = mHelper.getWritableDatabase();
        // 获取DaoMaster对象
        daoMaster = new DaoMaster(db);
        // 获取DaoSession对象
        daoSession = daoMaster.newSession();
    }

    public static DbHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (DbHelper.class) {
                if (null == instance) {
                    instance = new DbHelper(context);
                }
            }
        }

        return instance;
    }

    public News_beanDao getPersonDao() {
        return daoSession.getNews_beanDao();
    }

}
