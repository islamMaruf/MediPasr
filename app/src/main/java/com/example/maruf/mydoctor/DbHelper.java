package com.example.maruf.mydoctor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {


    //initialization
    public  static  final String DB_NAME = "doctors.db";
    public static final int VERSION = 1;
    public  static final String TABLE_NAME = "doctor";
    public static final String DOC_COLUM_ID = "id";
    public static final String DOC_COLUM_Name = "name";
    public static final String DOC_COLUM_Details = "details";
    public static final String DOC_COLUM_Appoinment = "appointment";
    public static final String DOC_COLUM_Phone = "phone";
    public static final String DOC_COLUM_Email = "email";

    //query
    public static final String CREATE_TABLE = "create table "+TABLE_NAME+"( "+DOC_COLUM_ID+
            " integer primary key autoincrement, "+DOC_COLUM_Name+" text," +DOC_COLUM_Appoinment+" text,"+DOC_COLUM_Phone+" text, "+
            DOC_COLUM_Email+" text, "+DOC_COLUM_Details+" text"+")";

    public DbHelper(Context context) {
        super(context,DB_NAME,null,VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
