package com.baiwei.shenxuesong.shenxuesong1208.Adepter;

import android.content.Context;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baiwei.shenxuesong.shenxuesong1208.Bean.LeftBean;
import com.baiwei.shenxuesong.shenxuesong1208.Bean.RightBean;
import com.baiwei.shenxuesong.shenxuesong1208.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Dell on 2017/12/8.
 */

public class RightRLVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private  List<RightBean.DataBean.ListBean> list;
    private Context context;
    private String s;


    public RightRLVAdapter( List<RightBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //创建新View，被LayoutManager所调用  
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rightrvlitem,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RightBean.DataBean.ListBean listBean = list.get(position);
        ViewHolder vh= (ViewHolder) holder;
        String icon = listBean.getIcon();
        Uri uri=Uri.parse(icon);

        vh.mTextView.setText(listBean.getName());
        vh.sdv.setImageURI(uri);
    }

    //获取数据的数量  
    @Override
    public int getItemCount() {
        return 1;
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素  
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
       SimpleDraweeView sdv;
        public ViewHolder(View view){
            super(view);
            mTextView = (TextView) view.findViewById(R.id.tv2);
            sdv=view.findViewById(R.id.sdl);

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
