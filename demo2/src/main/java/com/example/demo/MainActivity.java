package com.example.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.demo.api.APi;
import com.example.demo.bean.Bean;
import com.example.demo.persenter.Persenter;
import com.example.demo.view.Iview;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Persenter persenter=new Persenter(this);
        persenter.getOk(APi.PHOD,1,3);





    }

    @Override
    public void showSuccess(List<Bean.SubjectsBean> list) {
        Log.i("sssssssssss",list.toString());

    }
}
