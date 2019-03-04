package com.example.dell.zhihu.model.QueryModel;

import com.example.dell.zhihu.AppService;
import com.example.dell.zhihu.Bean.SpecialBen;
import com.example.dell.zhihu.presenter.Queryde.DaliRecallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpaliaModel {
    public void getData(final DaliRecallBack<SpecialBen> daliRecallBack) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AppService.dafrr)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        AppService appService = retrofit.create(AppService.class);
        appService.SpaanBean().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SpecialBen>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SpecialBen specialBen) {
                         daliRecallBack.onSuccess(specialBen);
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
