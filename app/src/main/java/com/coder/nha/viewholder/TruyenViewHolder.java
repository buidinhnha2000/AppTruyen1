package com.coder.nha.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.coder.nha.R;

public class TruyenViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView tenTruyen;
    public TextView tenChap;
    public TextView tacGia;
    public TextView theLoai;


    public TruyenViewHolder(@NonNull View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.imgLinkAnh);
        tenTruyen = itemView.findViewById(R.id.txtTenTruyen);
        tenChap = itemView.findViewById(R.id.txtTenChap);
        theLoai = itemView.findViewById(R.id.txtTheLoai);
        tacGia = itemView.findViewById(R.id.txtTacGia);


    }
}


