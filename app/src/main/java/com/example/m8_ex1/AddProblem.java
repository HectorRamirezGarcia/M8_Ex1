package com.example.m8_ex1;

import android.app.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.m8_ex1.DB.IncidenciaDBHelper;

/**
 * A simple {@link android.app.Fragment} subclass.
 */

public class AddProblem extends Fragment {

    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase db;

    public AddProblem() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dbHelper = new IncidenciaDBHelper(getContext());
        db = dbHelper.getWritableDatabase();

        // Inflate the layout for this fragment
        final View addIncidencia = inflater.inflate(R.layout.activity_add_problem, container, false);
        final Spinner spinner = addIncidencia.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity().getBaseContext(),
                R.array.numbers,
                android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        final Button btnafegirIncidencia = addIncidencia.findViewById(R.id.btnAdd);
        btnafegirIncidencia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText txtIncidencia = addIncidencia.findViewById(R.id.idTextIncidencia);
                String txtIncidenciaForm = txtIncidencia.getText().toString();
                String txtCategoriaForm = spinner.getSelectedItem().toString();
                Incidencia in = new Incidencia(txtIncidenciaForm, txtCategoriaForm);
                dbHelper.insertIncidencia(db, in);
            }
        });

        return addIncidencia;
    }
}

