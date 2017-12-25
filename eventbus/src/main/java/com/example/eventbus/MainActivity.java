package com.example.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eventbus.adapter.MyAdapter;
import com.example.eventbus.api.Api;
import com.example.eventbus.bean.MovieBean;
import com.example.eventbus.presenter.MyPresenter;
import com.example.eventbus.view.Iview;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Iview {
    private RecyclerView recycler;
    private MyAdapter adapter;
    private MyPresenter presenter;
    final String catalogId = "402834815584e463015584e539330016";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        presenter = new MyPresenter(this);
        presenter.loadlist(Api.BASE_URL,catalogId,"1");
    }
    @Override
    public void getShowData(List<MovieBean.RetBean.ListBean> list) {
        adapter=new MyAdapter(
                MainActivity.this,list);
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view , int position){
                Toast.makeText(MainActivity.this,"点击了第"+position+"条数据", Toast.LENGTH_SHORT).show();
            }
        });

    }
    
}
