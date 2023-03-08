package com.example.rainbowstarsdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.SearchView;




public class DiaryHistory extends AppCompatActivity {
    Button modifyDiaryEntry;
    Button deleteDiaryEntry;
    TextView entries;
    TextView timeView;
    TextView bookView;
    TextView pagesView;
    TextView ratingView;
    TextView commentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_history);

        modifyDiaryEntry = (Button) findViewById(R.id.modify_button);
        deleteDiaryEntry = (Button) findViewById(R.id.delete_button);
        entries = (TextView) findViewById(R.id.entries);
        timeView = (TextView) findViewById(R.id.entries2);
        bookView = (TextView) findViewById(R.id.entries3);
        pagesView = (TextView) findViewById(R.id.entries4);
        ratingView = (TextView) findViewById(R.id.entries5);
        commentView = (TextView) findViewById(R.id.entries6);
        Intent intentOne = getIntent();
        String date = intentOne.getStringExtra("DATE");
        entries.setText(date);
        Intent intentTwo = getIntent();
        String time = intentTwo.getStringExtra("TIME");
        timeView.setText(time);
        Intent intentThree = getIntent();
        String title = intentThree.getStringExtra("BOOK_TITLE");
        bookView.setText(title);
        Intent intentFour = getIntent();
        String pages = intentFour.getStringExtra("PAGES_READ");
        pagesView.setText(pages);
        Intent intentFive = getIntent();
        String rating = intentFive.getStringExtra("RATING");
        ratingView.setText(rating);
        Intent intentSix = getIntent();
        String comment = intentSix.getStringExtra("COMMENTS");
        bookView.setText(comment);




    }


        public void backMainScreenThree (View view) {
            Intent intentThree = new Intent(this, MainActivity.class);
            startActivity(intentThree);
        }




    }

