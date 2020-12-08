package com.example.m8_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.m8_ex1.FragmentPrueba.*;

import java.util.Locale;

public class Login extends AppCompatActivity {
    String campoUsername, campoPassword;
    EditText txtUsername, txtPassword;
    int comprobante = 0, comprobanteIdioma, contadorp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        SharedPreferences preferences = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);

        comprobante = (preferences.getInt("comprobante", 0));

        if (comprobante != 0){
            recibirdatos();
            txtUsername = (EditText) findViewById(R.id.IdUsName);
            txtPassword = (EditText) findViewById(R.id.IdPassword);

            txtUsername.setText(preferences.getString("Username", ""));
            txtPassword.setText(preferences.getString("Password", ""));

            campoUsername = ((EditText) findViewById(R.id.IdUsName)).getText().toString();
            campoPassword = ((EditText) findViewById(R.id.IdPassword)).getText().toString();

            if (campoUsername.equals("admin") && campoPassword.equals("admin")){
                preferences = getSharedPreferences
                        ("Mispreferencias", Context.MODE_PRIVATE);
                comprobanteIdioma = (preferences.getInt("comprobanteIdioma", comprobanteIdioma));
                if (comprobanteIdioma == 1){
                    Save("Es");
                }
                else {
                    Save("En");
                }
            }
        }

        Button buttonlogin = (Button) findViewById(R.id.IdButtonLogin);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                campoUsername = ((EditText) findViewById(R.id.IdUsName)).getText().toString();
                campoPassword = ((EditText) findViewById(R.id.IdPassword)).getText().toString();
                if (campoUsername.equals("admin")&& campoPassword.equals("admin")){
                    guardarPreferancias();
                    logintrue(view);
                }
                else {
                    Toast.makeText(getApplicationContext(), "El usuario introducido o contraseña son incorrectos", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    public void logintrue (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void guardarPreferancias() {
        SharedPreferences preferences = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Username", campoUsername = ((EditText) findViewById(R.id.IdUsName)).getText().toString());
        editor.putString("Password", campoPassword = ((EditText) findViewById(R.id.IdPassword)).getText().toString());
        editor.putInt("comprobante", 1);
        editor.commit();
    }

    public void Save(String locale){
        SharedPreferences preferences = getSharedPreferences
                ("Mispreferencias", Context.MODE_PRIVATE);
        final Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = new Locale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Idioma", locale);
        editor.commit();
        refresh();
    }

    public void refresh() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void recibirdatos() {
        contadorp = getIntent().getIntExtra("contadorp", contadorp);
        if (contadorp == 1){
            comprobanteIdioma = getIntent().getIntExtra("comprobanteIdioma", comprobanteIdioma);
            SharedPreferences preferences = getSharedPreferences
                    ("Mispreferencias", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("comprobanteIdioma", comprobanteIdioma);
            editor.commit();
        }
        if (contadorp == 3){
            comprobanteIdioma = getIntent().getIntExtra("comprobanteIdioma", comprobanteIdioma);
            SharedPreferences preferences = getSharedPreferences
                    ("Mispreferencias", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();
        }
    }
}