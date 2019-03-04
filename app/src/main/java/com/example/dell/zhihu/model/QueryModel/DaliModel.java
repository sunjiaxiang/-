package com.example.dell.zhihu.model.QueryModel;

import android.util.Log;

import com.example.dell.zhihu.AppService;
import com.example.dell.zhihu.Bean.DaliBaner;
import com.example.dell.zhihu.presenter.Queryde.DaliRecallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.constraint.Constraints.TAG;

public class DaliModel {
    public void getData(final DaliRecallBack daliRecallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppService.dafrr)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AppService appService = retrofit.create(AppService.class);
        Observable<DaliBaner> daliBeanObservable = appService.daliBean();
        daliBeanObservable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<DaliBaner>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DaliBaner daliBean) {
                        daliRecallBack.onSuccess(daliBean);
                        Log.i(TAG, "onNext: " + daliBean.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        daliRecallBack.onFlie(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
