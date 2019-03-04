package com.example.dell.zhihu.presenter.Queryde;

import com.example.dell.zhihu.Bean.SpecialBen;
import com.example.dell.zhihu.Fragment.Quryde.Specialfragment;
import com.example.dell.zhihu.View.QueryView.Spaliview;
import com.example.dell.zhihu.model.QueryModel.SpaliaModel;

public class SpaliPresenter {
    private Spaliview specialfragment;
    private final SpaliaModel modefl;

    public SpaliPresenter(Spaliview specialfragment) {
        this.specialfragment = specialfragment;
        modefl = new SpaliaModel();
    }

    public void getData() {
        modefl.getData(new DaliRecallBack<SpecialBen>() {
            @Override
            public void onSuccess(SpecialBen data) {
                 if (data.getData().size()>0&&data!=null){
                     specialfragment.setData(data.getData());
                 }
            }

            @Override
            public void onFlie(String s) {
                   specialfragment.shoTase(s);
            }
        });
    }
}
