package com.coder.nha.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.coder.nha.R;
import com.coder.nha.TheLoaiActivity;
import com.coder.nha.model.Truyen;
import com.coder.nha.viewholder.TheLoaiViewHolder;
import java.util.List;

public class TheLoaiAdapter extends RecyclerView.Adapter<TheLoaiViewHolder> {
    private List<Truyen> truyen;
    private Context context;


    public TheLoaiAdapter(List<Truyen> truyen, Context context) {
        this.truyen = truyen;
        this.context =context;
    }

    @NonNull
    @Override
    public TheLoaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_theloai, parent,false);
        return new TheLoaiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheLoaiViewHolder holder, int position) {

        Truyen t = truyen.get(position);
        holder.theLoai.setText(t.getTheLoai());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TheLoaiActivity.class);
                intent.putExtra("theloai",truyen.get(position));
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
