package com.example.eventbus.adapter;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eventbus.R;
import com.example.eventbus.bean.MovieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 姜天赐 on 2017/12/18.
 */
public class MyAdapter extends RecyclerView.Adapter  implements View.OnClickListener{
    Context context;
    List<MovieBean.RetBean.ListBean> list;
    private View view;
    private ViewHolder holder;

    public MyAdapter(Context context, List<MovieBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }
    private OnItemClickListener mOnItemClickListener = null;
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).face .setImageURI(Uri.parse(list.get(position).pic));
        ((ViewHolder)holder).title.setText(list.get(position).description);
        ((ViewHolder)holder).itemView.setTag(position);

    }
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public SimpleDraweeView face;
        public TextView title;
        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.face = (SimpleDraweeView) rootView.findViewById(R.id.face);
            this.title = (TextView) rootView.findViewById(R.id.title);
        }
    }
}