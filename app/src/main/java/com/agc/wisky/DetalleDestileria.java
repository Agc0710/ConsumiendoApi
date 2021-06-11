package com.agc.wisky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.agc.wisky.Apimanager.RetrofitClient;
import com.agc.wisky.Models.Destilerias;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleDestileria extends AppCompatActivity {

    TextView name;
    TextView date;
    TextView lotes;
    private String slug;
    List<Destilerias>destileria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_destileria);
        Bundle Myint = getIntent().getExtras();
        slug = Myint.getString("slug");
        name = findViewById(R.id.name1);
        date = findViewById(R.id.Date);
        lotes = findViewById(R.id.Lots_count);
        getDestileriaBySlug(slug);


    }

    private void getDestileriaBySlug(String slug) {
        Call<List<Destilerias>> call = RetrofitClient.getInstance().getMyApi().getDestileria(slug);
        call.enqueue(new Callback<List<Destilerias>>() {
            @Override
            public void onResponse(Call<List<Destilerias>> call, Response<List<Destilerias>> response) {
                destileria = response.body();

                name.setText (destileria.get(0).getFecha());
                lotes.setText (destileria.get(0).getLotes());
                date.setText (destileria.get(0).getFecha());


            }


            @Override
            public void onFailure(Call<List<Destilerias>> call, Throwable t) {
                Toast.makeText(DetalleDestileria.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}