package com.example.cherry.exampledb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cherry.exampledb.Rdatabase.Rtable;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Viewholder> {
    Context ct;
    List<Rtable> list;

    public MyAdapter(Context ct, List<Rtable> list) {
        this.ct = ct;
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(ct).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.roll.setText(list.get(position).getRoll());
        holder.number.setText(list.get(position).getNumber());
        /*This is to delete the live data from the room database*/
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viewModel.delete(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
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
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewGroup viewGroup = v.findViewById(R.id.content);
                    View view = LayoutInflater.from(ct).inflate(R.layout.update,viewGroup,false);
                    final EditText n = view.findViewById(R.id.name);
                    final EditText r = view.findViewById(R.id.roll);
                    final EditText num = view.findViewById(R.id.number);
                    Button update = view.findViewById(R.id.update);
                    Button cancel = view.findViewById(R.id.cancel);
                    final BottomSheetDialog dialog = new BottomSheetDialog(ct);
                    dialog.setContentView(view);
                    dialog.setCancelable(false);

                    n.setText(name.getText().toString());
                    r.setText(roll.getText().toString());
                    r.setEnabled(false);
                    num.setText(number.getText().toString());

                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Rtable rtable = new Rtable();
                            rtable.setName(n.getText().toString());
                            rtable.setRoll(r.getText().toString());
                            rtable.setNumber(num.getText().toString());
                            MainActivity.viewModel.update(rtable);
                            Toast.makeText(ct, "Data Updated", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            });
        }
    }
}
