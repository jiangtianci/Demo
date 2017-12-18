package com.example.eventbus.presenter;

import com.example.eventbus.bean.MovieBean;
import com.example.eventbus.model.HttpModel;
import com.example.eventbus.model.Imodel;
import com.example.eventbus.model.OnClick;
import com.example.eventbus.view.Iview;

import java.util.List;

/**
 * Created by 姜天赐 on 2017/12/18.
 */

public class MyPresenter implements Ipersenter{
    //定义view和model接口的变量
    private  Iview iview;
    private  Imodel imodel;

    public MyPresenter(Iview iview) {
        this.iview = iview;
        this.imodel=new HttpModel();
    }



    @Override
    public void loadlist(String catalogId, String pnum, String url) {
        imodel.getHttpData(catalogId, pnum, url, new OnClick() {
            @Override
            public void Success(List<MovieBean.RetBean.ListBean> list) {
                iview.getShowData(list);
            }
        });
    }
}
