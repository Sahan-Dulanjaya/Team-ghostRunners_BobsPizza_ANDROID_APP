package com.example.newmadproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class cartpage extends AppCompatActivity {

    ImageView simplecalc;
    Button btncart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartpage);

        simplecalc = findViewById(R.id.simplecalc);
        btncart = findViewById(R.id.btnCart);

        simplecalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(cartpage.this, distancecalculator.class);
                startActivity(intent);

            }
        });

        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {

                Intent intent2 = new Intent(cartpage.this, addorderdetails.class);
                startActivity(intent2);

            }
        });



    }



}