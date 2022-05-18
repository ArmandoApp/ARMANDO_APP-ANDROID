package com.example.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TerceraActividad extends AppCompatActivity {

    TextView name;
    TextView category;
    TextView resena;
    TextView precioNum;
    TextView respuestaNum;
    Button siguiente;
    Button atras;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);
        String ofertante = getIntent().getStringExtra("ofertante");
        String servicio = getIntent().getStringExtra("servicio");
        name = findViewById(R.id.Name);
        category = findViewById(R.id.textView6);
        resena = findViewById(R.id.resena);
        respuestaNum = findViewById(R.id.textView11);
        precioNum = findViewById(R.id.textView10);
        name.setText(ofertante);
        category.setText(servicio);
        resena.setText("Trabaja mal, realizo trabajos que no eran, cuando llegue a ver su producto final no era el que yo quería, no lo recomiendo");
        respuestaNum.setText("5 minutos");
        precioNum.setText("50.000 COP/hora");
        siguiente = findViewById(R.id.siguiente);
        atras = findViewById(R.id.atras);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(),PaymentActivity.class);
                siguiente.putExtra("category",servicio);
                startActivity(siguiente);
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(),SegundoActivity.class);
                siguiente.putExtra("category",servicio);
                startActivity(siguiente);
            }
        });

    }
}
