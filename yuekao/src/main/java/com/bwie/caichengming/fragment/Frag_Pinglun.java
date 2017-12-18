package com.bwie.caichengming.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.caichengming.R;
import com.bwie.caichengming.bean.PingLun_Bean;
import com.bwie.caichengming.view.IPingLunView;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class Frag_Pinglun extends Fragment implements IPingLunView{

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pinglun_frag, null);
        return view;
    }

    @Override
    public void showPingLun(PingLun_Bean pingLun_bean) {

    }
}
