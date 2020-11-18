package com.example.m8_ex1;

import android.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class ViewIn extends Fragment {
    int i = 0;


    public ViewIn(){

    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View listIncidencia = inflater.inflate(R.layout.item_list_in, container, false);

        Cursor res = (((MainActivity)getActivity()).dbHelper.getAllData());

        ((MainActivity)getActivity()).list.clear();

        while (res.moveToNext()){
            ((MainActivity)getActivity()).list.add( new Listar(res.getString(0), res.getString(1), res.getString(2)));
            }

        RecyclerView recyclerView = (RecyclerView)listIncidencia.findViewById(R.id.RecyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(listIncidencia.getContext()));

        AdapterIn adapter = new AdapterIn(((MainActivity)getActivity()).list);

        recyclerView.setAdapter(adapter);
        return listIncidencia;
    }
}
