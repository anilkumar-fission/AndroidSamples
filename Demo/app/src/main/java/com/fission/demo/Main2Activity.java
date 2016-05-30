package com.fission.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(this,getIntent().getStringExtra("name"),Toast.LENGTH_LONG).show();
        Toast.makeText(this,Integer.toString(getIntent().getIntExtra("Id",0)),Toast.LENGTH_LONG).show();
        Bundle bundle=getIntent().getExtras();
        Toast.makeText(this,bundle.getString("name"),Toast.LENGTH_LONG).show();
        Toast.makeText(this,Integer.toString(bundle.getInt("Id")),Toast.LENGTH_LONG).show();
    }
}
