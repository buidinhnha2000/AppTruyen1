package com.coder.nha.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coder.nha.R;

public class TheLoaiViewHolder extends RecyclerView.ViewHolder {
    public Button theLoai;

    public TheLoaiViewHolder(@NonNull View itemView) {
        super(itemView);
        theLoai = itemView.findViewById(R.id.btnTheLoai);
    }
}
