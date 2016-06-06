package com.fission.fragmentswithsqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by anilkumar on 5/6/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Student.db";
    public static final String TABLE_NAME="Student";
    public static final String COL_1="USER";
    public static final String COL_2="PASSWORD";
    public static final String COL_3="CONFORMPASSWORD";
    public String CREATE_QUERY="CREATE TABLE " + TABLE_NAME +"("+COL_1+" TEXT,"+COL_2+" TEXT)";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        Log.d("Database","DatabaseCreated");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database","TableCreated");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void InsertData(DatabaseHelper databaseHelper,String Username,String Password){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,Username);
        contentValues.put(COL_2,Password);
       // contentValues.put(COL_3,ConformPassword);
       long k= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        Log.d("Database","One row is inserted");
    }
    public Cursor getData(DatabaseHelper databaseHelper){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getReadableDatabase();
        String[] Columns={COL_1,COL_2};
        Cursor cursor=sqLiteDatabase.query(TABLE_NAME,Columns,null,null,null,null,null);
        return cursor;

    }
}
