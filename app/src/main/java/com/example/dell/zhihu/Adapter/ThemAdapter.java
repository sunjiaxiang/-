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
import com.example.dell.zhihu.Bean.ThemBean;
import com.example.dell.zhihu.R;

import java.util.ArrayList;
import java.util.List;

public class ThemAdapter extends RecyclerView.Adapter {
    private Context context;
List<ThemBean.RESULTBean.NewsListBean> beans=new ArrayList<>();
    private setOnCLongitnerrer onClitnerer;

    public ThemAdapter(Context context, List<ThemBean.RESULTBean.NewsListBean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.themla, null);
        return new ViewOne(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
      ViewOne viewOne= (ViewOne) viewHolder;
       viewOne.te_xxt.setText(beans.get(i).getTitle());
        Glide.with(context).load(beans.get(i).getNewsImg()).into(viewOne.tehma);
        viewOne.tedata.setText(beans.get(i).getPublishTime());
        viewOne.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClitnerer.setOnCLitenrr(v,i);
            }
        });
    }

    public void setBea(List<ThemBean.RESULTBean.NewsListBean> data) {
       beans.addAll(data);
       notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }
     class  ViewOne extends RecyclerView.ViewHolder {

         private final TextView te_xxt;
         private final ImageView tehma;
         private final TextView tedata;

         public ViewOne(View itemView) {
                 super(itemView);
             tehma = itemView.findViewById(R.id.tehma);
             te_xxt = itemView.findViewById(R.id.te_xxt);
             tedata = itemView.findViewById(R.id.tedata);
         }
         }
     public interface setOnCLongitnerrer{
             void  setOnCLitenrr(View view,int postition);
           }
           public  void  setOnClitnerer(setOnCLongitnerrer onClitnerer){
             this.onClitnerer=onClitnerer;
           }
}
