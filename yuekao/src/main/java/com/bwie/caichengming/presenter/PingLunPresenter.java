package com.bwie.caichengming.presenter;

import com.bwie.caichengming.bean.PingLun_Bean;
import com.bwie.caichengming.model.IPingLunModel;
import com.bwie.caichengming.model.PingLunModel;
import com.bwie.caichengming.utils.OnUiCallback;
import com.bwie.caichengming.view.IPingLunView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class PingLunPresenter {
    private IPingLunModel pingLunModel;
    private IPingLunView pingLunView;

    public PingLunPresenter(IPingLunView pingLunView) {
        this.pingLunView = pingLunView;
        pingLunModel = new PingLunModel();
    }

    public void showPingLun(){
        pingLunModel.pinglun(new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) throws IOException {
                Gson gson = new Gson();
                PingLun_Bean pingLun_bean = gson.fromJson(result, PingLun_Bean.class);
                pingLunView.showPingLun(pingLun_bean);
            }
        });
    }
}
