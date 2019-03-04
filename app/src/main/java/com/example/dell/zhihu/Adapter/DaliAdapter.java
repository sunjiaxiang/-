package com.example.dell.zhihu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.zhihu.Bean.DaliBaner;
import com.example.dell.zhihu.Main2Activity;
import com.example.dell.zhihu.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;


import java.util.ArrayList;
import java.util.List;

public class DaliAdapter extends RecyclerView.Adapter {

List<DaliBaner.StoriesBean> storiesBeans=new ArrayList<>();
 List<DaliBaner.TopStoriesBean> topStoriesBeans=new ArrayList<>();
    int ONE=1;
    int TWO=2;
    private Context context;

    public DaliAdapter(List<DaliBaner.StoriesBean> storiesBeans, Context context) {
        this.storiesBeans = storiesBeans;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0&&storiesBeans.size()>0){
         return ONE;
        }else {
            return TWO;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.dalibann, null);
            ViewOne viewOne = new ViewOne(inflate);
            return viewOne;
        }else if (i==2){
            View inflate = LayoutInflater.from(context).inflate(R.layout.dalirx, null);
            ViewTwo viewTwo = new ViewTwo(inflate);
            return viewTwo;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
    if (viewHolder instanceof ViewOne){
        ViewOne viewOne= (ViewOne) viewHolder;
        List<String >strings=new ArrayList<>();

        for (int j = 0; j < storiesBeans.size(); j++) {
            strings.addAll(storiesBeans.get(j).getImages());
        }
        viewOne.dali_band.setImages(strings);
        viewOne.dali_band.setImageLoader(new Imaglode());
        viewOne.dali_band.isAutoPlay(true);
        viewOne.dali_band.start();

    }else if (viewHolder instanceof ViewTwo){
        ViewTwo viewTwo= (ViewTwo) viewHolder;
        Glide.with(context).load(topStoriesBeans.get(i).getImage()).into(viewTwo.dalirx_age);
        viewTwo.dalirx_te.setText(topStoriesBeans.get(i).getTitle());
    }
    }
   public  void getData(List<DaliBaner.StoriesBean> daata){
          storiesBeans.addAll(daata);
          notifyDataSetChanged();
   } public  void setData( List<DaliBaner.TopStoriesBean> daata){
          topStoriesBeans.addAll(daata);
          notifyDataSetChanged();
   }
    @Override
    public int getItemCount() {
        return topStoriesBeans.size();
    }
     class  ViewOne extends RecyclerView.ViewHolder {

         private final Banner dali_band;

         public ViewOne(View itemView) {
                 super(itemView);
             dali_band = itemView.findViewById(R.id.dali_band);
             }
         }
         class  ViewTwo extends RecyclerView.ViewHolder {

             private final TextView dalirx_te;
             private final ImageView dalirx_age;

             public ViewTwo(View itemView) {
                 super(itemView);
                 dalirx_te = itemView.findViewById(R.id.dalirx_te);
                 dalirx_age = itemView.findViewById(R.id.dalirx_age);
             }
         }

    private class Imaglode extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
