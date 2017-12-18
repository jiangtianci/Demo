package com.bwie.caichengming.presenter;

import com.bwie.caichengming.bean.XiangQing_Bean;
import com.bwie.caichengming.model.IXiangQingModel;
import com.bwie.caichengming.model.XiangQingModel;
import com.bwie.caichengming.utils.OnUiCallback;
import com.bwie.caichengming.view.IXiangQingView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class XiangQingPresenter {

    private IXiangQingView xiangQingView;
    private IXiangQingModel xiangQingModel;

    public XiangQingPresenter(IXiangQingView xiangQingView) {
        this.xiangQingView = xiangQingView;
        xiangQingModel = new XiangQingModel();
    }

    public void showXiangQing(){
        xiangQingModel.xiangqing(new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) throws IOException {
                Gson gson = new Gson();
                XiangQing_Bean xiangQing_bean = gson.fromJson(result, XiangQing_Bean.class);
                xiangQingView.showXiagnQing(xiangQing_bean);
            }
        });
    }
}
