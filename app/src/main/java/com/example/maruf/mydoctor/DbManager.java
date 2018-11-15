package com.example.maruf.mydoctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.maruf.mydoctor.DbHelper.DOC_COLUM_Appoinment;
import static  com.example.maruf.mydoctor.DbHelper.TABLE_NAME;
import static  com.example.maruf.mydoctor.DbHelper.DOC_COLUM_ID;
import static  com.example.maruf.mydoctor.DbHelper.DOC_COLUM_Name;
import static  com.example.maruf.mydoctor.DbHelper.DOC_COLUM_Details;
import static  com.example.maruf.mydoctor.DbHelper.DOC_COLUM_Phone;
import static  com.example.maruf.mydoctor.DbHelper.DOC_COLUM_Email;


public class DbManager {
    private Context context;
    private SQLiteDatabase db;
    private DbHelper helper;

    public DbManager(Context context) {
        this.context = context;
        helper = new DbHelper(context);
    }

    public boolean insertDoctor(Doctor doctor){
        db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DbHelper.DOC_COLUM_Name,doctor.getName());
        cv.put(DbHelper.DOC_COLUM_Details,doctor.getDetails());
        cv.put(DbHelper.DOC_COLUM_Email,doctor.getEmail());
        cv.put(DbHelper.DOC_COLUM_Phone,doctor.getPhone());
        cv.put(DbHelper.DOC_COLUM_Appoinment,doctor.getAppoinment());

        long insertRow = db.insert(TABLE_NAME,null,cv);

        if (insertRow>0){
            db.close();
            return true;

        }else{
            return false;
        }
    }


 public List<Doctor> getAllDoctor(){
        List <Doctor> doctors= new ArrayList<>();
        db = helper.getReadableDatabase();
        String query = "Select * from "+TABLE_NAME;
       Cursor cursor = db.rawQuery(query,null);
       if(cursor.moveToFirst()){
           do{
               int id = cursor.getColumnIndex(DOC_COLUM_ID);
               String name = cursor.getString(cursor.getColumnIndex(DOC_COLUM_Name));
               String details = cursor.getString(cursor.getColumnIndex(DOC_COLUM_Details));
               String email = cursor.getString(cursor.getColumnIndex(DOC_COLUM_Email));
               String phone = cursor.getString(cursor.getColumnIndex(DOC_COLUM_Phone));
               String appoinment = cursor.getString(cursor.getColumnIndex(DOC_COLUM_Appoinment));
               Doctor doctor = new Doctor(id,name,details,appoinment,phone,email);
              doctors.add(doctor);
           }while (cursor.moveToNext());
       }
       db.close();
       return doctors;

 }

 public boolean deleteDoctor(int id){
        db = helper.getWritableDatabase();
        int deleteRow = db.delete(TABLE_NAME,DOC_COLUM_ID+"="+id,null);
        if(deleteRow>0){
            db.close();
            return true;
        }else{
            return false;
        }
 }

}
