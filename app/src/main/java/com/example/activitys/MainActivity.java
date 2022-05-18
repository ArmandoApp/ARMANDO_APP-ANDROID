package com.example.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= (EditText) findViewById(R.id.nombre);
        et2= (EditText) findViewById(R.id.passwd);
    }
    public void ingresar(View view){
        Intent ingresar = new Intent(MainActivity.this, MenuActivity.class);
        ingresar.putExtra("dato",et1.getText().toString());
        startActivity(ingresar);
    }
}