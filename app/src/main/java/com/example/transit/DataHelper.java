package com.example.transit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Transport.db";
    public static final String TABLE_NAME="Bus_table";
    public static final String Col_1="Name";
    public static final String Col_2="ligne";
    public static final String Col_3="etat";

    public DataHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +" (Name TEXT  PRIMARY KEY AUTOINCREMENT,ligne TEXT,etat TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
