package com.example.pe3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pe3.Database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login, btn_forgetpassword;
    private ImageButton btn_back;
    private EditText et_username, et_password;
    private CheckBox cb_remember;
    private DatabaseHelper DB;

    public static String username_total;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialize widget
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        cb_remember = (CheckBox) findViewById(R.id.cb_remember);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_forgetpassword = (Button) findViewById(R.id.btn_forgetpassword);
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        DB = new DatabaseHelper(this);
        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        editor = preferences.edit();


        // to check whether there are username and password stored in location.
        String checkName = preferences.getString("userName", null);
        String checkPass = preferences.getString("userPassword", null);
        if (checkName == null && checkPass == null){
            cb_remember.setChecked(false);
        }else {
            et_username.setText(checkName);
            et_password.setText(checkPass);
            cb_remember.setChecked(true);
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                // get the username and set it as a global variable
                username_total = username;

                // Check whether user enter all the information
                if (username.equals("") || password.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the information", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkUserPass = DB.checkUsernamePassword(username, password);
                    // Check whether the username and password is correct
                    if (checkUserPass == true){
                        // Store username and password in location function
                        if (cb_remember.isChecked()){
                            editor.putString("userName", username);
                            editor.putString("userPassword", password);
                            editor.commit();
                        }else {
                            // Delete username and password in location
                            editor.remove("userName");
                            editor.remove("userPassword");
                            editor.commit();
                        }

                        //successful pop-up
                        Toast.makeText(LoginActivity.this, "Sign in successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }else {
                        // Delete username and password in location
                        editor.remove("userName");
                        editor.remove("userPassword");
                        editor.commit();
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn_forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RetrievePasswordPart1Activity.class);
                startActivity(intent);
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
