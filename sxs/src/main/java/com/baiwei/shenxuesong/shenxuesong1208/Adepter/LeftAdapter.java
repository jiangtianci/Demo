package com.baiwei.shenxuesong.shenxuesong1208.Adepter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baiwei.shenxuesong.shenxuesong1208.Bean.LeftBean;
import com.baiwei.shenxuesong.shenxuesong1208.R;

import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by Dell on 2017/12/8.
 */

public class LeftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<LeftBean.DataBean>  list;
    private Context context;
    private String s;
 

    public LeftAdapter( List<LeftBean.DataBean>  list, Context context) {
        this.list = list;
        this.context = context;
    }

    //创建新View，被LayoutManager所调用  
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.leftitem,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LeftBean.DataBean dataBean = list.get(position);
        ViewHolder vh= (ViewHolder) holder;

        final int cid = dataBean.getCid();


        vh.mTextView.setText(dataBean.getName());
        vh.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              onItemClickLisenter.onitemClick(cid);
            }
        });
    }

    //获取数据的数量  
    @Override
    public int getItemCount() {
        return list.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素  
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
            LinearLayout ll;
        public ViewHolder(View view){
            super(view);
            mTextView = (TextView) view.findViewById(R.id.left_text);
             ll=  view.findViewById(R.id.lw);
        }
    }
    public interface OnItemClickLisenter{
        void onitemClick(int a);
    }
    private OnItemClickLisenter onItemClickLisenter;
    public void setOnItemClickLisenter(OnItemClickLisenter onItemClickLisenter){
        this.onItemClickLisenter=onItemClickLisenter;
    }
}
