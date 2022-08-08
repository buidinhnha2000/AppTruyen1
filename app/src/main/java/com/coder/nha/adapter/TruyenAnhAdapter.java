package com.coder.nha.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.coder.nha.R;
import com.coder.nha.viewholder.TruyenANhViewHolder;

import java.util.List;

public class TruyenAnhAdapter extends RecyclerView.Adapter<TruyenANhViewHolder> {
    private List<String> stringList;
    public TruyenAnhAdapter(List<String> strings) {
        this.stringList = strings;
    }

    @NonNull
    @Override
    public TruyenANhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TruyenANhViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_read1, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TruyenANhViewHolder holder, int position) {
        Glide.with(holder.imageView).load(stringList.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}
