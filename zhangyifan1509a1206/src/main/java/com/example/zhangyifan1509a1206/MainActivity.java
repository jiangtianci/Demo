package com.example.zhangyifan1509a1206;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zhangyifan1509a1206.modl.Bean;
import com.example.zhangyifan1509a1206.presenter.Shoupresenter;
import com.example.zhangyifan1509a1206.view.Iview;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview{

    private Shoupresenter shoupresenter;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        shoupresenter = new Shoupresenter(this);
        shoupresenter.getmodl();
    }

    @Override
    public void getiview(Bean bean) {
        List<Bean.NewslistBean> list = bean.getNewslist();
        Myadaper myadaper = new Myadaper(this,list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        rv.setAdapter(myadaper);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        shoupresenter.getguanbi();
    }
}
