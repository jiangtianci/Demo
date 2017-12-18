package com.example.week1.one.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week1.R;
import com.example.week1.one.view.News_bean;

import java.util.List;


/**
 * Created by dell on 2017/12/2.
 */

public class MyGreendaoAdapter extends RecyclerView.Adapter {

    List<News_bean> list;
    Context context;

    public MyGreendaoAdapter(List<News_bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
        return new MyviewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyviewHolder myviewHolder = (MyviewHolder) holder;
        myviewHolder.textView.setText(list.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder {


        private final TextView textView;

        public MyviewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_souse1);
        }

    }


}
