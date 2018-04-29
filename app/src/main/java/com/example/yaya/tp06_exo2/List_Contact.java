package com.example.yaya.tp06_exo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class List_Contact extends AppCompatActivity  {
    ListView contactlist;
    DbConnect db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__contact);

        contactlist = (ListView) findViewById(R.id.listView1);

        db = new DbConnect(this);

        ArrayList<Contact> contacts = db.getallContact();

        ListViewAdapter contactAdapter = new ListViewAdapter(this, R.layout.list_view, contacts);
        contactlist.setAdapter(contactAdapter);
    }
}
