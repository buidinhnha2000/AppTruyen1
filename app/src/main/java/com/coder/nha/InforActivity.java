package com.coder.nha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.coder.nha.model.Truyen;

import java.util.ArrayList;
import java.util.List;

public class InforActivity extends AppCompatActivity {

    public Button btnDTruyen;
    private Truyen truyen;
    private ImageView linkAnh, btnBInfor;
    private TextView tenTruyen, tenChap, theLoai, tacGia, dichGia, gioiThieu, loai;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);

        btnBInfor = findViewById(R.id.btnBInfor);
        btnDTruyen = findViewById(R.id.btnDTruyen);
        Truyen truyen = getIntent().getParcelableExtra("chitiet");

        btnBInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {finish(); }
        });

        btnDTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (truyen.getLTruyen().equals("chu")) {
                    Intent intent = new Intent(getApplicationContext(), ReadActivity.class);
                    intent.putExtra("tenchap", truyen.getTenChap());
                    intent.putExtra("dtruyen", truyen.getDTruyen());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                if (truyen.getLTruyen().equals("tranh")){
                    Intent intent = new Intent(getApplicationContext(), Read1Activity.class);
                    intent.putExtra("tenchap", truyen.getTenChap());
                    intent.putStringArrayListExtra("imganh", new ArrayList<>(truyen.getImgAnh()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });

        getInfomation();

        linkAnh = findViewById(R.id.imgLinkAnh);
        tenTruyen = findViewById(R.id.txvTenTruyen);
        tenChap = findViewById(R.id.txvTenChap);
        theLoai = findViewById(R.id.txvTheLoai);
        tacGia = findViewById(R.id.txvTacGia);
        dichGia = findViewById(R.id.txvDichGia);
        loai = findViewById(R.id.txvLoai);
        gioiThieu = findViewById(R.id.txvGioiThieu);

        Glide.with(linkAnh).load(truyen.getLinkAnh()).into(linkAnh);
        tenTruyen.setText(truyen.getTenTruyen());
        tenChap.setText(truyen.getTenChap());
        theLoai.setText(truyen.getTheLoai());
        tacGia.setText(truyen.getTacGia());
        dichGia.setText(truyen.getDichGia());
        loai.setText(truyen.getLoai());
        gioiThieu.setText(truyen.getGioiThieu());
    }
    private void getInfomation() {

    }
}