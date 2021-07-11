package com.example.a18_arid_3033_practical;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "StudentsInformation";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Students";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_NUMBER = "Registration Number";
    public static final String COLUMN_SEMESTER = "Semester";
    public static final String COLUMN_DEGREE = "Degree";


    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, " +  COLUMN_NUMBER + " TEXT, " + COLUMN_SEMESTER + " INTEGER, " + COLUMN_DEGREE
                + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void AddStudents(String name, String number, int semeter, int degree){
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues cn = new ContentValues();
        cn.put(COLUMN_NAME, name);
        cn.put(COLUMN_NUMBER, number);
        cn.put(COLUMN_SEMESTER, semeter);
        cn.put(COLUMN_DEGREE, degree);
        mydb.insert(TABLE_NAME,null, cn);
    }

    public void display(int position)
    {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_DEGREE + " == '" + position + "';";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db!= null){
            cursor = db.rawQuery(query, null);
            if(cursor.getString(2) == pass){
                Toast.makeText(context, "Successfully Login", Toast.LENGTH_SHORT).show();
                Intent inte = new Intent(this, MainActivity.class);
                startActivity(inte);
            }
            else {
                Toast.makeText(context, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
            }
        }
        return cursor;
    }

}
