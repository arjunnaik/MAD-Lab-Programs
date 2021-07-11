package com.example.madlab03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText etUsername, etPassword;

    public void signUp(View view) {
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        if (username.length() > 15 || username.length() < 8) {
            etUsername.setError("Password should be less than 15 and more than 8 characters in length.");
        } else if (password.length() > 15 || password.length() < 8) {
            etPassword.setError("Password should be less than 15 and more than 8 characters in length.");
        } else if (!password.matches(upperCaseChars)) {
            etPassword.setError("Password should contain atleast one upper case alphabet");
        } else if (!password.matches(lowerCaseChars)) {
            etPassword.setError("Password should contain atleast one lower case alphabet");
        } else if (!password.matches(numbers)) {
            etPassword.setError("Password should contain atleast one number.");

        } else if (!password.matches(specialChars)) {
            etPassword.setError("Password should contain atleast one special character");
        } else {
            Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("password", password);
            startActivity(intent);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etPassword = findViewById(R.id.etPassword);
        etUsername = findViewById(R.id.etUsername);


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}