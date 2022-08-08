package com.coder.nha.viewholder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coder.nha.R;

public class TruyenANhViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TruyenANhViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imgImgAnh);
    }
}
