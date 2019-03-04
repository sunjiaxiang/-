package com.example.dell.zhihu.model.QueryModel.Wachet;

import com.example.dell.zhihu.AppService;
import com.example.dell.zhihu.Bean.WachSearBean;
import com.example.dell.zhihu.Bean.WachrecBean;
import com.example.dell.zhihu.presenter.Queryde.DaliRecallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WachatModel  {

    public void getData(int page,final DaliRecallBack<WachrecBean> daliRecallBack) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AppService.mudelWach)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AppService appService = retrofit.create(AppService.class);
        Observable<WachrecBean> wachrec = appService.wachrec("52b7ec3471ac3bec6846577e79f20e4c", 10, page);
        wachrec.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WachrecBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WachrecBean wachrecBean) {
                   daliRecallBack.onSuccess(wachrecBean);
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

    public void setData(int pageda, int num, String newText, final DaliRecallBack<WachrecBean> daliRecallBack) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AppService.serar)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        AppService appService = retrofit.create(AppService.class);
                   appService.serar("52b7ec3471ac3bec6846577e79f20e4c",num,pageda,newText)
                           .subscribeOn(Schedulers.io())
                           .observeOn(AndroidSchedulers.mainThread())
                           .subscribe(new Observer<WachrecBean>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(WachrecBean wachSearBean) {
                                    daliRecallBack.onSuccess(wachSearBean);
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
