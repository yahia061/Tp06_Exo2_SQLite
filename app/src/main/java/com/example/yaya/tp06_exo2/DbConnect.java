package com.example.yaya.tp06_exo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DbConnect extends SQLiteOpenHelper {
    private static final String Db_name = "Contacts";
    private static final String Table_name = "contact";
    private static final String id_key = "id";
    private static final String name_key = "name";
    private static final String phone_key = "phone";
    private static final String email_key = "email";
    private static final int Version = 1;


    public DbConnect(Context context) {
        super(context, Db_name, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "create table " + Table_name + "(" + id_key + " integer primary key," + name_key + " varchar(30)," + phone_key + " integer," + email_key + " varchar(30))";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String delete_query = "drop table " + Table_name + " IF EXITS";
        db.execSQL(delete_query);
        onCreate(db);
    }

    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(name_key, contact.getName());
        values.put(phone_key, contact.getPhone());
        values.put(email_key, contact.getEmail());
        db.insert(Table_name, null, values);
    }

    public ArrayList<Contact> getallContact() {
        ArrayList<Contact> contacts = new ArrayList<>();
        String select_query = "select * from " + Table_name;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(name_key));
                String phone = cursor.getString(cursor.getColumnIndex(phone_key));
                String email = cursor.getString(cursor.getColumnIndex(email_key));

                Contact contact = new Contact(name, phone, email);
                contacts.add(contact);
            } while (cursor.moveToNext());
        }

        return contacts;

    }


}
