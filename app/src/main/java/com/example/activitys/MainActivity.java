package com.example.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= (EditText) findViewById(R.id.nombre);
    }

    public void siguiente(View view){
        Intent siguiente = new Intent(this,SegundoActivity.class);
        siguiente.putExtra("dato",et1.getText().toString());
        startActivity(siguiente);
    }
}