package com.example.activitys;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activitys.intefaces.CategoriesApi;
import com.example.activitys.models.Categories;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    TextView textViewCategories;
    LinearLayout layout;
    List<Button> buscar = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCategories();
    }

    private void showCategories(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://gentle-basin-37116.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create()).build();
        CategoriesApi categoriesApi = retrofit.create(CategoriesApi.class);
        Call<List<Categories>> categoriesCall = categoriesApi.showCategories();
        categoriesCall.enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                try {
                    if(response.isSuccessful()){
                        for (int i = 0; i <= response.body().size(); i++){
                            System.out.println(response.body().get(i).getTipoCategoria());
                            Button button = new Button(getApplicationContext());
                            button.setText(response.body().get(i).getTipoCategoria());
                            listenerButton(button);
                            buscar.add(button);
                            layout = findViewById(R.id.servicios);
                            layout.addView(button);
                        }

                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"ERROR EN LA CONEXION", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void listenerButton(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(button.getText().toString());
            }
        });
    }


    public void siguiente(View view){
        Intent siguiente = new Intent(this,SegundoActivity.class);
        siguiente.putExtra("dato",et1.getText().toString());
        startActivity(siguiente);
    }
}