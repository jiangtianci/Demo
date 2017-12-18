package com.bwie.caichengming.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.caichengming.R;
import com.bwie.caichengming.bean.XiangQing_Bean;
import com.bwie.caichengming.presenter.XiangQingPresenter;
import com.bwie.caichengming.view.IXiangQingView;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class Frag_jianjie extends Fragment implements IXiangQingView{

    private View view;
    private TextView tv_return;
    private XiangQingPresenter xiangQingPresenter;
    private TextView tv_jianjie;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.jianjie_frag, null);

        tv_jianjie = view.findViewById(R.id.tv_jianjie);
        //tv_return = view.findViewById(R.id.tv_return);
//        tv_return.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onDestroy();
//            }
//        });
        xiangQingPresenter = new XiangQingPresenter(this);
        xiangQingPresenter.showXiangQing();

        return view;
    }

    @Override
    public void showXiagnQing(XiangQing_Bean xiangQing_bean) {
        tv_jianjie.setText(xiangQing_bean.getRet().getDescription());
    }
}
