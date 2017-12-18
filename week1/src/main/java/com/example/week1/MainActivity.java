package com.example.week1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.week1.four.FourFragment;
import com.example.week1.one.OneFragment;
import com.example.week1.three.ThreeFragment;
import com.example.week1.two.TwoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottom_tab_bar)
    BottomTabBar mBottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        BottomTabBar mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        mBottomTabBar.init(getSupportFragmentManager())
                .addTabItem("首页", R.mipmap.ic_launcher, OneFragment.class)
                .addTabItem("想法", R.mipmap.ic_launcher, TwoFragment.class)
                .addTabItem("市场", R.mipmap.ic_launcher, ThreeFragment.class)
                .addTabItem("通知", R.mipmap.ic_launcher, FourFragment.class);


    }
}
