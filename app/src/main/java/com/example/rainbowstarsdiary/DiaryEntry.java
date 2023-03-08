package com.example.rainbowstarsdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.RatingBar.OnRatingBarChangeListener;



public class DiaryEntry extends AppCompatActivity {
    EditText date;
    EditText time;
    EditText book_title;
    EditText pages_read;
    RatingBar rating;
    EditText comments;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_entry);
        date = (EditText) findViewById(R.id.date_input);
        time = (EditText) findViewById(R.id.time_input);
        book_title = (EditText) findViewById(R.id.book_title_input);
        pages_read = (EditText) findViewById(R.id.pages_read_input);
        rating = (RatingBar) findViewById(R.id.ratingBar);
        comments = (EditText) findViewById(R.id.editTextTextPersonName);

    }

    public void backMainScreen(View view) {
        Intent intentMainOne = new Intent(this, MainActivity.class);
        startActivity(intentMainOne);
    }

    public void addDiaryEntry(View view) {
       Intent saveEntry = new Intent(getApplicationContext(), DiaryHistory.class);
       saveEntry.putExtra("DATE", date.getText().toString());
       saveEntry.putExtra("TIME", time.getText().toString());
       saveEntry.putExtra("BOOK_TITLE", book_title.getText().toString());
       saveEntry.putExtra("PAGES_READ", pages_read.getText().toString());
       saveEntry.putExtra("RATING", rating.getRating());
       saveEntry.putExtra("COMMENTS", comments.getText().toString());
       startActivity(saveEntry);

        }
    }







