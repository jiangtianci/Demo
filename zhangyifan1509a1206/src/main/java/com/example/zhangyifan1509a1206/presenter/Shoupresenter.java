package com.example.zhangyifan1509a1206.presenter;

import com.example.zhangyifan1509a1206.modl.Bean;
import com.example.zhangyifan1509a1206.modl.Shoumodl;
import com.example.zhangyifan1509a1206.view.Iview;

/**
 * Created by Administrator on 2017/12/6.
 */

public class Shoupresenter implements Ipresenter{
    Iview iview ;
    private final Shoumodl shoumodl;

    public Shoupresenter(Iview iview) {
        this.iview = iview;
        shoumodl = new Shoumodl();
    }
    public void getguanbi(){
        iview = null;
    }

    @Override
    public void getmodl() {
        shoumodl.getimodl(this);
    }

    @Override
    public void getipresenter(Bean bean) {
    iview.getiview(bean);
    }
}
