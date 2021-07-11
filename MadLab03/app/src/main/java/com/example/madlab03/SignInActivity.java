package com.example.madlab03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SignInActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
int counter=0;
    public void logIn(View view) throws Exception {
        Intent intent = getIntent();
        String user = etUsername.getText().toString();
        String pass = etPassword.getText().toString();

        if (user.equals(intent.getStringExtra("username")) && pass.equals(intent.getStringExtra("password"))) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();

               Thread.sleep(6000);
               finish();



        } else {
            if (counter==2)
            {
                Toast.makeText(this, "You Tried 2 Times With Wrong Credential!!", Toast.LENGTH_SHORT).show();
                Thread.sleep(3000);
                finish();
            }
            Toast.makeText(this, "Invalid Credentials!!", Toast.LENGTH_SHORT).show();
            counter++;

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPassword = findViewById(R.id.etPassword);
        etUsername = findViewById(R.id.etUsername);
    }
}