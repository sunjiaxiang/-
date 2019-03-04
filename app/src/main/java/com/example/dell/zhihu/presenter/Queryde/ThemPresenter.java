package com.example.dell.zhihu.presenter.Queryde;

import com.example.dell.zhihu.Bean.ThemBean;
import com.example.dell.zhihu.Bean.ThemenBeand;
import com.example.dell.zhihu.Fragment.Quryde.ThemenFragment;
import com.example.dell.zhihu.View.QueryView.ThementView;
import com.example.dell.zhihu.model.QueryModel.THementModel;

import java.util.List;

public class ThemPresenter {
    private ThementView thementView;
    private final THementModel tHementModel;

    public ThemPresenter(ThementView thementView) {

        this.thementView = thementView;
        tHementModel = new THementModel();
    }

    public void getData() {
        tHementModel.getData(new DaliRecallBack<ThemBean>() {
            @Override
            public void onSuccess(ThemBean data) {
                if (data!=null){
                    List<ThemBean.RESULTBean.NewsListBean> newsList = data.getRESULT().getNewsList();
                    thementView.setData(newsList);
                }
            }

            @Override
            public void onFlie(String s) {
                   thementView.shoteach(s);
            }
        });
    }

    public void data() {
        tHementModel.Data(new DaliRecallBack<ThemenBeand>() {
            @Override
            public void onSuccess(ThemenBeand data) {
                if (data!=null){
                    thementView.Data(data.getRESULT());
                }

            }

            @Override
            public void onFlie(String s) {

            }
        });
    }
}
