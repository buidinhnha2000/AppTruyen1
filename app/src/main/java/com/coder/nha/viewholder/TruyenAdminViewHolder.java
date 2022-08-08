package com.coder.nha.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coder.nha.R;

public class TruyenAdminViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView tenTruyen;

    public TruyenAdminViewHolder(@NonNull View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.imgLinkAnh);
        tenTruyen = itemView.findViewById(R.id.txtTenTruyen);
    }
}
