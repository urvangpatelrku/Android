package com.rku_21soeca21002.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView txtDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtDetails = findViewById(R.id.txtDetails);

        Bundle bundle = getIntent().getExtras();
        String firstname = bundle.getString("firstname");
        String lastname = bundle.getString("lastname");
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        String city = bundle.getString("city");
        String gender = bundle.getString("gender");

        txtDetails.setText("Name: "+firstname+" "+lastname+"\n"
                +"Username: "+username+"\n"
                +"Password: "+password+"\n"
                +"City: "+city+"\n"
                +"Gender: "+gender);
    }
}