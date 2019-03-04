package com.example.dell.zhihu.presenter.Queryde.wach;

import android.webkit.WebView;

import com.example.dell.zhihu.Bean.WachSearBean;
import com.example.dell.zhihu.Bean.WachrecBean;
import com.example.dell.zhihu.Fragment.item.WechatFegment;
import com.example.dell.zhihu.View.QueryView.WechatView.WechatView;
import com.example.dell.zhihu.model.QueryModel.Wachet.WachatModel;
import com.example.dell.zhihu.presenter.Queryde.DaliRecallBack;

import java.util.List;

public class WachatPresenter {
    private WechatView wechatFegment;
    private final WachatModel wachatModel;

    public WachatPresenter(WechatView wechatFegment) {

        this.wechatFegment = wechatFegment;
        wachatModel = new WachatModel();
    }

    public void getData(int page) {
        wachatModel.getData(page,new DaliRecallBack<WachrecBean>() {
            @Override
            public void onSuccess(WachrecBean data) {
                if (data!=null){
                    wechatFegment.setData(data.getNewslist());
                }
            }

            @Override
            public void onFlie(String s) {
              wechatFegment.showTat(s);
            }
        });
    }

    public void setData(int pageda, int num, String newText) {
        wachatModel.setData(pageda,num,newText, new DaliRecallBack<WachrecBean>() {

            @Override
            public void onSuccess(WachrecBean data) {
                if (data!=null&&data.getNewslist().size()>0){
                    List<WachrecBean.NewslistBean> newslist = data.getNewslist();
                    wechatFegment.getSear(newslist);
                }
            }

            @Override
            public void onFlie(String s) {

            }
        });
    }
}
