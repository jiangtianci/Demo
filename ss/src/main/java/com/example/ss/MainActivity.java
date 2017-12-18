package com.example.ss;

import android.database.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Retrofit build = new Retrofit.Builder()
                .baseUrl(Api_Class.Api_qian)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        Api_interface api_interface = build.create(Api_interface.class);
        rx.Observable<Bean> api_interface1 = api_interface.getApi_interface();
        api_interface1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("sssssssssssssss失败",e.toString());
                    }

                    @Override
                    public void onNext(Bean bean) {
                        String title = bean.data.subjects.get(0).detail;
                        Log.i("sssssssssssssss",title);
                    }
                });
    }
}
