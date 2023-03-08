package com.example.rainbowstarsdiary;
import android.content.Context;
import android.widget.Toast;

public class Message {
    public static void messageOne(Context contextOne, String messageOne) {
        Toast.makeText(contextOne, messageOne, Toast.LENGTH_LONG).show();

    }
}
