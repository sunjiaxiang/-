package com.example.dell.zhihu.model.QueryModel;

import com.example.dell.zhihu.AppService;
import com.example.dell.zhihu.Bean.ThemBean;
import com.example.dell.zhihu.Bean.ThemenBeand;
import com.example.dell.zhihu.presenter.Queryde.DaliRecallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class THementModel {
    public void getData(final DaliRecallBack<ThemBean> daliRecallBack) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AppService.mhow)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
               .build();
        AppService appService = retrofit.create(AppService.class);
        appService.themn("0b87b41aa190445caa7d34154882d74b")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThemBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ThemBean themBean) {
                   daliRecallBack.onSuccess(themBean);
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


    public void Data(final DaliRecallBack<ThemenBeand> daliRecallBack) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AppService.murl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        AppService appService = retrofit.create(AppService.class);
        Observable<ThemenBeand> bdada = appService.bdada("0b87b41aa190445caa7d34154882d74b", "3b0c9148bceb5e17d2beb00749d5dd6d");
        bdada.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThemenBeand>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ThemenBeand themenBeand) {
                        daliRecallBack.onSuccess(themenBeand);
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
