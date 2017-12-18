package com.bwie.caichengming.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.caichengming.R;
import com.bwie.caichengming.activity.Main2Activity;
import com.bwie.caichengming.bean.Main_Bean;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.MyViewHolder>{
    private Context context;
    private Main_Bean main_bean;

    public MyRecyAdapter(Context context, Main_Bean main_bean) {
        this.context = context;
        this.main_bean = main_bean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recy, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Glide.with(context).load(main_bean.getRet().getList().get(0).getChildList().get(position).getPic()).into(holder.iv_item);
        holder.sdv.setImageURI(main_bean.getRet().getList().get(0).getChildList().get(position).getPic());
        holder.tv_title.setText(main_bean.getRet().getList().get(0).getChildList().get(position).getTitle());
        holder.sdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main2Activity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return main_bean.getRet().getList().get(0).getChildList().size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        //ImageView iv_item;
        TextView tv_title;
        SimpleDraweeView sdv;

        public MyViewHolder(View itemView) {
            super(itemView);
            //iv_item = itemView.findViewById(R.id.iv_item);
            sdv = itemView.findViewById(R.id.sdv);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
