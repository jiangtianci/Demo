package com.example.denos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;
    private BottomTabBar bottom_tab_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("首页", R.mipmap.ic_launcher, OneFragment.class)
                .addTabItem("想法", R.mipmap.ic_launcher, TwoFragment.class)
                .addTabItem("市场", R.mipmap.ic_launcher, ThreeFragment.class)
                .addTabItem("通知", R.mipmap.ic_launcher, FourFragment.class);
    }

}
