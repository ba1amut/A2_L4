package com.speedsumm.bu.a2_l4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bu on 02.08.2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    ArrayList<News>newsArrayList;

    public MyAdapter(ArrayList<News> newsArrayList) {
        this.newsArrayList = newsArrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView newsHead;
        public TextView newsBody;
//        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            newsHead = (TextView)itemView.findViewById(R.id.newsHead);
            newsBody = (TextView)itemView.findViewById(R.id.newsBody);
//            image= (ImageView)itemView.findViewById(R.id.imageView);
        }
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        holder.newsHead.setText(newsArrayList.get(position).getNewsHead());
        holder.newsBody.setText(newsArrayList.get(position).getNewsBody());
//        holder.image.setImageBitmap(newsArrayList.get(position).getBitmap());

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }
}
