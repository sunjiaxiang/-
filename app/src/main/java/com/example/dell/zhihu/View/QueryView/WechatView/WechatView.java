package com.example.dell.zhihu.View.QueryView.WechatView;

import com.example.dell.zhihu.Bean.WachSearBean;
import com.example.dell.zhihu.Bean.WachrecBean;

import java.util.List;

public interface WechatView {
    void setData(List<WachrecBean.NewslistBean> data);

    void showTat(String s);

    void getSear(List<WachrecBean.NewslistBean> newslist);
}
