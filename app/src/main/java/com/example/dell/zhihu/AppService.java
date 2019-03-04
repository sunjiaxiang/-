package com.example.dell.zhihu;

import com.example.dell.zhihu.Bean.DaliBaner;
import com.example.dell.zhihu.Bean.Hot;
import com.example.dell.zhihu.Bean.SpecialBen;
import com.example.dell.zhihu.Bean.ThemBean;
import com.example.dell.zhihu.Bean.ThemenBeand;
import com.example.dell.zhihu.Bean.WachSearBean;
import com.example.dell.zhihu.Bean.WachrecBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AppService {
//    http://news-at.zhihu.com/api/4/
//    http://news-at.zhihu.com/api/4/news/hot
    String dafrr="  http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<DaliBaner> daliBean();
    @GET("news/hot")
    Observable<Hot> hotBean();
    @GET("sections")
    Observable<SpecialBen> SpaanBean();

//    http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1
    String mudelWach="http://api.tianapi.com/";
    @GET("wxnew/")
    Observable<WachrecBean> wachrec(@Query("key")String key,@Query("num") int num,@Query("page")int page);
//    http://api.shujuzhihui.cn/api/news/list?appKey=0b87b41aa190445caa7d34154882d74b
//    http://api.shujuzhihui.cn/api/news/list?appKey=0b87b41aa190445caa7d34154882d74b
    String  mhow="http://api.shujuzhihui.cn/";
    @POST("api/news/list")
    Observable<ThemBean> themn(@Query("appKey")String appKey);
//    http://api.shujuzhihui.cn/api/news/detail?appKey=0b87b41aa190445caa7d34154882d74b&newsId=3b0c9148bceb5e17d2beb00749d5dd6d
    String murl="http://api.shujuzhihui.cn/api/";
    @POST("news/detail")
    @FormUrlEncoded
    Observable<ThemenBeand> bdada(@Field("appKey")String appKey,@Field("newsId")String newsId);
//    http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1
    String serar="http://api.tianapi.com/";
    @POST("wxnew/")
    @FormUrlEncoded
    Observable<WachrecBean> serar(@Field("key")String key,@Field("num")int num,@Field("page")int page,@Field("word")String word);
}
