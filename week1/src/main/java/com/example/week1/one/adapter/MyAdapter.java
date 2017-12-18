package com.example.week1.one.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.week1.R;
import com.example.week1.one.bean.News;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dell on 2017/12/2.
 */

public class MyAdapter extends RecyclerView.Adapter {
    List<News.ResultsBean> list = new ArrayList<>();
    Context context;

    public MyAdapter(List<News.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViHolder myViHolder = (MyViHolder) holder;
        myViHolder.mTextSouse.setText(list.get(position).getDesc());
        Uri imgUrl = Uri.parse("http://img.gank.io/fef497ed-83ba-46f6-8a94-0e7b724e1c10");
        myViHolder.simpleDraweeView.setImageURI(imgUrl);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_souse)
        TextView mTextSouse;
        @BindView(R.id.sdv_image)
        SimpleDraweeView simpleDraweeView;

        public MyViHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
