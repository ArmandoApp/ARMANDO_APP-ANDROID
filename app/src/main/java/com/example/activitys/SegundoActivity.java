package com.example.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        tv1 = (TextView)findViewById(R.id.textView2);
        String date = getIntent().getStringExtra("dato");
        tv1.setText("Hola "+date);
    }
    public void atras(View view){
        Intent atras = new Intent(this,MainActivity.class);
        startActivity(atras);
    }
}