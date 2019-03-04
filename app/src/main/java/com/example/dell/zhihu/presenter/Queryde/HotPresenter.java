package com.example.dell.zhihu.presenter.Queryde;

import com.example.dell.zhihu.Bean.Hot;
import com.example.dell.zhihu.View.QueryView.HotView;
import com.example.dell.zhihu.model.QueryModel.HotModel;

import java.util.List;

public class HotPresenter {
    private HotView hotView;
    private final HotModel hotModel;

    public HotPresenter(HotView hotView) {

        this.hotView = hotView;
        hotModel = new HotModel();
    }

    public void getData() {
        hotModel.getData(new DaliRecallBack<Hot>(){
            @Override
            public void onSuccess(Hot data) {
                  if (data!=null&&data.getRecent().size()>0){
                      List<Hot.RecentBean> recent = data.getRecent();
                      hotView.setData(recent);
                  }
            }

            @Override
            public void onFlie(String s) {
                hotView.shotwTaad(s);
            }
        });
    }
}
