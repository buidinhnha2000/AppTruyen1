package com.coder.nha;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        Fragment selectedFragment = null;
        switch (item.getItemId()){
            case R.id.firstFragment:
                selectedFragment = new FirstFragment();
                break;
            case R.id.secondFragment:
                selectedFragment = new SecondFragment();
                break;
            case R.id.thirdFragment:
                selectedFragment = new ThirdFragment();
                break;
            case R.id.nhaFragment:
                selectedFragment = new NhaFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, selectedFragment).commit();
        return true;
    };
}
