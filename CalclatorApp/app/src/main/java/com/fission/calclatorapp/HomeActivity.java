package com.fission.calclatorapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Thread th=new Thread(){
            public void run(){
                try {
                    sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    onPause();
                   startActivity(new Intent("com.fission.calclatorapp"));
                }
            }
        };
        th.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        /*Intent it=new Intent(HomeActivity.this,CalcActivity.class);
        startActivity(it);*/

    }
}
