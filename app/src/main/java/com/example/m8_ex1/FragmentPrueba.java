package com.example.m8_ex1;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.FragmentManager;

import java.util.Locale;

public class FragmentPrueba extends Fragment {

    SharedPreferences prefs;

    public FragmentPrueba() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View menu = inflater.inflate(R.layout.fragment_prueba, container, false);

        final Button buttonEs = menu.findViewById(R.id.buttonEs);
        buttonEs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                prefs = getContext().getSharedPreferences("Mispreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("comprobanteIdioma", 1);
                editor.commit();
                ((MainActivity)getActivity()).comprobanteIdioma = (prefs.getInt("comprobanteIdiomas", 1));
                ((MainActivity)getActivity()).contadorp++;
                Log.i("LL", String.valueOf(((MainActivity)getActivity()).comprobanteIdioma));
                Save("Es");
                Intent intent = new Intent(getActivity(), Login.class);
                intent.putExtra("comprobanteIdioma", ((MainActivity)getActivity()).comprobanteIdioma);
                intent.putExtra("contadorp", ((MainActivity)getActivity()).contadorp);
                startActivity(intent);
            }
        });

        final Button buttonEn = menu.findViewById(R.id.buttonEn);
        buttonEn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                prefs = getContext().getSharedPreferences("Mispreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("comprobanteIdioma", 2);
                editor.commit();
                ((MainActivity)getActivity()).comprobanteIdioma = (prefs.getInt("comprobanteIdiomas", 2));
                Save("En");
                Intent intent = new Intent(getActivity(), Login.class);
                intent.putExtra("comprobanteIdioma", ((MainActivity)getActivity()).comprobanteIdioma);
                startActivity(intent);
            }
        });

        final Button buttonRes = menu.findViewById(R.id.buttonReset);
        buttonRes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mostrarAlertDialog();
            }
        });
        // Inflate the layout for this fragment
        return menu;
    }

    public void Save(String locale){
        prefs = getContext().getSharedPreferences("Mispreferencias", Context.MODE_PRIVATE);
        final Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = new Locale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Idioma", locale);
        editor.commit();
        refresh();
    }

    public void refresh() {
       Intent intent = (getActivity().getIntent());
       startActivity(intent);
       Fragment Setting = new FragmentPrueba();
       FragmentManager menuManager = getFragmentManager();
       FragmentTransaction menuTransaction = menuManager.beginTransaction();
       menuTransaction.replace(R.id.MenuAndConfigure, Setting);
       menuTransaction.commit();
    }

    public void reset(){
        prefs = getContext().getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
        prefs = getContext().getSharedPreferences("Mispreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.putInt("comprobanteIdioma", 0);
        editor.commit();
        System.exit(2);
        ((MainActivity)getActivity()).comprobanteIdioma = (prefs.getInt("comprobanteIdiomas", 0));
        Intent intent = new Intent(getActivity(), Login.class);
        intent.putExtra("comprobanteIdioma", ((MainActivity)getActivity()).comprobanteIdioma);
        startActivity(intent);
    }

    private void mostrarAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getResources().getString(R.string.textTitleRes));
        builder.setMessage(getResources().getString(R.string.textMessageRes));
        builder.setPositiveButton(getResources().getString(R.string.buttonAlertYes),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reset();
                    }
                });
        builder.setNegativeButton(getResources().getString(R.string.buttonAlertNo),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog dialog = builder.create();
        builder.show();
    }
}