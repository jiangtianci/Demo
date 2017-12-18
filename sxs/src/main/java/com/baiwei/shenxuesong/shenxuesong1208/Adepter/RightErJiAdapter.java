package com.baiwei.shenxuesong.shenxuesong1208.Adepter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.baiwei.shenxuesong.shenxuesong1208.Bean.RightBean;
import com.baiwei.shenxuesong.shenxuesong1208.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Dell on 2017/12/8.
 */

public class RightErJiAdapter extends BaseExpandableListAdapter {
    List<RightBean.DataBean> grouplist;
    List<  List<RightBean.DataBean.ListBean>> childlist;
    Context context;

    public RightErJiAdapter(List<RightBean.DataBean> grouplist, List<List<RightBean.DataBean.ListBean>> childlist, Context context) {
        this.grouplist = grouplist;
        this.childlist = childlist;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return grouplist.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childlist.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return grouplist.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childlist.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolder1 holder1;
        if(view==null){
            view=View.inflate(context, R.layout.rightitem,null);
            holder1=new ViewHolder1();
            holder1.tv=view.findViewById(R.id.righttext);
            view.setTag(holder1);
        }else {
            holder1= (ViewHolder1) view.getTag();
        }
        RightBean.DataBean dataBean = grouplist.get(i);
            holder1.tv.setText(dataBean.getName());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolder2 holder2;
        if(view==null){
            view=View.inflate(context, R.layout.righteritem,null);
            holder2=new ViewHolder2();
            holder2.rlv=view.findViewById(R.id.rlv1);
            view.setTag(holder2);
        }else {
            holder2= (ViewHolder2) view.getTag();
        }
        List<RightBean.DataBean.ListBean> list = childlist.get(i);
        holder2.rlv.setLayoutManager(new GridLayoutManager(context,4));
        RightRLVAdapter rightRLVAdapter = new RightRLVAdapter(list, context);
        holder2.rlv.setAdapter(rightRLVAdapter);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    class ViewHolder1{
            TextView tv;
    }
    class ViewHolder2{
      RecyclerView rlv;
    }
}
