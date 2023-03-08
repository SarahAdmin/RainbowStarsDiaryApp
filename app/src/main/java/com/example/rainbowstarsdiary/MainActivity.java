package com.example.rainbowstarsdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void newEntry(View view) {
        Intent intentOne = new Intent(this, DiaryEntry.class);
        startActivity(intentOne);
    }
    public void email_page(View view) {
        Intent intentMail = new Intent(this, Email.class);
        startActivity(intentMail);
    }
    public void RD_History (View view ) {
        Intent viewIntent = new Intent(this, DiaryHistory.class);
        startActivity(viewIntent);
    }
}