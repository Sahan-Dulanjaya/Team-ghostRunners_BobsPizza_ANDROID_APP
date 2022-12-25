package com.example.newmadproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class vieworderdetailspage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vieworderdetailspage);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(vieworderdetailspage.this, editorderdetailspage.class);
        startActivity(intent);
    }

    public void sendMessagetwo(View view) {
        Intent intent = new Intent(vieworderdetailspage.this, deleteorderdetailspage.class);
        startActivity(intent);
    }

}