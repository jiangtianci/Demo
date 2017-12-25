package com.example.gouwuche.model;
import com.example.gouwuche.bean.DatasBean;
import com.example.gouwuche.bean.MessageBean;
import com.example.gouwuche.persenter.NewsPresenter;
import com.example.gouwuche.utils.RetrofitUtils;

import java.util.List;
import io.reactivex.Flowable;
public class NewsModel implements Imodel {
    private NewsPresenter presenter;
    public NewsModel(NewsPresenter presenter) {
        this.presenter = (NewsPresenter) presenter;
    }
    @Override
    public void getData(String uid, String pid) {
        Flowable<MessageBean<List<DatasBean>>> flowable = RetrofitUtils.getInstance().getApiService().getDatas(uid);
        presenter.getNews(flowable);
    }
}