package com.example.yaya.tp06_exo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editname,editemail,editphone;
    DbConnect db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editname=(EditText)findViewById(R.id.editname);
        editphone=(EditText)findViewById(R.id.editphone);
        editemail=(EditText)findViewById(R.id.editemail);
        db = new DbConnect(this);


    }

    public void save(View view) {
        String name = editname.getText().toString();
        String phone =editphone.getText().toString();
        String email = editemail.getText().toString();
        Contact contact = new Contact(name, phone,email);
        db.addContact(contact);
        Toast.makeText(this, "added Contact", Toast.LENGTH_LONG).show();



    }

    public void show(View view) {
        Intent list_contact=new Intent(this,List_Contact.class);
        startActivity(list_contact);

    }
}
