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
import com.example.dell.zhihu.Bean.SpecialBen;
import com.example.dell.zhihu.R;

import java.util.ArrayList;
import java.util.List;

public class SpecialAdapter extends RecyclerView.Adapter {

    List<SpecialBen.DataBean> topStoriesBeans=new ArrayList<>();

    private Context context;

    public SpecialAdapter(List<SpecialBen.DataBean> topStoriesBeans, Context context) {
        this.topStoriesBeans = topStoriesBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.spalial, null);

        return new ViewTwo(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
           ViewTwo viewTwo= (ViewTwo) viewHolder;
           viewTwo.sp_et.setText(topStoriesBeans.get(i).getName());
          viewTwo.sp_title.setText(topStoriesBeans.get(i).getDescription());
          Glide.with(context).load(topStoriesBeans.get(i).getThumbnail()).into(viewTwo.ageview);
    }

    public  void setData(  List<SpecialBen.DataBean> daata){
        topStoriesBeans.addAll(daata);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return topStoriesBeans.size();
    }

    class  ViewTwo extends RecyclerView.ViewHolder {

        private final TextView sp_title;
        private final TextView sp_et;
        private final ImageView ageview;

        public ViewTwo(View itemView) {
            super(itemView);
            sp_title = itemView.findViewById(R.id.sp_title);
            ageview = itemView.findViewById(R.id.ageview);
            sp_et = itemView.findViewById(R.id.sp_et);
        }
    }
}
