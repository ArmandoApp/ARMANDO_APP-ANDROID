package com.example.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activitys.intefaces.CategoriesApi;
import com.example.activitys.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SegundoActivity extends AppCompatActivity {

    private LinearLayout layout;
    private List<Button> buttons = new ArrayList<>();
    private TextView titulo;
    private TextView textView;
    private ImageView imageView;
    private String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        dato = getIntent().getStringExtra("category");
        System.out.println(dato);
        titulo = findViewById(R.id.textView6);
        textView = findViewById(R.id.textView2);
        titulo.setText(dato);
        imageView = findViewById(R.id.imageView2);
        if(dato.equals("Carpinteria")){
            textView.setText("Estos son los carpinteros cerca a tu dirección");
            imageView.setImageResource(R.drawable.carpintero2);
        }else if(dato.equals("fontaneria")){
            textView.setText("Estos son los fontaneros cerca a tu dirección");
            imageView.setImageResource(R.drawable.fontanero);
        }else{
            textView.setText("Estos son los mecanicos cerca a tu dirección");
            imageView.setImageResource(R.drawable.mecanismo);
        }
        getCategories(dato);
    }


    private void getCategories(String category){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://gentle-basin-37116.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create()).build();

        CategoriesApi categoriesApi = retrofit.create(CategoriesApi.class);
        Call<List<User>> call = categoriesApi.getCategorias(category);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                try {
                    List<User> users = response.body();
                    if(users.size() > 1){
                        for (User u : users){
                            Button button = new Button(getApplicationContext());
                            button.setText(u.getUsername());
                            listenerButton(button);
                            buttons.add(button);
                            layout = findViewById(R.id.ofertantes);
                            layout.addView(button);
                        }
                    }else {
                        Button button = new Button(getApplicationContext());
                        button.setText("No se encontraron ofertantes distonibles");
                        buttons.add(button);
                        layout = findViewById(R.id.ofertantes);
                        layout.addView(button);
                    }


                }catch (Exception e){
                    Toast.makeText(SegundoActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(SegundoActivity.this,"ERROR EN LA CONEXION", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void listenerButton(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(),TerceraActividad.class);
                siguiente.putExtra("ofertante",button.getText().toString());
                siguiente.putExtra("servicio",dato);
                startActivity(siguiente);
            }
        });
    }


    public void atras(View view){
        Intent atras = new Intent(this,MainActivity.class);
        startActivity(atras);
    }



}