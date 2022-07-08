package com.rku_21soeca21002.tutorial09;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edtPhone, edtSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPhone = findViewById(R.id.edtPhone);
        edtSMS = findViewById(R.id.edtSMS);
    }

    public void makeCall(View view) {
        if (validate(1) && isPermissionGranted(1)) {
            call_action();
        }
    }

    public void sendSMS(View view) {
        if (validate(2) && isPermissionGranted(2)) {
            sms_action();
        }
    }

    private boolean validate(int i) {
        String phonenumber = edtPhone.getText().toString().trim();
        switch (i)
        {
            case 1:

                if(phonenumber.equals("") || phonenumber.length()<10)
                {
                    Toast.makeText(this, "Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else
                {
                    return true;
                }

            case 2:
                String smstext = edtSMS.getText().toString().trim();
                if(phonenumber.equals("") || phonenumber.length()<10 ||smstext.equals(""))
                {
                    Toast.makeText(this, "Phone Number or SMS must not be blank", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else
                {
                    return true;
                }
            default:
                return false;

        }

    }

    private void call_action() {
        String phonenumber = edtPhone.getText().toString().trim();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phonenumber));
        startActivity(intent);
    }

    private void sms_action() {
        String phonenumber = edtPhone.getText().toString().trim();
        String smstext = edtSMS.getText().toString().trim();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phonenumber, null, smstext, null, null);
        Toast.makeText(getApplicationContext(), "SMS sent.",Toast.LENGTH_LONG).show();
    }

    private boolean isPermissionGranted(int i) {
        switch (i) {
            case 1:
                if (Build.VERSION.SDK_INT >= 23) {
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        Log.v("TAG", "Call permission Granted");
                        return true;
                    } else {
                        Log.v("TAG", "Call permission is required");
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                        return false;
                    }
                } else {
                    return true;
                }

            case 2:
                if (Build.VERSION.SDK_INT >= 23) {
                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        Log.v("TAG", "SMS permission Granted");
                        return true;
                    } else {
                        Log.v("TAG", "SMS permission is required");
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 2);
                        return false;
                    }
                } else {
                    return true;
                }

            default:
                return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Call Permission Granted", Toast.LENGTH_SHORT).show();
                    call_action();
                    break;
                } else {
                    Toast.makeText(getApplicationContext(), "Call Permission Denied", Toast.LENGTH_SHORT).show();
                    break;
                }

            case 2:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "SMS Permission Granted", Toast.LENGTH_SHORT).show();
                    sms_action();
                    break;
                } else {
                    Toast.makeText(getApplicationContext(), "SMS Permission Denied", Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }
}