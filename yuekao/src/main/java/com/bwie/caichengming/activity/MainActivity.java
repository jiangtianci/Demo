package com.bwie.caichengming.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.bwie.caichengming.R;
import com.bwie.caichengming.adapter.MyFragmentAdapter;
import com.bwie.caichengming.fragment.Frag_Faxian;
import com.bwie.caichengming.fragment.Frag_Jingxuan;
import com.bwie.caichengming.fragment.Frag_Wode;
import com.bwie.caichengming.fragment.Frag_Zhuanti;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> list_Frag;
    private ViewPager vp;
    private RadioGroup rg;
    private MyFragmentAdapter myFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        /**
         * 联动
         */
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_jingxuan:
                        vp.setCurrentItem(0);
                        break;

                    case R.id.rb_zhuanti:
                        vp.setCurrentItem(1);
                        break;

                    case R.id.rb_faxian:
                        vp.setCurrentItem(2);
                        break;

                    case R.id.rb_wode:
                        vp.setCurrentItem(3);
                        break;
                }
            }
        });
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);

        list_Frag = new ArrayList<>();
        list_Frag.add(new Frag_Jingxuan());
        list_Frag.add(new Frag_Zhuanti());
        list_Frag.add(new Frag_Faxian());
        list_Frag.add(new Frag_Wode());

        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),MainActivity.this, list_Frag);
        vp.setAdapter(myFragmentAdapter);
    }


}
