package com.fission.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {
    Button mSecondActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        System.out.println("On Create in SecondActivity");
        mSecondActivity=(Button)findViewById(R.id.secondbtn);
        mSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(SecondActivity.this,FirstActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("On Restart in SecondActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("On Start in SecondActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("On Resume in SecondActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("On Pause in SecondActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("On Stop in SecondActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("On Destroy in SecondActivity");
    }
}
