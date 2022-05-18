package com.example.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }
    public void atras(View view){
        Intent atras = new Intent(this, LoginActivity.class);
        startActivity(atras);
    }
    public void servicio(View view){
        Intent servicio = new Intent(this, MainActivity.class);
        startActivity(servicio);
    }
}