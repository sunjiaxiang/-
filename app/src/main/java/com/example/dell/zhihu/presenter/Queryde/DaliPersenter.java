package com.example.dell.zhihu.presenter.Queryde;

import com.example.dell.zhihu.Bean.DaliBaner;
import com.example.dell.zhihu.View.QueryView.DaliView;
import com.example.dell.zhihu.model.QueryModel.DaliModel;

public class DaliPersenter {
    private DaliView daliView;
    private final DaliModel daliModel;

    public DaliPersenter(DaliView daliView) {
        this.daliView = daliView;
        daliModel = new DaliModel();
    }

    public void getData() {
        daliModel.getData(new DaliRecallBack<DaliBaner>() {
            @Override
            public void onSuccess(DaliBaner data) {
             if (data!=null&&data.getTop_stories().size()>0){
                 daliView.getData(data);
             }
            }

            @Override
            public void onFlie(String s) {
                daliView.showTosw(s);
            }

        });
    }
}
