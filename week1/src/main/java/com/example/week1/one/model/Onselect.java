package com.example.week1.one.model;

import com.example.week1.one.bean.News;

import java.util.List;


/**
 * Created by dell on 2017/12/2.
 */

public interface Onselect {
    void dataSuccess(List<News.ResultsBean> list);
    void dataError(String s);

}
