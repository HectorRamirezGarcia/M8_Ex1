package com.example.m8_ex1.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.m8_ex1.DB.IncidenciaContract.*;
import com.example.m8_ex1.*;

import static com.example.m8_ex1.DB.IncidenciaContract.IncidenciaEntry.*;

public class IncidenciaDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "incidencies.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            TABLE_NAME + "(" + IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME_TITLE + " TEXT, "+ COLUMN_NAME_TITLE_SPINNER  + " TEXT );";


    public IncidenciaDBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertIncidencia(SQLiteDatabase db, Incidencia i){
        //Check the bd is open
        if (db.isOpen()){
//Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();
            //Insert the incidence getting all values
            values.put(IncidenciaEntry.COLUMN_NAME_TITLE, i.getNameIn());
            values.put(IncidenciaEntry.COLUMN_NAME_TITLE_SPINNER, i.getSpinner());
            db.insert(TABLE_NAME, null, values);

        }else{
            Log.d("prova","Database is closed");
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

}
