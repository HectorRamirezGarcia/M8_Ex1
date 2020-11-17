package com.example.m8_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonlogin = (Button) findViewById(R.id.IdButtonLogin);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String UserName = ((EditText) findViewById(R.id.IdUsName)).getText().toString();
                String Password = ((EditText) findViewById(R.id.IdPassword)).getText().toString();
                if (UserName.equals("admin")&& Password.equals("admin")){
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

}