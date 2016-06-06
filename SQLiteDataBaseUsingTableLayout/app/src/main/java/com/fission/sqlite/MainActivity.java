package com.fission.sqlite;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText mETName,mETBranch, mETPhonenumber;
    Button mBtnInsert,mBtnDelete,mBtnShowOne,mBtnShowAll;
    SQLiteDatabase db;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mETName =(EditText)findViewById(R.id.name);
        mETBranch=(EditText) findViewById(R.id.branch);
        mETPhonenumber =(EditText)findViewById(R.id.phonenumber);
        mBtnInsert=(Button)findViewById(R.id.Insert);
        mBtnDelete=(Button)findViewById(R.id.delete);
        mBtnShowOne=(Button)findViewById(R.id.showone);
        mBtnShowAll=(Button)findViewById(R.id.showall);
        mBtnInsert.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mBtnShowOne.setOnClickListener(this);
        mBtnShowAll.setOnClickListener(this);
        db=openOrCreateDatabase("studentDB",Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(name varchar,branch varchar,phonenum varchar)");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Insert:
                db.execSQL("INSERT INTO student VALUES('"+mETName.getText().toString()+"'," +
                        "'"+mETBranch.getText().toString()+"', " +
                        "'"+mETPhonenumber.getText().toString()+"')");
                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
                    mETName.setText("");
                    mETBranch.setText("");
                    mETPhonenumber.setText("");
                break;
            case R.id.showone:
                if (mETName.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"No Records in The table",Toast.LENGTH_LONG).show();
                }
                Cursor c=db.rawQuery("SELECT*FROM student WHERE NAME='"+mETName.getText().toString()+"'",null);
                if (c.moveToFirst()){
                    mETBranch.setText(c.getString(1));
                    mETPhonenumber.setText(c.getString(2));
                }
                break;
            case R.id.delete:
                if (mETName.getText().toString().trim().length()==0){
                    mETName.setError("Enter the Name");
                    Toast.makeText(getApplicationContext(),"please enter the name",Toast.LENGTH_LONG).show();
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setMessage(R.string.deleteFile);
                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println(mETName.getText());
                           Cursor cursor =  db.rawQuery("DELETE FROM student WHERE NAME like '"+mETName.getText().toString().trim()+"'",null);
                            Toast.makeText(getApplicationContext(),"deleted "+cursor.getCount(),Toast.LENGTH_LONG).show();
                        }

                });
                builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.setTitle("Are You Sure");
                dialog.show();
                break;
            case R.id.showall:
                c=db.rawQuery("SELECT * FROM student",null);
                if(c.getCount()==0){
                    Toast.makeText(getApplicationContext(),"No record Available",Toast.LENGTH_LONG).show();
                }
                StringBuffer buffer=new StringBuffer();
                while (c.moveToNext()){
                    buffer.append("Name:"+c.getString(0)+"");
                    buffer.append("Branch:"+c.getString(1)+"");
                    buffer.append("PhoneNum:"+c.getString(2)+"\n");
                }
               /* Toast.makeText(getApplicationContext(),"Student detail"+buffer.toString(),Toast.LENGTH_LONG).show();
                break;*/
        }

    }
}
