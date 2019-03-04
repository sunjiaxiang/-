package com.example.dell.zhihu.Fragment.Quryde;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.zhihu.Adapter.ThemAdapter;
import com.example.dell.zhihu.Bean.ThemBean;
import com.example.dell.zhihu.Bean.ThemenBeand;
import com.example.dell.zhihu.Main2Activity;
import com.example.dell.zhihu.R;
import com.example.dell.zhihu.View.QueryView.ThementView;
import com.example.dell.zhihu.presenter.Queryde.ThemPresenter;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class ThemenFragment extends Fragment implements ThementView {
    private View view;
    private RecyclerView mRec;
    private ThemPresenter themPresenter;
    private ThemAdapter themAdapter;
    private List<ThemenBeand.RESULTBean> ba;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.laytheme, null);
        themPresenter = new ThemPresenter(this);
        initView(inflate);
        getData();
        data();
        return inflate;
    }

    private void data() {
        themPresenter.data();
    }

    private void getData() {
        themPresenter.getData();
    }

    private void initView(View inflate) {
        ba = new ArrayList<>();
        mRec = (RecyclerView) inflate.findViewById(R.id.threc);
        List<ThemBean.RESULTBean.NewsListBean> newsListBeans=new ArrayList<>();
        themAdapter = new ThemAdapter(getContext(),newsListBeans);
        mRec.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRec.setAdapter(themAdapter);
      themAdapter.setOnClitnerer(new ThemAdapter.setOnCLongitnerrer() {
          @Override
          public void setOnCLitenrr(View view, int postition) {
//              ThemenBeand.RESULTBean resultBean = ba.get(postition);
//              List<String> imgUrl = resultBean.getImgUrl();
//
//              Intent intent=new Intent(getContext(),Main2Activity.class);
//
//              intent.putExtra("title",resultBean.getTitle());
//              startActivity(intent);
          }
      });
    }

    @Override
    public void setData(List<ThemBean.RESULTBean.NewsListBean> newsList) {
        Log.i(TAG, "setData: "+newsList.toString());
        themAdapter.setBea(newsList);
    }

    @Override
    public void shoteach(String s) {

    }

    @Override
    public void Data(ThemenBeand.RESULTBean result) {
        ba.add(result);
    }
}
