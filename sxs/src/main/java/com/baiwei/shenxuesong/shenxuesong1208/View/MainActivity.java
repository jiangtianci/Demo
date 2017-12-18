package com.baiwei.shenxuesong.shenxuesong1208.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ExpandableListView;

import com.baiwei.shenxuesong.shenxuesong1208.Adepter.LeftAdapter;
import com.baiwei.shenxuesong.shenxuesong1208.Adepter.RightErJiAdapter;
import com.baiwei.shenxuesong.shenxuesong1208.Bean.LeftBean;
import com.baiwei.shenxuesong.shenxuesong1208.Bean.RightBean;
import com.baiwei.shenxuesong.shenxuesong1208.Persenter.LeftPersent;
import com.baiwei.shenxuesong.shenxuesong1208.R;
import com.baiwei.shenxuesong.shenxuesong1208.net.API;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMain{

    private RecyclerView mRlv;
    private ExpandableListView mElv;
    private LeftAdapter leftAdapter;
    private LeftPersent leftPersent;
    private List<  List<RightBean.DataBean.ListBean>> childlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftPersent = new LeftPersent(this);
        leftPersent.getLeft(API.Prodect);
        initView();


    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mElv = (ExpandableListView) findViewById(R.id.elv);
    }

    @Override
    public void showBean(LeftBean leftBean) {
        List<LeftBean.DataBean> data = leftBean.getData();
         mRlv.setLayoutManager(new LinearLayoutManager(this));
        leftAdapter = new LeftAdapter(data, this);
        mRlv.setAdapter(leftAdapter);
        leftAdapter.setOnItemClickLisenter(new LeftAdapter.OnItemClickLisenter() {
            @Override
            public void onitemClick(int a) {
                 leftPersent.getRight("getProductCatagory",a);
            }
        });

    }

    @Override
    public void showRight(RightBean rightBean) {
        List<RightBean.DataBean> grouplist = rightBean.getData();

        for (int i = 0; i < grouplist.size(); i++) {
            List<RightBean.DataBean.ListBean> list = grouplist.get(i).getList();
            childlist.add(list);
        }
        RightErJiAdapter rightErJiAdapter = new RightErJiAdapter(grouplist, childlist, this);
        mElv.setAdapter(rightErJiAdapter);
    }
}
