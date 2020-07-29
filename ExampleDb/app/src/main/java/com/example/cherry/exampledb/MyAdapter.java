package com.example.cherry.exampledb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cherry.exampledb.Rdatabase.Rtable;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Viewholder> {
    Context ct;
    ArrayList<Rtable> list;

    public MyAdapter(Context ct, ArrayList<Rtable> list) {
        this.ct = ct;
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(ct).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView name,roll,number;
        ImageButton edit,del;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            roll = itemView.findViewById(R.id.roll);
            number = itemView.findViewById(R.id.number);
            edit = itemView.findViewById(R.id.edit);
            del = itemView.findViewById(R.id.del);

        }
    }
}
