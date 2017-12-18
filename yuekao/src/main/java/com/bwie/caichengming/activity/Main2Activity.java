package com.bwie.caichengming.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bwie.caichengming.R;
import com.bwie.caichengming.adapter.MyFragment2Adapter;
import com.bwie.caichengming.bean.XiangQing_Bean;
import com.bwie.caichengming.fragment.Frag_Pinglun;
import com.bwie.caichengming.fragment.Frag_jianjie;
import com.bwie.caichengming.view.IXiangQingView;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class Main2Activity extends AppCompatActivity implements IXiangQingView{

    private List<Fragment> list_Frag2;
    private ViewPager main2_vp;
    private MyFragment2Adapter myFragment2Adapter;
    private RadioGroup rg_fragment;
    private TextView tv_return;

    private JCVideoPlayerStandard jcVideoPlayerStandard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();



    }

    private void initView() {
        main2_vp = (ViewPager) findViewById(R.id.main2_vp);
        rg_fragment = (RadioGroup) findViewById(R.id.rg_fragment);
        tv_return = (TextView) findViewById(R.id.tv_return);
        tv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        list_Frag2 = new ArrayList<>();
        list_Frag2.add(new Frag_jianjie());
        list_Frag2.add(new Frag_Pinglun());
        myFragment2Adapter = new MyFragment2Adapter(getSupportFragmentManager(), Main2Activity.this, list_Frag2);
        main2_vp.setAdapter(myFragment2Adapter);

        /**
         * 联动
         */
        rg_fragment.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_jianjie:
                        main2_vp.setCurrentItem(0);
                        break;

                    case R.id.rb_pinglun:
                        main2_vp.setCurrentItem(1);
                        break;
                }
            }
        });

    }

    @Override
    public void showXiagnQing(XiangQing_Bean xiangQing_bean) {
        //设置标题 有需要的可以试一下
        //getSupportActionBar().setTitle("jiecaovideoplayer的使用");
        //找控件
        jcVideoPlayerStandard= (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);
        //设置视频上显示的文字
        jcVideoPlayerStandard.setUp(xiangQing_bean.getRet().getHDURL(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");

    }

    /**
     * 不要忘了这两个方法
     * */
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
//    public static void setTitle(Activity activity, int resId) {
//        activity.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
//        activity.setContentView(resId); // activity的布局
//        activity.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, com.tejun.qunx.R.layout.title);// 标题栏的布局
//    }
}
