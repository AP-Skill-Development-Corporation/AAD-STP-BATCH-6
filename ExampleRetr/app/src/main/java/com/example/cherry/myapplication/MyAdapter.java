package com.example.cherry.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context ct;
    ArrayList<Pojo> list;
    public MyAdapter(MainActivity mainActivity, ArrayList<Pojo> list) {
        ct = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ct).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getTitle());
        Picasso.with(ct).load(list.get(position).getUrltoimage()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv;
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            Intent i = new Intent(ct,DisplayActivity.class);
            i.putExtra("name",list.get(pos).getName());
            i.putExtra("author",list.get(pos).getAuthor());
            i.putExtra("title",list.get(pos).getTitle());
            i.putExtra("desc",list.get(pos).getDesc());
            i.putExtra("link",list.get(pos).getUrltoimage());
            i.putExtra("date",list.get(pos).getDate());
            ct.startActivity(i);
        }
    }
}
