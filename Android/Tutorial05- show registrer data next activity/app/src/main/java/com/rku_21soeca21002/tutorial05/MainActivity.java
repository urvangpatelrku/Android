package com.rku_21soeca21002.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button btnRegister;
    TextInputEditText txtFirstname,txtLastname,txtUsername,txtPassword;
    Spinner spinCity;
    RadioGroup rdoGroup;
    RadioButton rdoGender;
    CheckBox checkStatus;
    View rooLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_view();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String valFirstname = txtFirstname.getText().toString().trim();
                String valLastname = txtLastname.getText().toString().trim();
                String valUsername = txtUsername.getText().toString().trim();
                String valPassword = txtPassword.getText().toString();
                String valCity = spinCity.getSelectedItem().toString();
				rdoGender = findViewById(rdoGroup.getCheckedRadioButtonId());
                String valGender = rdoGender.getText().toString();

                if(checkStatus.isChecked()){
                    if(valFirstname.equals("") || valLastname.equals("") || valUsername.equals("") || valPassword.equals("")){
                        Snackbar.make(rooLayout,"Fill all values", BaseTransientBottomBar.LENGTH_LONG).show();
                    }else if(!Patterns.EMAIL_ADDRESS.matcher(valUsername).matches()){
                        Snackbar.make(rooLayout,"Username must be email address", BaseTransientBottomBar.LENGTH_LONG).show();
                    }else if(valPassword.length() < 6){
                        Snackbar.make(rooLayout,"Password must not be less than 6 letters", BaseTransientBottomBar.LENGTH_LONG).show();
                    }else{
                        Intent intent = new Intent(MainActivity.this,Profile.class);
                        intent.putExtra("firstname",valFirstname);
                        intent.putExtra("lastname",valLastname);
                        intent.putExtra("username",valUsername);
                        intent.putExtra("password",valPassword);
                        intent.putExtra("gender",valGender);
                        intent.putExtra("city",valCity);
                        startActivity(intent);
                    }
                }else{
                    Snackbar.make(rooLayout,"Please accept condition", BaseTransientBottomBar.LENGTH_LONG).show();
                }
            }
        });

    }

    private void init_view() {
        btnRegister = findViewById(R.id.btnRegister);
        txtFirstname = findViewById(R.id.txtFirstname);
        txtLastname = findViewById(R.id.txtLastname);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPasssword);
        spinCity = findViewById(R.id.spinCity);
        rdoGroup = findViewById(R.id.rdoGroup);
        checkStatus = findViewById(R.id.checkStatus);
        rooLayout = findViewById(R.id.rooLayout);
    }
}