package com.bwie.caichengming.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<Fragment> list_Frag;

    public MyFragmentAdapter(FragmentManager fm, Context context, List<Fragment> list_Frag) {
        super(fm);
        this.context = context;
        this.list_Frag = list_Frag;
    }

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list_Frag.get(position);
    }

    @Override
    public int getCount() {
        return list_Frag.size();
    }
}
