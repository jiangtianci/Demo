package com.example.week1.one.presenter;

import com.example.week1.one.bean.News;
import com.example.week1.one.model.Imodel;
import com.example.week1.one.model.Onselect;
import com.example.week1.one.model.model;
import com.example.week1.one.view.Iview;

import java.util.List;


/**
 * Created by dell on 2017/12/2.
 */

public class presenter {
    Imodel imodel;
    Iview iview;

    public presenter(Iview iview) {
        this.iview = iview;
        imodel = new model();
    }

    public void getOk(String url) {
        imodel.RequestSuccess(url, new Onselect() {
            @Override
            public void dataSuccess(List<News.ResultsBean> list) {
                iview.showSuccess(list);
            }

            @Override
            public void dataError(String s) {

            }
        });


    }


}
