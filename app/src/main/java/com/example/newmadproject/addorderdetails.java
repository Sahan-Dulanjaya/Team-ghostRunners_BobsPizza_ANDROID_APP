package com.example.newmadproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


public class addorderdetails extends AppCompatActivity {

    ImageView btnprevious;

    AwesomeValidation awesomeValidation;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addorderdetails);

        btnprevious = findViewById(R.id.btnprevious);

        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(addorderdetails.this, previousorderspage.class);
                startActivity(intent);

            }
        });

        final TextView enterorder = findViewById(R.id.enterorderid);
        final TextView entercustomername = findViewById(R.id.entercustomername);
        final EditText enteremail = findViewById(R.id.enteremail);
        final EditText enternum = findViewById(R.id.enternum);
        final EditText enteradrs = findViewById(R.id.enteradrs);
        final EditText enterzip = findViewById(R.id.enterzip);
        final TextView enterdate = findViewById(R.id.enterdate);
        final TextView enteritems = findViewById(R.id.enteritems);
        final TextView enterprice = findViewById(R.id.entertotal);
        final TextView entertime = findViewById(R.id.entertime);
        final TextView enterdeliverystatus = findViewById(R.id.enterdeliverystatus);
        Button btngotopayment = findViewById(R.id.btngotopayment);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.enteremail,
                RegexTemplate.NOT_EMPTY,R.string.invalid_email);

        awesomeValidation.addValidation(this, R.id.enternum,
                RegexTemplate.NOT_EMPTY,R.string.invalid_number);

        awesomeValidation.addValidation(this, R.id.enteradrs,
                RegexTemplate.NOT_EMPTY,R.string.invalid_address);

        awesomeValidation.addValidation(this, R.id.enterzip,
                RegexTemplate.NOT_EMPTY,R.string.invalid_zip);

        CRUDorder create = new CRUDorder();

        btngotopayment.setOnClickListener(v->
        {

            if (awesomeValidation.validate()) {

                Order order = new Order(enterorder.getText().toString(),
                        entercustomername.getText().toString(),
                        enteremail.getText().toString(),
                        enternum.getText().toString(),
                        enteradrs.getText().toString(),
                        enterzip.getText().toString(),
                        enterdate.getText().toString(),
                        enteritems.getText().toString(),
                        enterprice.getText().toString(),
                        entertime.getText().toString(),
                        enterdeliverystatus.getText().toString());

                create.add(order).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "data added!", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });

            }else {
                Toast.makeText(getApplicationContext(),
                        "Failed",Toast.LENGTH_SHORT).show();
            }

        });


    }

}