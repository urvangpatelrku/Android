package com.rku_21soeca21002.exampractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Validation extends AppCompatActivity {

    EditText edtEmail,edtPassword,edtRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtRePassword = findViewById(R.id.edtRePassword);
    }

    public void btnValidation(View view) {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString();
        String repassword = edtRePassword.getText().toString();

        if(email.equals("") || password.equals("") || repassword.equals(""))
        {
            Toast.makeText(this, "Fill all", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.length() != 6)
        {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!password.equals(repassword))
        {
            Toast.makeText(this, "Not Match", Toast.LENGTH_SHORT).show();
            return;
        }

    }
}