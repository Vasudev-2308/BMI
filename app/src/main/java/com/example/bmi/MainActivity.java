package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     RadioButton male,female;
     Button check;
     EditText age,weight,height;
     TextView ans, stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        male = findViewById(R.id.male);
        age = findViewById(R.id.ageentry);
        female = findViewById(R.id.female);
        height = findViewById(R.id.heightentry);
        weight = findViewById(R.id.weightentry);
        ans = findViewById(R.id.bmians);
        stat = findViewById(R.id.status);
        check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height_val = Integer.parseInt(height.getText().toString());
                final float weight_val = Integer.parseInt(weight.getText().toString());
                int age_val = Integer.parseInt(age.getText().toString());
                float height_in_m = (float) (height_val/100.0);
                float bmi;
                if (male.isChecked()){
                    System.out.println(height_in_m);
                    bmi = checkbmi(height_in_m,weight_val,age_val);
                    ans.setText(bmi+"");
                    System.out.println();
                }
                if (female.isChecked()){
                    bmi = checkbmi(height_in_m,weight_val,age_val);
                    ans.setText(bmi+"");
                }

            }
        });


    }

    @SuppressLint("SetTextI18n")
    private float checkbmi(float height, float weight, int age){



        double bmi = weight/(height*height);
        System.out.println(bmi);


        if(age > 20 && bmi > 25) {
            stat.setText("Over Weight!! Please Reduce weight");
        }
        if(age > 20 && bmi >18.5 && bmi < 25) {
            stat.setText("Normal !!");
        }
        if(age > 20 &&  bmi < 18.5) {
            stat.setText("Underweight!!!");
        }
        if (age<20 && bmi > 25){
            stat.setText("Obese");
        }
        if (age<20 && bmi>18 && bmi<25){
            stat.setText("Over Weight!! Please Reduce Weight");
        }
        if(age < 20 &&  bmi > 12.5  && bmi < 18.5) {
            stat.setText("Normal!!!");
        }
        if(age < 20 &&  bmi < 12.5) {
            stat.setText("Underweight!!!");
        }
        return (float) bmi;

    }
}
