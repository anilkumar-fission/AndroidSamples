package com.fission.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mLogin,mReceive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLogin=(Button)findViewById(R.id.login);
        mReceive=(Button)findViewById(R.id.Receive);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,Main2Activity.class);
                it.putExtra("name","This is a string");
                it.putExtra("Id",25);
                Bundle extras=new Bundle();
                extras.putString("name","This is anilkumar");
                extras.putInt("Id",13221287);
                it.putExtras(extras);
                startActivityForResult(it,1);
            }
        });

    }
}
