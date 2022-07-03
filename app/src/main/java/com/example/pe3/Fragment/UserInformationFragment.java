package com.example.pe3.Fragment;

import static com.example.pe3.LoginActivity.username_total;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pe3.Database.DatabaseHelper;
import com.example.pe3.LoginActivity;
import com.example.pe3.R;

public class UserInformationFragment extends Fragment {
    View view;
    TextView tv_name;
    EditText et_gender, et_age, et_phone, et_email;
    Button btn_modify, btn_log_out;

    private DatabaseHelper DB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_information, container, false);

        //initialize widget
        tv_name = (TextView) view.findViewById(R.id.tv_name);
        et_gender = (EditText) view.findViewById(R.id.et_gender);
        et_age = (EditText) view.findViewById(R.id.et_age);
        et_phone = (EditText) view.findViewById(R.id.et_phone);
        et_email = (EditText) view.findViewById(R.id.et_email);
        btn_modify = (Button) view.findViewById(R.id.btn_modify);
        btn_log_out = (Button) view.findViewById(R.id.btn_log_out);
        DB = new DatabaseHelper(getActivity());

        // query and set data from database
        SQLiteDatabase db = DB.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE username = ?", new String[]{username_total});
        cursor.moveToFirst();

        // set the data in the TextView and EditText
        tv_name.setText(cursor.getString(2));
        et_gender.setText(cursor.getString(4));
        et_age.setText(cursor.getString(3));
        et_phone.setText(cursor.getString(5));
        et_email.setText(cursor.getString(6));

        cursor.close();
        db.close();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // delete user account function
        btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = et_age.getText().toString();
                String gender = et_gender.getText().toString();
                String phone = et_phone.getText().toString();
                String email = et_email.getText().toString();

                Boolean modifyPersonalInformation = DB.modifyPersonalInformation(username_total, age, gender, phone, email);
                // if delete successfully, turn to LoginActivity
                if(modifyPersonalInformation)
                {
                    Toast.makeText(getActivity(), "You have modified your account successfully!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getActivity(), "You modified your account unsuccessfully!", Toast.LENGTH_LONG).show();
                }
            }
        });

        // log out function, and turn to LoginActivity
        btn_log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to be continue
                Toast.makeText(getActivity(), "You have log out!", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                getActivity().finish();
            }
        });
    }
}