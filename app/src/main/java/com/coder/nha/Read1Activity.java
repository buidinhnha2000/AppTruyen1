package com.coder.nha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.coder.nha.adapter.TruyenAnhAdapter;
import com.coder.nha.model.Truyen;

import java.util.ArrayList;

public class Read1Activity extends AppCompatActivity {
    private ImageView imgAnh;
    private ImageButton btnRead1;
    private Truyen truyen;
    private TextView tenChap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read1);

        btnRead1 = findViewById(R.id.btnRead1);
        tenChap = findViewById(R.id.txvTenChap);
        imgAnh = findViewById(R.id.imgImgAnh);

        Intent intent = getIntent();
        String TenChap = intent.getStringExtra("tenchap");
        ArrayList<String> ImgAnh = intent.getStringArrayListExtra("imganh");

        tenChap.setText(TenChap);

        RecyclerView recyclerView = findViewById(R.id.recy_theloai1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new TruyenAnhAdapter(ImgAnh));

        btnRead1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });
    }
}
