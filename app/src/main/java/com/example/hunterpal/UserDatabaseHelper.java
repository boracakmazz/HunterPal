package com.example.hunterpal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class UserDatabaseHelper extends SQLiteOpenHelper {

    public UserDatabaseHelper(Context context) {
        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER(USERNAME TEXT PRIMARY KEY, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER");
    }

    public boolean insert(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);

        long ins = db.insert("user",null,contentValues);
        if(ins == -1)
            return false;
        else
            return true;
    }

    public boolean checkUsername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE USERNAME=?",new String[]{username});

        if(cursor.getCount() > 0)
            return false;
        else
            return true;
    }

    public Boolean usernamePassword(String username,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=?",new String[]{username,password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Cursor getItemUsername(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " SELECT " + " USERNAME " + " FROM " + " USER " +
                " WHERE " + " USERNAME " + " = " + name + " ' ";
        Cursor data = db.rawQuery(query,null);
        return data;
    }


    public void updateUsername(String oldName, String newName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " UPDATE " + " USER " +
                       " SET " + " USERNAME " + " = "  + "'" +  newName + "'" +
                       " WHERE " + " USERNAME " + " = " + "'" + oldName + "'";
        Cursor data = db.rawQuery(query,null);
        db.execSQL(query);
    }


}
