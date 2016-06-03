package com.fission.sqlite;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by anilkumar on 2/6/16.
 */
public class ShowAll extends Activity {
    Cursor c;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_lay_out);
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableRow);
        db = openOrCreateDatabase("studentDB", Context.MODE_PRIVATE, null);
        c = db.rawQuery("SELECT * FROM student", null);
        int rows = c.getCount();
        int cols = c.getColumnCount();

        c.moveToFirst();
        TableRow row1 = new TableRow(this);
        row1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        for (int j = 0; j < 3; j++) {

            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            // tv.setBackgroundResource(R.drawable.cell_shape);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(18);
            tv.setPadding(0, 5, 0, 5);
            if (j==0){
            tv.setText("Name");

            }
            else if (j==1){
                tv.setText("Branch");
            }
            else {
                tv.setText("PhoneNum");
            }
            row1.addView(tv);

        }
        tableLayout.addView(row1);

        // outer for loop
        for (int i = 0; i < rows; i++) {

            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            // inner for loop
            for (int j = 0; j < cols; j++) {

                TextView tv = new TextView(this);
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                // tv.setBackgroundResource(R.drawable.cell_shape);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(18);
                tv.setPadding(0, 5, 0, 5);

                tv.setText(c.getString(j));

                row.addView(tv);


            }
            c.moveToNext();
            tableLayout.addView(row);
        /*if(c.getCount()==0){
            Toast.makeText(getApplicationContext(),"No record Available",Toast.LENGTH_LONG).show();
        }
        StringBuffer buffer=new StringBuffer();
        while (c.moveToNext()){
            buffer.append("Name:"+c.getString(0)+"");
            buffer.append("Branch:"+c.getString(1)+"");
            buffer.append("PhoneNum:"+c.getString(2)+"");
        }
        String s=buffer.toString();
        Toast.makeText(getApplicationContext(),"Student detail"+buffer.toString(),Toast.LENGTH_LONG).show();*/


        }
    }
}
