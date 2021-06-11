package com.agc.wisky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.agc.wisky.Apimanager.RetrofitClient;
import com.agc.wisky.Models.Destilerias;
import com.agc.wisky.Models.Wiskeys;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class destilerialistview extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listDestileria;
    List<Destilerias>myDestileria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destilerialistview);
        listDestileria = findViewById(R.id.ListaDestileria);
        getFromInternetDestileria();
        listDestileria.setOnItemClickListener(this);
    }

    private void getFromInternetDestileria() {
        Call<List<Destilerias>> calldestileria = RetrofitClient.getInstance().getMyApi().getDestileria();
        calldestileria.enqueue(new Callback<List<Destilerias>>() {
            @Override
            public void onResponse(Call<List<Destilerias>> call, Response<List<Destilerias>> response) {
                myDestileria= response.body();
                String message= "";
                AdapterDestileria Adapter = new AdapterDestileria(destilerialistview.this,myDestileria);
                listDestileria.setAdapter(Adapter);
            }

            @Override
            public void onFailure(Call<List<Destilerias>> call, Throwable t) {
                Toast.makeText(destilerialistview.this, "Error no funciona", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent Myint = new Intent(this, DetalleDestileria.class );
        Myint.putExtra("slug", myDestileria.get(position).getSlugDestileria());

        startActivity(Myint);
    }
}