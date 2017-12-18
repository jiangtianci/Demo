package com.bwie.caichengming.model;

import com.bwie.caichengming.utils.OkHttpUtils;

import okhttp3.Callback;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class XiangQingModel implements IXiangQingModel {
    @Override
    public void xiangqing(Callback callback) {
        OkHttpUtils.getInstance().doGet("http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=b6c8438873fd4a0f8880b2def64c6472", callback);
    }
}
