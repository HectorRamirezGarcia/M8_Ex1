package com.example.m8_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.m8_ex1.DB.IncidenciaContract;
import com.example.m8_ex1.DB.IncidenciaDBHelper;

import java.util.ArrayList;

import static com.example.m8_ex1.DB.IncidenciaContract.IncidenciaEntry.COLUMN_NAME_TITLE;
import static com.example.m8_ex1.DB.IncidenciaContract.IncidenciaEntry.COLUMN_NAME_TITLE_SPINNER;
import static com.example.m8_ex1.DB.IncidenciaContract.IncidenciaEntry.TABLE_NAME;

public class MainActivity extends AppCompatActivity{

    //protected ArrayList<String> listaIn;
    //protected ArrayList<String> listaSpinner;
    protected ArrayList<Incidencia> list;
    protected ArrayList<Incidencia> listcomprobante;
    protected int comprobante = 0;
    protected IncidenciaDBHelper dbHelper;
    protected SQLiteDatabase db;

    protected static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            TABLE_NAME + "(" + IncidenciaContract.IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME_TITLE+ " TEXT UNIQUE, "+ COLUMN_NAME_TITLE_SPINNER  + "TEXT UNIQUE );";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new IncidenciaDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        //listaIn = new ArrayList<String>();
        //listaSpinner = new ArrayList<String>();

        list = new ArrayList<Incidencia>();

        /*
        Bundle bundle = new Bundle();

        bundle.putSerializable("listaIn", listaIn);
        bundle.putSerializable("listaSpinner", listaSpinner);
        bundle.putSerializable("list", list);
        bundle.putSerializable("comprobante", comprobante);
        */

    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }


}