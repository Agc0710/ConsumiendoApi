package com.agc.wisky;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.agc.wisky.Models.Wiskeys;

import java.util.List;


public class AdapterWiskey extends BaseAdapter {
    protected Activity activity;
    protected List<Wiskeys> Wiskeys1;

    public AdapterWiskey(Activity activity, List<Wiskeys> wiskeys1) {
        this.activity = activity;
        Wiskeys1 = wiskeys1;
    }

    @Override
    public int getCount() {
        return Wiskeys1.size();
    }

    @Override
    public Object getItem(int position) {
        return Wiskeys1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inf.inflate(R.layout.itemwiskey,null);
        }

        Wiskeys wisky = Wiskeys1.get(position);
        TextView namewisky = vista.findViewById(R.id.Name);
        namewisky.setText(wisky.getNombreWiskey());

        TextView basewisky = vista.findViewById(R.id.Basecurrency);
        basewisky.setText(wisky.getMonedaBase());
        
        return vista;

    }
}
