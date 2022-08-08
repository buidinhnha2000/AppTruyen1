package com.coder.nha.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.coder.nha.R;
import com.coder.nha.model.Truyen;
import com.coder.nha.viewholder.TruyenAdminViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TruyenAdminAdapter extends RecyclerView.Adapter<TruyenAdminViewHolder> {
    private List<Truyen> truyen;
    public TruyenAdminAdapter(List<Truyen> truyen){this.truyen = truyen;}
    @NonNull
    @Override
    public TruyenAdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_admin,parent, false);
        return new TruyenAdminViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TruyenAdminViewHolder holder, int position) {
        Truyen t = truyen.get(position);
        Glide.with(holder.image).load(t.getLinkAnh()).into(holder.image);
        holder.tenTruyen.setText(t.getTenTruyen());
    }

    @Override
    public int getItemCount() {
        return truyen.size();
    }

    public void setTruyen(ArrayList<Truyen> truyen) {
        this.truyen = truyen;
        notifyDataSetChanged();
    }
}
