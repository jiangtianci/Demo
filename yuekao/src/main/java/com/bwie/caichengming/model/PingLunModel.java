package com.bwie.caichengming.model;

import com.bwie.caichengming.utils.OkHttpUtils;

import okhttp3.Callback;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class PingLunModel implements IPingLunModel {
    @Override
    public void pinglun(Callback callback) {
        OkHttpUtils.getInstance().doGet("http://api.svipmovie.com/front/Commentary/getCommentList.do?mediaId=b6c8438873fd4a0f8880b2def64c6472", callback);
    }
}
