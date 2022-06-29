package com.example.pe3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.pe3.Database.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_sign_up;
    private ImageButton btn_back;
    private EditText et_username, et_password, et_re_password, et_name, et_age, et_gender, et_phone, et_email;
    private DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //initialize widget
        btn_sign_up = (Button) findViewById(R.id.btn_sign_up);
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_re_password = findViewById(R.id.et_re_password);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_gender = findViewById(R.id.et_gender);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        DB = new DatabaseHelper(this);

        // Signup function
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get all the data that user entered in the EditText
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                String re_password = et_re_password.getText().toString();
                String name = et_name.getText().toString();
                String age = et_age.getText().toString();
                String gender = et_gender.getText().toString();
                String phone = et_phone.getText().toString();
                String email = et_email.getText().toString();

                // Check whether user enter all the information
                if (username.equals("") || password.equals("") || re_password.equals("") || name.equals("") || age.equals("") || phone.equals("") || gender.equals("") || email.equals(""))
                    Toast.makeText(RegisterActivity.this, "Please enter all the information", Toast.LENGTH_SHORT).show();
                else {
                    // Check whether the password and re-enter password is equal
                    if (password.equals(re_password)){
                        Boolean checkUser = DB.checkUsername(username);
                        // Check whether the username is exist
                        if (!checkUser){
                            Boolean insert = DB.insertData(username, password, name, age, gender, phone, email);
                            // Insert data to database
                            if (insert){
                                Toast.makeText(RegisterActivity.this, "Registered successfull", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(RegisterActivity.this, "Registered unsuccessfull", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(RegisterActivity.this, "User already exist! Please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegisterActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}