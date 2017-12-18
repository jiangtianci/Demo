package com.bwie.caichengming.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class MyFragment2Adapter extends FragmentPagerAdapter {

    private Context context;
    private List<Fragment> list_Frag2;

    public MyFragment2Adapter(FragmentManager fm, Context context, List<Fragment> list_Frag2) {
        super(fm);
        this.context = context;
        this.list_Frag2 = list_Frag2;
    }


    public MyFragment2Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list_Frag2.get(position);
    }

    @Override
    public int getCount() {
        return list_Frag2.size();
    }
}
