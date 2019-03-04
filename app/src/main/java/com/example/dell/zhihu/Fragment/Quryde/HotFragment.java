package com.example.dell.zhihu.Fragment.Quryde;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dell.zhihu.Adapter.HotAdapter;
import com.example.dell.zhihu.Bean.Hot;
import com.example.dell.zhihu.R;
import com.example.dell.zhihu.View.QueryView.HotView;
import com.example.dell.zhihu.presenter.Queryde.HotPresenter;

import java.util.ArrayList;
import java.util.List;

public class HotFragment extends Fragment implements HotView {
    private View view;
    private RecyclerView mHotRe;
    private HotPresenter hotPresenter;
    private HotAdapter hotAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hotlay, null);
        initView(inflate);
        hotPresenter = new HotPresenter(this);
        getData();
        return inflate;
    }

    private void getData() {
        hotPresenter.getData();
    }

    private void initView(View inflate) {
        mHotRe = (RecyclerView) inflate.findViewById(R.id.hotRe);
        List<Hot.RecentBean> topStoriesBeans=new ArrayList<>();
        hotAdapter = new HotAdapter(topStoriesBeans,getContext());
        mHotRe.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mHotRe.setAdapter(hotAdapter);

    }

    @Override
    public void setData(List<Hot.RecentBean> recent) {
        hotAdapter.setData(recent);
    }

    @Override
    public void shotwTaad(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_LONG).show();
    }
}
