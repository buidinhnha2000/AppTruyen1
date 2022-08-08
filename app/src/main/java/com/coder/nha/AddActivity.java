package com.coder.nha;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.coder.nha.model.Truyen;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.Collections;

public class AddActivity extends AppCompatActivity {
    public ImageView btnBAdmin;
    EditText txtTenTruyen, imgLinkAnh, txtTenChap, txtTheLoai, txtTacGia,txtDichGia, txtGioiThieu, txtDTruyen, txtLoai, txtLTruyen, imgImgAnh ;
    Button btnAdd;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        txtTenTruyen = findViewById(R.id.txtTenTruyen);
        imgLinkAnh = findViewById(R.id.imgLinkAnh);
        txtTenChap = findViewById(R.id.txtTenChap);
        txtTheLoai = findViewById(R.id.txtTheLoai);
        txtTacGia = findViewById(R.id.txtTacGia);
        txtDichGia = findViewById(R.id.txtDichGia);
        txtGioiThieu = findViewById(R.id.txtGioiThieu);
        txtDTruyen = findViewById(R.id.txtDTruyen);
        txtLoai = findViewById(R.id.txtLoai);
        txtLTruyen = findViewById(R.id.txtLTruyen);
        imgImgAnh = findViewById(R.id.imgImgAnh);

        btnAdd = findViewById(R.id.btnAdd);

        btnBAdmin = findViewById(R.id.btnBAdmin);
        btnBAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen truyen = new Truyen(
                        txtTenTruyen.getText().toString(),
                        imgLinkAnh.getText().toString(),
                        txtTenChap.getText().toString(),
                        txtTheLoai.getText().toString(),
                        txtTacGia.getText().toString(),
                        txtDichGia.getText().toString(),
                        txtGioiThieu.getText().toString(),
                        txtDTruyen.getText().toString(),
                        txtLoai.getText().toString(),
                        txtLTruyen.getText().toString(),
                        Arrays.asList(imgImgAnh.getText().toString().split(" ")),
                        1,
                        0,
                        0
                );
                Log.d("TAG", "onClick: " + truyen.getDichGia());
                FirebaseDatabase.getInstance().getReference().child("Truyen").push().setValue(truyen).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        finish();
                    }
                });
            }
        });
    }
}
