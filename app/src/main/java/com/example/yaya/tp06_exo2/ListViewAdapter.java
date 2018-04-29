package com.example.yaya.tp06_exo2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class ListViewAdapter extends ArrayAdapter<Contact> {
    Context context;
    int resource;
    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(resource,parent,false);
        TextView nom=(TextView)convertView.findViewById(R.id.txtname);
        TextView number=(TextView)convertView.findViewById(R.id.txtphone);
        TextView email=(TextView)convertView.findViewById(R.id.txtemail);
        Contact currentContact=getItem(position);
        nom.setText(currentContact.getName());
        number.setText(String.valueOf(currentContact.getPhone()));
        email.setText(currentContact.getEmail());

        return convertView;

    }
}
