package com.example.dell.zhihu.Fragment.Quryde;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dell.zhihu.Adapter.SpecialAdapter;
import com.example.dell.zhihu.Bean.SpecialBen;
import com.example.dell.zhihu.R;
import com.example.dell.zhihu.View.QueryView.Spaliview;
import com.example.dell.zhihu.presenter.Queryde.SpaliPresenter;

import java.util.ArrayList;
import java.util.List;

public class Specialfragment extends Fragment implements Spaliview {
    private View view;
    private RecyclerView mRecy;
    private SpaliPresenter spaliPresenter;
    private SpecialAdapter specialAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.specia, null);
        spaliPresenter = new SpaliPresenter(this);
        initView(inflate);
        getData();
        return inflate;
    }

    private void getData() {
        spaliPresenter.getData();
    }

    private void initView(View inflate) {
        mRecy = (RecyclerView) inflate.findViewById(R.id.recy);
        List<SpecialBen.DataBean> dataBeans=new ArrayList<>();
        specialAdapter = new SpecialAdapter(dataBeans,getContext());
        mRecy.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecy.setAdapter(specialAdapter);

     }

    @Override
    public void setData(List<SpecialBen.DataBean> data) {
        specialAdapter.setData(data);
    }

    @Override
    public void shoTase(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_LONG).show();
    }
}
