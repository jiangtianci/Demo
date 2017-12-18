package com.bwie.caichengming.model;

import com.bwie.caichengming.bean.Main_Bean;

import rx.Observer;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public interface IRecyModel {
    void recy(Observer<Main_Bean> observer);
}
