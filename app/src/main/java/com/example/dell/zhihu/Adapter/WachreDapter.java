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
import com.example.dell.zhihu.Bean.Hot;
import com.example.dell.zhihu.Bean.WachrecBean;
import com.example.dell.zhihu.R;

import java.util.ArrayList;
import java.util.List;

public class WachreDapter extends RecyclerView.Adapter {
    private Context context;
public  List<WachrecBean.NewslistBean> newslistBeans=new ArrayList<>();
    private setOnCLongitnerrer onClitnerer;

    public WachreDapter(List<WachrecBean.NewslistBean> newslistBeans, Context context) {
        this.newslistBeans = newslistBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wachild, null);
        return new ViewTwo(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
       ViewTwo viewTwo= (ViewTwo) viewHolder;
      viewTwo.te_dase.setText(newslistBeans.get(i).getDescription());
      viewTwo.wa_title.setText(newslistBeans.get(i).getTitle());
      viewTwo.we_datase.setText(newslistBeans.get(i).getCtime());
      Glide.with(context).load(newslistBeans.get(i).getPicUrl()).into(viewTwo.wa_age);
      viewTwo.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              onClitnerer.setOnCLitenrr(v,i);
          }
      });
    }

    public  void setData(List<WachrecBean.NewslistBean> daata){
        newslistBeans.addAll(daata);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return newslistBeans.size();
    }

    class  ViewTwo extends RecyclerView.ViewHolder {

        private final TextView wa_title;
        private final TextView te_dase;
        private final TextView we_datase;
        private final ImageView wa_age;

        public ViewTwo(View itemView) {
            super(itemView);
            wa_title = itemView.findViewById(R.id.wa_title);
            te_dase = itemView.findViewById(R.id.te_dase);
            we_datase = itemView.findViewById(R.id.we_datase);
            wa_age = itemView.findViewById(R.id.wa_age);
        }
    }
      public interface setOnCLongitnerrer{
              void  setOnCLitenrr(View view,int postition);
            }
            public  void  setOnClitnerer(setOnCLongitnerrer onClitnerer){
              this.onClitnerer=onClitnerer;
            }
}
