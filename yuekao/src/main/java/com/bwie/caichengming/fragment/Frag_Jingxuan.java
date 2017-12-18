package com.bwie.caichengming.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.caichengming.R;
import com.bwie.caichengming.adapter.MyRecyAdapter;
import com.bwie.caichengming.bean.Main_Bean;
import com.bwie.caichengming.presenter.RecyPresenter;
import com.bwie.caichengming.view.IRecyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.导演 on 2017/11/23.
 */

public class Frag_Jingxuan extends Fragment implements IRecyView{

    private View view;
    private Banner banner;
    private XRecyclerView xrv;
    private RecyPresenter recyPresenter;
    private MyRecyAdapter myRecyAdapter;
    private List<String> list_Banner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.jingxuan_frag, null);

        initView();

        recyPresenter = new RecyPresenter(this);
        recyPresenter.showRecy();

        return view;
    }

    private void initView() {
        banner = view.findViewById(R.id.banner);
        xrv = view.findViewById(R.id.xrv);
    }

    @Override
    public void showRecy(Main_Bean main_bean) {
        list_Banner = new ArrayList<>();
        for (int i = 0; i < main_bean.getRet().getHotSearchList().size(); i++) {
            list_Banner.add(main_bean.getRet().getList().get(0).getChildList().get(i).getPic());
        }
        banner.setImages(list_Banner);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        banner.start();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv.setLayoutManager(linearLayoutManager);
        myRecyAdapter = new MyRecyAdapter(getActivity(), main_bean);
        xrv.setAdapter(myRecyAdapter);


    }
}
