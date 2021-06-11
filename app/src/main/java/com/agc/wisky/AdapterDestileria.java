package com.agc.wisky;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.agc.wisky.Models.Destilerias;
import com.agc.wisky.Models.Wiskeys;

import java.util.List;

public class AdapterDestileria extends BaseAdapter {
    protected Activity activity;
    protected List<Destilerias> Destileria1;


    public  AdapterDestileria(Activity activity, List<Destilerias> Destileria1) {
        this.activity = activity;
        this.Destileria1 = Destileria1;
    }

    @Override
    public int getCount() {
        return Destileria1.size();
    }

    @Override
    public Object getItem(int position) {
        return Destileria1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista1 = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista1 = inf.inflate(R.layout.itemdistelliri,null);
        }

        Destilerias destileria = Destileria1.get(position);
        TextView nameDestileria = vista1.findViewById(R.id.name);
        nameDestileria.setText(destileria.getNombreDestileria());

        TextView slugDestileria= vista1.findViewById(R.id.slug);
        slugDestileria.setText(destileria.getSlugDestileria());

        TextView countryDestileria= vista1.findViewById(R.id.country);
        countryDestileria.setText(destileria.getCountryDestileria());

        return vista1;
    }
}
