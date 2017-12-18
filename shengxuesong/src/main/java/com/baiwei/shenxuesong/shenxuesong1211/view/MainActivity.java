package com.baiwei.shenxuesong.shenxuesong1211.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baiwei.shenxuesong.shenxuesong1211.Bean.CartBean;
import com.baiwei.shenxuesong.shenxuesong1211.Bean.CountAndPrice;
import com.baiwei.shenxuesong.shenxuesong1211.Bean.MessgeEvent;
import com.baiwei.shenxuesong.shenxuesong1211.R;
import com.baiwei.shenxuesong.shenxuesong1211.adapter.MyExpandableAdapter;
import com.baiwei.shenxuesong.shenxuesong1211.persenter.CartPersenter;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class MainActivity extends AppCompatActivity implements ICart {
    private List<List<CartBean.DataBean.ListBean>> childlist = new ArrayList<>();
    private ExpandableListView mElv;
    private CheckBox mQuanxuan;
    /**
     * 总价：0.0
     */
    private TextView mZongjia;
    /**
     * 共0件商品
     */
    private TextView mTvCount;
    private LinearLayout mActivityCart;
    private MyExpandableAdapter myExpandableAdapter;
    private CartPersenter cartPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //实例化p层
        cartPersenter = new CartPersenter(this);
        //调用p层的方法传值
        cartPersenter.getCartGoods("getCarts", "3043", "android");
        //注册EventBus
        EventBus.getDefault().register(this);
        /**
         * 为取消设点击事件
         */
        mQuanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myExpandableAdapter.qx(mQuanxuan.isChecked());
            }
        });
    }

    /**
     * 请求获得购物车的Bean
     * @param cartBean
     */
    @Override
    public void showBean(CartBean cartBean) {
        List<CartBean.DataBean> grouplist = cartBean.getData();
        for (int i = 0; i < grouplist.size(); i++) {
            CartBean.DataBean dataBean = grouplist.get(i);
            List<CartBean.DataBean.ListBean> list = dataBean.getList();
            childlist.add(list);
        }
        //没有
        mElv.setGroupIndicator(null);
        //默认展开
     /*   for (int i = 0; i <grouplist.size(); i++) {
            mElv.expandGroup(i);
        }*/

        //二级列表的适配器
        myExpandableAdapter = new MyExpandableAdapter(grouplist,this,childlist);
        mElv.setAdapter(myExpandableAdapter);

    }

    private void initView() {
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mQuanxuan = (CheckBox) findViewById(R.id.quanxuan);
        mZongjia = (TextView) findViewById(R.id.zongjia);
        mTvCount = (TextView) findViewById(R.id.tv_count);
        mActivityCart = (LinearLayout) findViewById(R.id.activity_cart);
    }

    /**
     * 传值给数量和价格
     * @param cp
     */
   @Subscribe
   public void getCP(CountAndPrice cp){
        mZongjia.setText("总价："+cp.getPrice());
        mTvCount.setText("共（"+cp.getCou()+"件商品）");
   }

    /**
     * 传值给全选
     * @param event
     */
   @Subscribe
   public void getMess(MessgeEvent event){
       mQuanxuan.setChecked(event.isCheck());
   }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        //取消绑定
        cartPersenter.getCartGoods("getCarts", "3043", "android");
    }
}
