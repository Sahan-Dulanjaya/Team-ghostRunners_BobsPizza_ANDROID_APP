package com.example.newmadproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class deleteorderdetailspage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteorderdetailspage);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(deleteorderdetailspage.this, cartpage.class);
        startActivity(intent);
    }

    public void sendMessagetwo(View view) {
        Intent intent = new Intent(deleteorderdetailspage.this, previousorderspage.class);
        startActivity(intent);
    }

}