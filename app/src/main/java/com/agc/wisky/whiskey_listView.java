package com.agc.wisky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.agc.wisky.Apimanager.RetrofitClient;
import com.agc.wisky.Models.Wiskeys;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class whiskey_listView extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listWiskey;
    List<Wiskeys> mywhiskey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whiskey_list_view);
        listWiskey = findViewById(R.id.ListaWiskey);
        getFromInternetWhiskey();
        listWiskey.setOnItemClickListener(this);

    }
    private void getFromInternetWhiskey(){
        Call<List<Wiskeys>> callwiskey =RetrofitClient.getInstance().getMyApi().getWiskeys();
        callwiskey.enqueue(new Callback<List<Wiskeys>>() {
            @Override
            public void onResponse(Call<List<Wiskeys>> call, Response<List<Wiskeys>> response) {
                mywhiskey= response.body();
                String message= "";
                AdapterWiskey Adapter = new AdapterWiskey(whiskey_listView.this,mywhiskey);
                listWiskey.setAdapter(Adapter);
            }

            @Override
            public void onFailure(Call<List<Wiskeys>> call, Throwable t) {
                Toast.makeText(whiskey_listView.this, "Error no funciona", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent Myint = new Intent(this, DetalleWhiskey.class );
        Myint.putExtra("slug", mywhiskey.get(position).getSlugWiskey());
        Myint.putExtra("url", mywhiskey.get(position).getUrl());
        startActivity(Myint);
    }
}