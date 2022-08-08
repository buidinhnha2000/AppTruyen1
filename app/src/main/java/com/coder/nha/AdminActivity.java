package com.coder.nha;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.coder.nha.adapter.TruyenAdapter;
import com.coder.nha.adapter.TruyenAdminAdapter;
import com.coder.nha.model.Truyen;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class AdminActivity extends AppCompatActivity {
    public ImageButton btnAd, btNha;
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        recyclerView = findViewById(R.id.rcv_list1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        TruyenAdminAdapter adapter = new TruyenAdminAdapter(Collections.emptyList());
        recyclerView.setAdapter(adapter);

        FirebaseDatabase.getInstance().getReference("Truyen").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    ArrayList<Truyen> truyens = new ArrayList<>();
                    for (DataSnapshot dataSnapshot :
                            snapshot.getChildren()) {
                        truyens.add(dataSnapshot.getValue(Truyen.class));
                    }
                    adapter.setTruyen(truyens);
                }
//
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btNha = findViewById(R.id.btnNha);
        btnAd = findViewById(R.id.btnAd);

        btNha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        btnAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                startActivity(intent);
            }
        });

    }
}
