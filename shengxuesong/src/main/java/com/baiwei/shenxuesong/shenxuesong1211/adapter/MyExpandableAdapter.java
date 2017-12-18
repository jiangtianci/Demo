package com.baiwei.shenxuesong.shenxuesong1211.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baiwei.shenxuesong.shenxuesong1211.Bean.CartBean;
import com.baiwei.shenxuesong.shenxuesong1211.Bean.CountAndPrice;
import com.baiwei.shenxuesong.shenxuesong1211.Bean.MessgeEvent;
import com.baiwei.shenxuesong.shenxuesong1211.R;
import com.facebook.drawee.view.SimpleDraweeView;


import java.util.List;

import de.greenrobot.event.EventBus;

public class MyExpandableAdapter extends BaseExpandableListAdapter {
    private List<CartBean.DataBean> grouplist;
    private Context context;
    private List<List<CartBean.DataBean.ListBean>> childlist ;
  
    public MyExpandableAdapter(List<CartBean.DataBean> grouplist, Context context,List<List<CartBean.DataBean.ListBean>> childlist) {
        this.grouplist=grouplist;
        this.context = context;  
        this.childlist = childlist;  
    }  
  
    @Override  
    public int getGroupCount() {  
        return grouplist.size();
    }  
  
    @Override  
    public int getChildrenCount(int groupPosition) {  
        return childlist.get(groupPosition).size();  
    }  
  
    @Override  
    public Object getGroup(int groupPosition) {  
        return grouplist.get(groupPosition);
    }  
  
    @Override  
    public Object getChild(int groupPosition, int childPosition) {  
        return null;  
    }  
  
    @Override  
    public long getGroupId(int groupPosition) {  
        return groupPosition;  
    }  
  
    @Override  
    public long getChildId(int groupPosition, int childPosition) {  
        return childPosition;  
    }  
  
    @Override  
    public boolean hasStableIds() {  
        return false;  
    }  
  
    @Override  
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final GroupViewHolder holder;  
        if (convertView == null) {  
            convertView = View.inflate(context, R.layout.groupitem, null);
            holder = new GroupViewHolder();  
            holder.tv_group = convertView.findViewById(R.id.tv_group);  
            holder.group_cb = convertView.findViewById(R.id.gx_group);  
  
            convertView.setTag(holder);  
        } else {  
            holder = (GroupViewHolder) convertView.getTag();  
        }
        final CartBean.DataBean dataBean = grouplist.get(groupPosition);

        String sellerName = dataBean.getSellerName();  
        holder.group_cb.setChecked(dataBean.isCheck());
        holder.tv_group.setText(sellerName);  
        //点击一级checkbox的状态  
        holder.group_cb.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                dataBean.setCheck(holder.group_cb.isChecked());  
                //改变所有孩子的状态  
                  changeChildState(groupPosition,holder.group_cb.isChecked());  
                  EventBus.getDefault().post(jS());
                //通过判断一级的checkbox判断全选的状态  
                   changeMianQXstatus(checkGroupAll());  
                notifyDataSetChanged();  
            }  
        });  
  
  
        return convertView;  
    }  
  
    @Override  
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {  
        final ChildViewHolder holder;  
        if (convertView == null) {  
            convertView = View.inflate(context, R.layout.chidlitem, null);
            holder = new ChildViewHolder();  
  
               holder.tv_title=convertView.findViewById(R.id.title);  
               holder.price=convertView.findViewById(R.id.price);                //价格  
               holder.child_cb=convertView.findViewById(R.id.gouxuan_child);   //子勾选  
               holder.add=convertView.findViewById(R.id.jia);     //加加  
               holder.del=convertView.findViewById(R.id.del);      //删除  
              holder.jian=convertView.findViewById(R.id.jian);    //减  
              holder.sdv=convertView.findViewById(R.id.title_img);
              holder.tv_num=convertView.findViewById(R.id.tv_num);  //数量  
              holder.yanse=convertView.findViewById(R.id.yanse);  
            convertView.setTag(holder);  
        } else {  
            holder = (ChildViewHolder) convertView.getTag();  
        }
        final CartBean.DataBean.ListBean listBean = childlist.get(groupPosition).get(childPosition);

        int price = (int) listBean.getPrice();  
             holder.child_cb.setChecked(listBean.isCheck());  
        holder.price.setText("¥："+price+"");  
        String title = listBean.getTitle();  
        holder.tv_title.setText(title);  
        String subhead = listBean.getSubhead();  
        String substring = subhead.substring(1, 10)+".....";  
        holder.yanse.setText(substring);
       // listBean.setCou(1);
        /*
        6.加载图片时配置默认图片，加载中图片，加载错误时图片 （5分）
         */
        String images = listBean.getImages();  
        String[] split = images.split("\\|");  
        String s = split[0];
        Uri uri=Uri.parse(s);
          holder.sdv.setImageURI(uri);
        //给子条目的checkBox点击事件  
        holder.child_cb.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                listBean.setCheck(holder.child_cb.isChecked());  
  
                EventBus.getDefault().post(jS());  
                //如果二级的checkBox选中，就让一级的checkBox勾选  
                if(holder.child_cb.isChecked()) {  
  
                    if (ischeckAllchild(groupPosition)) {  
                        //改变一级checkBox的状态  
                        changeGroupstatus(groupPosition,true);  
                        //通过判断一级的CheckBox的状态来改变全选的状态  
                         changeMianQXstatus(checkGroupAll());  
  
                    }  
                }else{  
                    changeGroupstatus(groupPosition,false);  
                    changeMianQXstatus(checkGroupAll());  
                }  
                notifyDataSetChanged();  
            }  
  
        });  
  
        //点击加加的功能  
        holder.add.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                int cou = listBean.getNum();
                holder.tv_num.setText(++cou+"");  
                listBean.setNum(cou);
                if(holder.child_cb.isChecked()){  
                    EventBus.getDefault().post(jS());  
                }  
  
            }  
        });  
        //点击减减的功能  10.当数量为1时，点击减号，数量不变，（3分）吐司提示用户最小数量为1（2分）
        holder.jian.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                int cou = listBean.getNum();
  
                if(cou==1) {
                    Toast.makeText(context, "用户最小数量为1", Toast.LENGTH_SHORT).show();
                    return;}  
                holder.tv_num.setText(--cou+"");  
                listBean.setNum(cou);
                if (holder.child_cb.isChecked()) {  
                        EventBus.getDefault().post(jS());  
  
                }  
            }  
        });  
      //点击删除  13点击删除按钮，删除item，底部总数及总价能做出正确修改（5分），接口数据删除（5分）
        holder.del.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {
                List<CartBean.DataBean.ListBean> listBeans = childlist.get(groupPosition);
                CartBean.DataBean.ListBean remove = listBeans.remove(childPosition);
                if(listBeans.size()==0){
                    childlist.remove(childPosition);  
                    grouplist.remove(groupPosition);
                }  
               EventBus.getDefault().post(jS());  
                notifyDataSetChanged();  
  
            }  
        });  
  
        return convertView;  
    }  
  
    @Override  
    public boolean isChildSelectable(int groupPosition, int childPosition) {  
        return true;  
    }  
  
    class GroupViewHolder {  
        CheckBox group_cb;
        TextView tv_group;
    }  
  
    class ChildViewHolder {  
        CheckBox child_cb;  
        TextView tv_title,price,yanse,tv_num;  
        ImageView del,add,jian;
         SimpleDraweeView sdv;
  
    }  
    /** 
     * 判断全部的二级是CheckBox否选中 
     * 
     */  
    private boolean ischeckAllchild(int g){
        List<CartBean.DataBean.ListBean> listBeans = childlist.get(g);
        for (int i = 0; i <listBeans.size() ; i++) {
            CartBean.DataBean.ListBean listBean = listBeans.get(i);

            if(!listBean.isCheck()){  
                return false;  
            }  
        }  
        return true;  
    }  
  
    /** 
     * 计算数量和价格 
     * 通过遍历一级的得到二级的CheckBox，如果是选择的选中状态的话，就统计它们的总计的数量和价格 
     */  
    private CountAndPrice jS(){
        int cou=0;  
        int jiage=0;  
        for (int i = 0; i <grouplist.size() ; i++) {
            for (int j = 0; j <childlist.get(i).size() ; j++) {
                CartBean.DataBean.ListBean listBean = childlist.get(i).get(j);

                if(listBean.isCheck()){  
                    cou+=listBean.getNum();
                    jiage+=(int)listBean.getPrice()*listBean.getNum();
                }  
  
            }  
  
        }  
        CountAndPrice countAndPrice = new CountAndPrice();  
        countAndPrice.setCou(cou);
        countAndPrice.setPrice(jiage);  
        return countAndPrice;  
    }  
    /** 
     * 改变一级列表的状态 
     */  
    private void changeGroupstatus(int groupPosition,boolean flag ){
        CartBean.DataBean dataBean = grouplist.get(groupPosition);

        dataBean.setCheck(flag);  
    }  
    /** 
     * 改变全选的状态 
     * 
     */  
    private void changeMianQXstatus(boolean flag){  
        MessgeEvent messgeEvent = new MessgeEvent();
         messgeEvent.setCheck(flag);  
        EventBus.getDefault().post(messgeEvent);  
    }  
    /** 
     * 判断一级的是否全部选中 
     */  
    private boolean checkGroupAll(){  
        for (int i = 0; i < grouplist.size(); i++) {
            if(!grouplist.get(i).isCheck()){
                return false;  
            }  
        }  
        return true;  
    }  
    /** 
     * 改变所有孩子的状态 
     */  
    private void changeChildState(int grouPistion,boolean flag){
        List<CartBean.DataBean.ListBean> listBeans = childlist.get(grouPistion);
        for (int i = 0; i < listBeans.size(); i++) {
           listBeans.get(i).setCheck(flag);
        }  
    }  
    /** 
     * 改变全选的 
     */  
    public void qx(boolean flag){  
        for (int i = 0; i < grouplist.size(); i++) {
           changeGroupstatus(i, flag);  
           changeChildState(i, flag);  
        }  
        EventBus.getDefault().post(jS());  
        notifyDataSetChanged();  
    }  
}  