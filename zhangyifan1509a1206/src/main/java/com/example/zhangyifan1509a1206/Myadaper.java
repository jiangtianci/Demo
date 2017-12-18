package com.example.zhangyifan1509a1206;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhangyifan1509a1206.modl.Bean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 */

public class Myadaper extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<Bean.NewslistBean> list;

    public Myadaper(Context context, List<Bean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    private Myviewhodler myviewhodler;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.item,null);
        myviewhodler = new Myviewhodler(view);
        return myviewhodler;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(list.get(position).getPicUrl())
                .setAutoPlayAnimations(true)
                .build();
        myviewhodler.sdv.setController(build);
        myviewhodler.tv.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class  Myviewhodler extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView tv;

        public Myviewhodler(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
