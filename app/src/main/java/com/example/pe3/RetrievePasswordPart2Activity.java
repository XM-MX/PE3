package com.example.pe3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pe3.Database.DatabaseHelper;

public class RetrievePasswordPart2Activity extends AppCompatActivity {

    private EditText et_password, et_re_password;
    private Button btn_confirm;
    private ImageButton btn_back;
    private DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_password_part2);

        et_password = (EditText) findViewById(R.id.et_password);
        et_re_password = (EditText) findViewById(R.id.et_re_password);
        btn_confirm = (Button) findViewById(R.id.btn_confirm);
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        DB = new DatabaseHelper(this);

        Intent intent = getIntent();

        // Using Bundle to get data
        Bundle bundle = intent.getExtras();
        String username = bundle.getString("user");

        // Modify Password Function
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get all the data that user entered in the EditText
                String password = et_password.getText().toString();
                String repassword = et_re_password.getText().toString();

                // Check whether user enter all the information
                if (username.equals("") || password.equals("") || repassword.equals(""))
                    Toast.makeText(RetrievePasswordPart2Activity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    // Check whether the password and re-enter password is equal
                    if (password.equals(repassword)){
                        Boolean modify = DB.modifyData(username, password);
                        // Modify data in database
                        if (modify){
                            Toast.makeText(RetrievePasswordPart2Activity.this, "Modify password successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(RetrievePasswordPart2Activity.this, "Modify password failed", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RetrievePasswordPart2Activity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RetrievePasswordPart1Activity.class);
                startActivity(intent);
            }
        });
    }
}