package com.coder.nha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegiterActivity extends AppCompatActivity {
    private TextView login, mtxtDN, mtxtPassword, mtxtPassword1;
    private Button btnDK;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter2);
        mtxtDN = findViewById(R.id.txtDN);
        mtxtPassword = findViewById(R.id.txtPassword);
        mtxtPassword1 = findViewById(R.id.txtPassword1);
        mAuth = FirebaseAuth.getInstance();
        login = findViewById(R.id.login);
        btnDK = findViewById(R.id.btnDK);

        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtDN = mtxtDN.getText().toString().trim();
                String txtPassword = mtxtPassword.getText().toString().trim();
                String txtPassword1 = mtxtPassword1.getText().toString().trim();

                if (TextUtils.isEmpty(txtDN)) {
                    mtxtDN.setError("Ten is required");
                    return;
                } if (TextUtils.isEmpty(txtPassword)) {
                    mtxtPassword.setError("Pass is required");
                    return;
                }if (TextUtils.isEmpty(txtPassword1)) {
                    mtxtPassword1.setError("Pass is confirm required");
                    return;
                }
                if (txtPassword.length() < 6) {
                    mtxtPassword.setError("Pass < 6 Charracter");
                    return;
                }
                if (txtPassword.equals(txtPassword1)) {
                    mAuth.createUserWithEmailAndPassword(txtDN, txtPassword)
                            .addOnCompleteListener(RegiterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        Toast.makeText(RegiterActivity.this,"Bạn đã đăng kí thành công", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(RegiterActivity.this,"Không hợp lệ !!!", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
