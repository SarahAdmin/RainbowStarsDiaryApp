package com.example.rainbowstarsdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.net.Uri;
import android.widget.Toast;

public class Email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }
    public void Email_Message(View view) {
        Intent intentOne = new Intent(Intent.ACTION_SEND);
        intentOne.setData(Uri.parse("mailto:"));
        intentOne.putExtra(Intent.EXTRA_EMAIL, new String[]{"mailto@rsmail.com"});
        intentOne.putExtra(Intent.EXTRA_SUBJECT, "Test email");
        intentOne.putExtra(Intent.EXTRA_TEXT, "This is a test message");
        intentOne.setType("message/rfc822");
        startActivity(Intent.createChooser(intentOne, "Email"));
    }
    public void backMainScreenTwo(View view) {
        Intent intentOne = new Intent(this, MainActivity.class);
        startActivity(intentOne);
    }
}