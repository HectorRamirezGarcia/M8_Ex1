package com.example.m8_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.SharedLibraryInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    String campoUsername, campoPassword;
    EditText txtUsername, txtPassword;
    int comprobante = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        SharedPreferences preferences = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);

        comprobante = (preferences.getInt("comprobante", 0));

        if (comprobante != 0){
            txtUsername = (EditText) findViewById(R.id.IdUsName);
            txtPassword = (EditText) findViewById(R.id.IdPassword);

            txtUsername.setText(preferences.getString("Username", ""));
            txtPassword.setText(preferences.getString("Password", ""));

            campoUsername = ((EditText) findViewById(R.id.IdUsName)).getText().toString();
            campoPassword = ((EditText) findViewById(R.id.IdPassword)).getText().toString();

            if (campoUsername.equals("admin") && campoPassword.equals("admin")){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
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

}