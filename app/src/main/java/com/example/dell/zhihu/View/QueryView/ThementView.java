package com.example.dell.zhihu.View.QueryView;

import com.example.dell.zhihu.Bean.ThemBean;
import com.example.dell.zhihu.Bean.ThemenBeand;

import java.util.List;

public interface ThementView {
    void setData(List<ThemBean.RESULTBean.NewsListBean> newsList);

    void shoteach(String s);

    void Data(ThemenBeand.RESULTBean result);
}
