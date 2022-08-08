package com.coder.nha.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.coder.nha.InforActivity;
import com.coder.nha.R;
import com.coder.nha.ReadActivity;
import com.coder.nha.model.Truyen;
import com.coder.nha.viewholder.TruyenViewHolder;

import java.util.List;


public class TruyenAdapter extends RecyclerView.Adapter<TruyenViewHolder> {
    private Button btnDTruyen;
    private List<Truyen> truyen;
    private Context context;
    public TruyenAdapter(List<Truyen> truyen, Context context) {
        this.truyen = truyen;
        this.context = context;
    }

    @NonNull
    @Override
    public TruyenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_first, parent, false);
        return new TruyenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TruyenViewHolder holder, int position) {
        Truyen t = truyen.get(position);
        Glide.with(holder.image).load(t.getLinkAnh()).into(holder.image);
        holder.tenTruyen.setText(t.getTenTruyen());
        holder.tenChap.setText(t.getTenChap());
        holder.theLoai.setText(t.getTheLoai());
        holder.tacGia.setText(t.getTacGia());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InforActivity.class);
                intent.putExtra("chitiet",truyen.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return truyen.size();
    }

    public void setTruyen(List<Truyen> truyen) {
        this.truyen = truyen;
         notifyDataSetChanged();
    }
}
