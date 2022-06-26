package com.example.pe3.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Database.db";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    // To create table on database
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE USER(username TEXT primary key, password TEXT, name TEXT, age TEXT, gender TEXT, phone TEXT, email TEXT)");
    }

    // Drop the table if it is already exist
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE if EXISTS USER");
    }

    // To insert data
    public Boolean insertData(String username, String password, String name, String age, String gender, String phone, String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("gender", gender);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        long result = MyDB.insert("user", null, contentValues);

        if(result == 1)
            return false;
        else
            return true;

    }

    // to delete data
    public Boolean deleteData(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        //delete record
        int result = MyDB.delete("user", "username = ?", new String []{username});

        if(result == -1){
            return true;
        }else{
            return false;
        }

    }

    // To modify data, retrieve password function
    public Boolean modifyData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        MyDB.update("user", contentValues, "username=?", new String []{username});
        //MyDB.close();
        return true;
    }

    // To check the username
    public Boolean checkUsername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM user WHERE username = ?", new String[]{username});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    // To check the password
    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM user WHERE username = ? and password = ?", new String[]{username, password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    // To check the username and phone number
    public Boolean checkEmail(String username, String phone){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM user WHERE username = ? and phone = ?", new String[]{username, phone});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
