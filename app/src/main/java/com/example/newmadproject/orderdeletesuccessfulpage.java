package com.example.newmadproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class orderdeletesuccessfulpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdeletesuccessfulpage);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(orderdeletesuccessfulpage.this, distancecalculator.class);
        startActivity(intent);
    }
}