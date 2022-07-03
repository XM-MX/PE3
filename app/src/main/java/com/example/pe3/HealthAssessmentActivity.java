package com.example.pe3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HealthAssessmentActivity extends AppCompatActivity {

    private RadioGroup radGupDemo1;
    private RadioButton Radbtn1A;
    private RadioButton Radbtn1B;

    private RadioGroup radGupDemo2;
    private RadioButton Radbtn2A;
    private RadioButton Radbtn2B;

    private RadioGroup radGupDemo3;
    private RadioButton Radbtn3A;
    private RadioButton Radbtn3B;

    private RadioGroup radGupDemo4;
    private RadioButton Radbtn4A;
    private RadioButton Radbtn4B;

    private RadioGroup radGupDemo5;
    private RadioButton Radbtn5A;
    private RadioButton Radbtn5B;

    private Button btnMainRefer;
    private TextView tvMainResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_assessment);

        initView();

        radGupDemo1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radBtn = findViewById(checkedId);
                radBtn.getText().toString();
                Log.i("RadioButton", radBtn.getText().toString());
            }
        });
        radGupDemo2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radBtn = findViewById(checkedId);
                radBtn.getText().toString();
                Log.i("RadioButton", radBtn.getText().toString());
            }
        });
        radGupDemo3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radBtn = findViewById(checkedId);
                radBtn.getText().toString();
                Log.i("RadioButton", radBtn.getText().toString());
            }
        });
        radGupDemo4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radBtn = findViewById(checkedId);
                radBtn.getText().toString();
                Log.i("RadioButton", radBtn.getText().toString());
            }
        });
        radGupDemo5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radBtn = findViewById(checkedId);
                radBtn.getText().toString();
                Log.i("RadioButton", radBtn.getText().toString());
            }
        });


        btnMainRefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int optionID1 = radGupDemo1.getCheckedRadioButtonId();
                int optionID2 = radGupDemo2.getCheckedRadioButtonId();
                int optionID3 = radGupDemo3.getCheckedRadioButtonId();
                int optionID4 = radGupDemo4.getCheckedRadioButtonId();
                int optionID5 = radGupDemo5.getCheckedRadioButtonId();

                if (optionID1 == R.id.btn1Y & optionID2==R.id.btn2Y & optionID3==R.id.btn3Y & optionID4==R.id.btn4Y & optionID5==R.id.btn5Y) {
                    tvMainResult.setText("Better go to hospital!");
                } else if (optionID1 == R.id.btn1Y & optionID2==R.id.btn2Y & optionID3==R.id.btn3Y & optionID4==R.id.btn4Y & optionID5==R.id.btn5N || optionID1 == R.id.btn1Y & optionID2==R.id.btn2Y & optionID3==R.id.btn3Y & optionID4==R.id.btn4N & optionID5==R.id.btn5Y || optionID1 == R.id.btn1Y & optionID2==R.id.btn2Y & optionID3==R.id.btn3N & optionID4==R.id.btn4Y & optionID5==R.id.btn5Y || optionID1 == R.id.btn1Y & optionID2==R.id.btn2N & optionID3==R.id.btn3Y & optionID4==R.id.btn4Y & optionID5==R.id.btn5Y || optionID1 == R.id.btn1N & optionID2==R.id.btn2Y & optionID3==R.id.btn3Y & optionID4==R.id.btn4Y & optionID5==R.id.btn5Y) {
                    tvMainResult.setText("COVID-19：80%");
                }else if (optionID1 == R.id.btn1N & optionID2==R.id.btn2N & optionID3==R.id.btn3Y & optionID4==R.id.btn4Y & optionID5==R.id.btn5Y || optionID1 == R.id.btn1N & optionID2==R.id.btn2Y & optionID3==R.id.btn3N & optionID4==R.id.btn4Y & optionID5==R.id.btn5Y || optionID1 == R.id.btn1N & optionID2==R.id.btn2Y & optionID3==R.id.btn3Y & optionID4==R.id.btn4N & optionID5==R.id.btn5Y || optionID1 == R.id.btn1N & optionID2==R.id.btn2Y & optionID3==R.id.btn3Y & optionID4==R.id.btn4Y & optionID5==R.id.btn5N || optionID1 == R.id.btn1Y & optionID2==R.id.btn2N & optionID3==R.id.btn3N & optionID4==R.id.btn4Y & optionID5==R.id.btn5Y || optionID1 == R.id.btn1Y & optionID2==R.id.btn2N & optionID3==R.id.btn3Y & optionID4==R.id.btn4N & optionID5==R.id.btn5Y || optionID1 == R.id.btn1Y & optionID2==R.id.btn2N & optionID3==R.id.btn3Y & optionID4==R.id.btn4Y & optionID5==R.id.btn5N || optionID1 == R.id.btn1Y & optionID2==R.id.btn2Y & optionID3==R.id.btn3N & optionID4==R.id.btn4N & optionID5==R.id.btn5Y || optionID1 == R.id.btn1Y & optionID2==R.id.btn2Y & optionID3==R.id.btn3N & optionID4==R.id.btn4Y & optionID5==R.id.btn5N || optionID1 == R.id.btn1Y & optionID2==R.id.btn2Y & optionID3==R.id.btn3Y & optionID4==R.id.btn4N & optionID5==R.id.btn5N){
                    tvMainResult.setText("COVID-19：60%");
                }else if (optionID1 == R.id.btn1Y & optionID2==R.id.btn2Y & optionID3==R.id.btn3N & optionID4==R.id.btn4N & optionID5==R.id.btn5N || optionID1 == R.id.btn1Y & optionID2==R.id.btn2N & optionID3==R.id.btn3Y & optionID4==R.id.btn4N & optionID5==R.id.btn5N || optionID1 == R.id.btn1Y & optionID2==R.id.btn2N & optionID3==R.id.btn3N & optionID4==R.id.btn4Y & optionID5==R.id.btn5N || optionID1 == R.id.btn1Y & optionID2==R.id.btn2N & optionID3==R.id.btn3N & optionID4==R.id.btn4N & optionID5==R.id.btn5Y || optionID1 == R.id.btn1N & optionID2==R.id.btn2Y & optionID3==R.id.btn3Y & optionID4==R.id.btn4N & optionID5==R.id.btn5N || optionID1 == R.id.btn1N & optionID2==R.id.btn2Y & optionID3==R.id.btn3N & optionID4==R.id.btn4Y & optionID5==R.id.btn5N || optionID1 == R.id.btn1N & optionID2==R.id.btn2Y & optionID3==R.id.btn3N & optionID4==R.id.btn4N & optionID5==R.id.btn5Y || optionID1 == R.id.btn1N & optionID2==R.id.btn2N & optionID3==R.id.btn3Y & optionID4==R.id.btn4Y & optionID5==R.id.btn5N || optionID1 == R.id.btn1N & optionID2==R.id.btn2N & optionID3==R.id.btn3Y & optionID4==R.id.btn4N & optionID5==R.id.btn5Y || optionID1 == R.id.btn1N & optionID2==R.id.btn2N & optionID3==R.id.btn3N & optionID4==R.id.btn4Y & optionID5==R.id.btn5Y){
                    tvMainResult.setText("COVID-19：40%");
                }else if (optionID1 == R.id.btn1Y & optionID2==R.id.btn2N & optionID3==R.id.btn3N & optionID4==R.id.btn4N & optionID5==R.id.btn5N || optionID1 == R.id.btn1N & optionID2==R.id.btn2Y & optionID3==R.id.btn3N & optionID4==R.id.btn4N & optionID5==R.id.btn5N || optionID1 == R.id.btn1N & optionID2==R.id.btn2N & optionID3==R.id.btn3Y & optionID4==R.id.btn4N & optionID5==R.id.btn5N || optionID1 == R.id.btn1N & optionID2==R.id.btn2N & optionID3==R.id.btn3N & optionID4==R.id.btn4Y & optionID5==R.id.btn5N || optionID1 == R.id.btn1N & optionID2==R.id.btn2N & optionID3==R.id.btn3N & optionID4==R.id.btn4N & optionID5==R.id.btn5Y) {
                    tvMainResult.setText("COVID-19：20%");
                }else if (optionID1 == R.id.btn1N & optionID2==R.id.btn2N & optionID3==R.id.btn3N & optionID4==R.id.btn4N & optionID5==R.id.btn5N)
                {
                    tvMainResult.setText("You are healthy!");
                }

            }

        });

    }

    private void initView() {

        radGupDemo1 = (RadioGroup) findViewById(R.id.radGup1);
        Radbtn1A = (RadioButton) findViewById(R.id.btn1Y);
        Radbtn1B = (RadioButton) findViewById(R.id.btn1N);

        radGupDemo2 = (RadioGroup) findViewById(R.id.radGup2);
        Radbtn2A = (RadioButton) findViewById(R.id.btn2Y);
        Radbtn2B = (RadioButton) findViewById(R.id.btn2N);

        radGupDemo3 = (RadioGroup) findViewById(R.id.radGup3);
        Radbtn3A = (RadioButton) findViewById(R.id.btn3Y);
        Radbtn3B = (RadioButton) findViewById(R.id.btn3Y);

        radGupDemo4 = (RadioGroup) findViewById(R.id.radGup4);
        Radbtn4A = (RadioButton) findViewById(R.id.btn4Y);
        Radbtn4B = (RadioButton) findViewById(R.id.btn4N);

        radGupDemo5 = (RadioGroup) findViewById(R.id.radGup5);
        Radbtn5A = (RadioButton) findViewById(R.id.btn5Y);
        Radbtn5B = (RadioButton) findViewById(R.id.btn5N);

        btnMainRefer = (Button) findViewById(R.id.btn_submit);
        tvMainResult = (TextView) findViewById(R.id.tvMainResult);
    }
}