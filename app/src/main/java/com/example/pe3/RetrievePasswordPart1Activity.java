package com.example.pe3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pe3.Database.DatabaseHelper;

public class RetrievePasswordPart1Activity extends AppCompatActivity {

    private EditText et_username, et_email;
    private Button btn_next;
    private ImageButton btn_back;
    private DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_password_part1);

        et_username = (EditText) findViewById(R.id.et_username);
        et_email = (EditText) findViewById(R.id.et_email);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        DB = new DatabaseHelper(this);

        // Check Username and Phone number Function
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get all data that user entered in the EditText
                String username = et_username.getText().toString();
                String email = et_email.getText().toString();

                // Check whether user enter all the information
                if (username.equals("") || email.equals(""))
                    Toast.makeText(RetrievePasswordPart1Activity.this, "Please enter all the information", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkEmail = DB.checkEmail(username, email);
                    // Check whether the username and phone number is correct
                    if (checkEmail == true){
                        Intent intent = new Intent(RetrievePasswordPart1Activity.this, RetrievePasswordPart2Activity.class);

                        // create Bundle
                        Bundle bundle = new Bundle();
                        // insert data
                        bundle.putString("user", username);
                        // Transmit Bundle using intent
                        intent.putExtras(bundle);

                        startActivity(intent);
                    }else {
                        Toast.makeText(RetrievePasswordPart1Activity.this, "The username does not exist and the email is wrong.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}