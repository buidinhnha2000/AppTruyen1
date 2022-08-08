package com.coder.nha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coder.nha.model.Truyen;

public class ReadActivity extends AppCompatActivity {
    public ImageButton btnBRead;
    private Truyen truyen;

    private TextView tenChap, dTruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        btnBRead = findViewById(R.id.btnBRead);
        btnBRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish();}
        });

        tenChap = findViewById(R.id.txvTenChap);
        dTruyen = findViewById(R.id.txvDTruyen);

        Intent intent = getIntent();
        String tenChap1 = intent.getStringExtra("tenchap");
        String struyen = intent.getStringExtra("dtruyen");

        tenChap.setText(tenChap1);
        dTruyen.setText(struyen);

    }
}
