package com.example.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 实现活动跳转
        Button button_1 = findViewById(R.id.button_1);
        button_1.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, activity_1.class);
            startActivity(intent);
        });

        button_1.setBackgroundColor(Color.argb(100,200, 222,33));

    }
}