package com.example.sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        MyHelper helper=new MyHelper(this);
        SQLiteDatabase database=helper.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("PRICE",198.05);

        database.update("PRODUCTS",values,"_id=?",new String[]{"1"});

//        database.delete("PRODUCTS","_id=?",new String[]{"2"});
          database.delete("PRODUCTS","NAME=? AND DESCRIPTION=?",new String[]{"bajaro","deshi"});

        Cursor cursor=database.rawQuery("SELECT NAME,DESCRIPTION,PRICE FROM PRODUCTS",new String[]{});

        if (cursor != null)
        {
            cursor.moveToFirst();
        }

        StringBuilder builder=new StringBuilder();


        do {
            String name = cursor.getString(0);
            String description=cursor.getString(1);
            double price=cursor.getDouble(2);

            builder.append("NAME "+ name + "  DESCRIPTION  "+ description  +" PRICE "+ price + "\n"+ "\n");
        }while (cursor.moveToNext());

        textView=findViewById(R.id.textdata);

        textView.setText(builder.toString());


    }
}
