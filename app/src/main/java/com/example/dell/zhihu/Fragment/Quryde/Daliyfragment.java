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
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.zhihu.Adapter.DaliAdapter;
import com.example.dell.zhihu.Bean.DaliBaner;
import com.example.dell.zhihu.R;
import com.example.dell.zhihu.View.QueryView.DaliView;
import com.example.dell.zhihu.presenter.Queryde.DaliPersenter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class Daliyfragment extends Fragment implements DaliView {
    private View view;
    private Banner mDaliband;
    /**
     * 今日热问
     */
    private TextView mDaliXt;
    private RecyclerView mDaliRex;
    private DaliPersenter daliPersenter;
    private DaliAdapter daliAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.laydaliyfragmen, null);
        daliPersenter = new DaliPersenter(this);
        initView(inflate);
        getData();
        return inflate;
    }

    private void getData() {
        daliPersenter.getData();
    }

    private void initView(View inflate) {
        mDaliRex = (RecyclerView) inflate.findViewById(R.id.dali_rex);
        List<DaliBaner.StoriesBean> dat = new ArrayList<>();
        daliAdapter = new DaliAdapter(dat, getContext());
        mDaliRex.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mDaliRex.setAdapter(daliAdapter);
    }




    @Override
    public void showTosw(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_LONG);
    }

    @Override
    public void getData(final DaliBaner data) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                daliAdapter.getData(data.getStories());
                daliAdapter.setData(data.getTop_stories());
            }
        });

    }
}
