package com.coder.nha;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView mtxtDN, mtxtPassword, regiter, txtNha, btnOut;
    private Button btnDN;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mtxtDN = findViewById(R.id.txtDN);
        mtxtPassword = findViewById(R.id.txtPassword);
        btnDN = findViewById(R.id.btnDN);
        mAuth = FirebaseAuth.getInstance();
        btnOut = findViewById(R.id.btnOut);
        regiter = findViewById(R.id.regiter);
        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });

        regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegiterActivity.class);
                startActivity(intent);
            }
        });
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtDN = mtxtDN.getText().toString().trim();
                String txtPassword = mtxtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(txtDN)) {
                    mtxtDN.setError("Ten is required");
                    return;
                }
                if (TextUtils.isEmpty(txtPassword)) {
                    mtxtPassword.setError("Pass is required");
                    return;
                }
                if (txtPassword.length() < 6) {
                    mtxtPassword.setError("Pass < 6 Charracter");
                    return;
                }
                mAuth.signInWithEmailAndPassword(txtDN, txtPassword)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                                }
                                if (txtDN.equals("buinha") && txtPassword.equals("buinha1")) {
                                    startActivity(new Intent(getApplicationContext(), AdminActivity.class));
                                    Toast.makeText(LoginActivity.this, "Chào mừng bạn với tài khoản Admin", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}