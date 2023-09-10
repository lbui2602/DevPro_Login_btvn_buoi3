package com.example.devpro_login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView tvChao;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvChao=findViewById(R.id.tvChaoMung);
        Intent intent=getIntent();
        String str=intent.getStringExtra("tk");
        tvChao.setText("Hello "+str);
    }
}