package com.example.eventbus.model;

import com.example.eventbus.bean.MovieBean;

import java.util.List;

/**
 * Created by 姜天赐 on 2017/12/18.
 */

public interface OnClick {
    void Success(List<MovieBean.RetBean.ListBean> list);
}
