package com.example.newmadproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class distancecalculator extends AppCompatActivity {

    private EditText res;
    private EditText cty;
    private Button calc;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distancecalculator);

        res = (EditText) findViewById(R.id.restName);
        cty = (EditText) findViewById(R.id.ctyName);
        calc = (Button) findViewById(R.id.btnCalculate);
        result = (TextView) findViewById(R.id.resultDistance);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double x=0,y=0,sum;

                String str1 = res.getText().toString();
                String str2 = cty.getText().toString();

                switch(str1) {
                    case "Kaduwela":
                        x = 0;
                        break;
                    case "Malabe":
                        x = 3.1;
                        break;
                    case "Kothalawala":
                        x = 2.5;
                        break;
                    case "Battaramulla":
                        x = 9.7;
                        break;
                    case "Thalahena":
                        x = 5.7;
                        break;
                    case "Pittugala":
                        x = 2.9;
                        break;
                    default:
                        x= 808;
                        break;
                }

                switch(str2) {
                    case "Kaduwela":
                        y = 0;
                        break;
                    case "Malabe":
                        y = 3.1;
                        break;
                    case "Kothalawala":
                        y = 2.5;
                        break;
                    case "Battaramulla":
                        y = 9.7;
                        break;
                    case "Thalahena":
                        y = 5.7;
                        break;
                    case "Pittugala":
                        y = 2.9;
                        break;
                    default:
                        y = 404;
                        break;
                }

                sum = (y - x);

                if(sum==0) {
                    result.setText("There's a restaurant in your city!");
                }
                else if(sum > 400 | sum < -400){
                    result.setText("Invalid city, please try again");
                }
                else {
                    result.setText("The Distance is: " + String.valueOf(sum) + "KM");
                }

            }
        });

    }

}