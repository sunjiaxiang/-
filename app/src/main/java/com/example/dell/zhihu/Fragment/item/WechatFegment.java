package com.example.dell.zhihu.Fragment.item;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.example.dell.zhihu.Adapter.WachreDapter;
import com.example.dell.zhihu.Bean.WachSearBean;
import com.example.dell.zhihu.Bean.WachrecBean;
import com.example.dell.zhihu.Main2Activity;

import com.example.dell.zhihu.R;
import com.example.dell.zhihu.View.QueryView.WechatView.WechatView;
import com.example.dell.zhihu.presenter.Queryde.wach.WachatPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WechatFegment extends Fragment implements WechatView {
    private View view;
    private XRecyclerView mWawchaXre;
    private WachatPresenter wachatPresenter;
    int page = 1;
    private WachreDapter wachreDapter;
    private SearchView searchView;
    int pageda = 1;
    int num = 10;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.wawchlay, null);
        wachatPresenter = new WachatPresenter(this);
        initView(inflate);
        getData();
        return inflate;
    }

    private void getData() {
        wachatPresenter.getData(page);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menue, menu);
        searchView = (SearchView) menu.findItem(R.id.ited).getActionView();
        //搜索图标是否显示在搜索框内
        searchView.setIconifiedByDefault(true);
        //设置搜索框展开时是否显示提交按钮，可不显示
        searchView.setSubmitButtonEnabled(true);
        // 让键盘的回车键设置成搜索
        searchView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        // 搜索框是否展开，false表示展开
        searchView.setIconified(true);
        // 获取焦点
        searchView.setFocusable(true);
        searchView.requestFocusFromTouch();
        // 设置提示词
        searchView.setQueryHint("请输入关键字");
        //监听输入框输入，点击搜索按钮的信息
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                wachatPresenter.setData(pageda, num, query);
                return false;
            }

            //监听输入框搜索的每个字
            @Override
            public boolean onQueryTextChange(String newText) {

                return true;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void initView(View inflate) {
        mWawchaXre = (XRecyclerView) inflate.findViewById(R.id.wawcha_xre);
        final List<WachrecBean.NewslistBean> newslistBeans = new ArrayList<>();
        wachreDapter = new WachreDapter(newslistBeans, getContext());
        mWawchaXre.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mWawchaXre.setAdapter(wachreDapter);
        wachreDapter.setOnClitnerer(new WachreDapter.setOnCLongitnerrer() {
            @Override
            public void setOnCLitenrr(View view, int postition) {
                Intent intent = new Intent(getContext(), Main2Activity.class);
                intent.putExtra("url", newslistBeans.get(postition).getUrl());
                intent.putExtra("title", newslistBeans.get(postition).getTitle());
                startActivity(intent);
            }
        });
    }


    @Override
    public void setData(List<WachrecBean.NewslistBean> data) {
        wachreDapter.setData(data);
    }

    @Override
    public void showTat(String s) {

    }

    @Override
    public void getSear(List<WachrecBean.NewslistBean> newslist) {
        wachreDapter.newslistBeans.clear();
        wachreDapter.setData(newslist);
    }
}
