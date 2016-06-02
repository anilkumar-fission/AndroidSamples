package com.fission.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends Activity {
    Button mFirstActvity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        System.out.println("Oncreate in FirstActivity ");
        mFirstActvity=(Button)findViewById(R.id.button);
        mFirstActvity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Onstart in FirstActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("OnRestart in FirstActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("OnResume in FirstActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("OnPause in FirstActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("OnStop in FirstActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy in FirstActivity");
    }
}
