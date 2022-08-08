package com.coder.nha;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coder.nha.adapter.TheLoaiAdapter;
import com.coder.nha.model.Truyen;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.Inflater;


public class SecondFragment extends Fragment {
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_second, container, false);
        recyclerView = v.findViewById(R.id.recy_theloai);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        recyclerView.setHasFixedSize(true);

        TheLoaiAdapter adapter = new TheLoaiAdapter(Collections.emptyList(), requireContext());
        recyclerView.setAdapter(adapter);

        FirebaseDatabase.getInstance().getReference("Truyen").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    ArrayList<Truyen> truyens = new ArrayList<>();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        truyens.add(dataSnapshot.getValue(Truyen.class));
                        Log.d("TAG", "onDataChange: " + dataSnapshot.getValue(Truyen.class).getTheLoai());
                    }
                    adapter.setTruyen(truyens);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
