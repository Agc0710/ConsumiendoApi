package com.agc.wisky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends  AppCompatActivity implements View.OnClickListener{

    private ImageButton btnDestileria;
    private ImageButton btnWhiskey;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnWhiskey = findViewById(R.id.btnWhiskeys);
        btnDestileria = findViewById(R.id.btnDestileria);
        btnWhiskey.setOnClickListener(this);
        btnDestileria.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnDestileria){
            Intent Myintent = new Intent(this, destilerialistview.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnWhiskeys){
            Intent Myintent = new Intent(this, whiskey_listView.class );
            startActivity(Myintent);
        }
    }
}