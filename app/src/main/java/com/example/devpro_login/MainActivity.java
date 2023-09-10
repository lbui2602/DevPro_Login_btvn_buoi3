package com.example.devpro_login;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvRegister;
    Button btnLogin;
    EditText edtUsername,edtPassword;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRegister=findViewById(R.id.tvRegister);
        btnLogin=findViewById(R.id.btnLogin);
        edtUsername=findViewById(R.id.edtUsernameLogin);
        edtPassword=findViewById(R.id.edtPasswordLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Home.class);
                String str=edtUsername.getText().toString()+"\nMật khẩu của bạn là: "+edtPassword.getText().toString();
                intent.putExtra("tk",str);
                startActivity(intent);
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Register.class);
                goToRegister.launch(intent);
            }
        });

    }
    ActivityResultLauncher<Intent> goToRegister = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==78){
                        Intent intent1= result.getData();
                        User user= (User)intent1.getSerializableExtra("lbui");


                        if(user !=null){
                            edtUsername.setText(user.getUsername().toString());
                            edtPassword.setText(user.getPassword());
                        }
                        else{
                            edtUsername.setText("1234");
                        }
                        Toast.makeText(MainActivity.this, "Dang ki thanh cong", Toast.LENGTH_SHORT).show();
                    }
                    if(result.getResultCode()==RESULT_CANCELED){
                        Toast.makeText(MainActivity.this, "Dang ki khong thanh cong!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
}