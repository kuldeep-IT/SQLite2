package com.example.sqlite2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    public static final int VERSION=1;  //version one increment kari devanu; when use a onUpgrade method
    public static final String dbname="mydb";

    public MyHelper(Context context) {
        super ( context,dbname,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE PRODUCTS (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, PRICE REAL)";
        db.execSQL (sql);

        insertData("jam","khatta",244.50,db);
        insertData("bread","chizy",20,db);
        insertData("potato","1 kg",789.97,db);
        insertData("tomato","1  kg",800,db);
        insertData("milk","1 l",749.44,db);

    }

    private void insertData(String name,String description,double price, SQLiteDatabase database)
    {
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("DESCRIPTION",description);
        values.put("PRICE",price);

        database.insert("PRODUCTS",null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //database ma update karvanu hoy te badho code aa section ma and version one increment kari devanu;

    }
}
