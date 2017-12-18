package com.example.demo.model;

import com.example.demo.bean.Bean;

import java.util.List;


/**
 * Created by dell on 2017/12/5.
 */

public interface Onselect {
    void dataSuccess(List<Bean.SubjectsBean> list);
    void dataError(String s);

}
