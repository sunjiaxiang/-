package com.example.dell.zhihu.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.zhihu.Bean.DaliBaner;
import com.example.dell.zhihu.Bean.Hot;
import com.example.dell.zhihu.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HotAdapter extends RecyclerView.Adapter {


 List<Hot.RecentBean> topStoriesBeans=new ArrayList<>();

    private Context context;

    public HotAdapter(List<Hot.RecentBean> topStoriesBeans, Context context) {
        this.topStoriesBeans = topStoriesBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View inflate = LayoutInflater.from(context).inflate(R.layout.dalirx, null);
            ViewTwo viewTwo = new ViewTwo(inflate);
            return viewTwo;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ViewTwo viewTwo = (ViewTwo) viewHolder;
        Glide.with(context).load(topStoriesBeans.get(i).getThumbnail()).into(viewTwo.dalirx_age);
        viewTwo.dalirx_te.setText(topStoriesBeans.get(i).getTitle());

    }

   public  void setData( List<Hot.RecentBean> daata){
          topStoriesBeans.addAll(daata);
          notifyDataSetChanged();
   }
    @Override
    public int getItemCount() {
        return topStoriesBeans.size();
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

}
