package com.agc.wisky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.agc.wisky.Apimanager.RetrofitClient;
import com.agc.wisky.Models.Wiskeys;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleWhiskey extends AppCompatActivity  implements AdapterView.OnClickListener{


    TextView date;
    TextView volumencomercio;
    Button btnweb;
    private String slug;
    private String url;
    List<Wiskeys>whisky;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_whiskey);
        Bundle Myint = getIntent().getExtras();
        slug = Myint.getString("slug");
        Bundle in = getIntent().getExtras();
        url = in.getString("url");



        date = findViewById(R.id.fechafabricacion);
        volumencomercio = findViewById(R.id.Volumenconsumo);

        btnweb = findViewById(R.id.button);

        btnweb.setOnClickListener(this);
        getWhiskyBySlug(slug);


    }

    private void getWhiskyBySlug(String slug){
        Call<List<Wiskeys>> call = RetrofitClient.getInstance().getMyApi().getWiskeys(slug);
        call.enqueue(new Callback<List<Wiskeys>>() {
            @Override
            public void onResponse(Call<List<Wiskeys>> call, Response<List<Wiskeys>> response) {
                whisky = response.body();

                date.setText( whisky.get(0).getDate());
                volumencomercio.setText( whisky.get(0).getVolumenComercio());

            }


            @Override
            public void onFailure(Call<List<Wiskeys>> call, Throwable t) {
                Toast.makeText(DetalleWhiskey.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}