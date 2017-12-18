package com.bwie.caichengming.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bwie.caichengming.bean.PingLun_Bean;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class MyBaseAdapter extends BaseAdapter {

    private Context context;
    private PingLun_Bean pingLun_bean;

    public MyBaseAdapter(Context context, PingLun_Bean pingLun_bean) {
        this.context = context;
        this.pingLun_bean = pingLun_bean;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
