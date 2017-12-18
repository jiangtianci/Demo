package com.example.demo.persenter;

import com.example.demo.bean.Bean;
import com.example.demo.model.Imodel;
import com.example.demo.model.Model;
import com.example.demo.model.Onselect;
import com.example.demo.view.Iview;

import java.util.List;

/**
 * Created by 姜天赐 on 2017/12/6.
 */

public class Persenter {
    Imodel imodel;
    Iview iview;
    public Persenter(Iview iview) {
        this.iview = iview;
        imodel = new Model();
    }
    public void getOk(String url, int start, int count) {
        imodel.RequestSuccess(url, start, count, new Onselect() {
            @Override
            public void dataSuccess(List<Bean.SubjectsBean> list) {
                iview.showSuccess(list);
            }

            @Override
            public void dataError(String s) {

            }
        });

    }

}
