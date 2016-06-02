package com.fission.second;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by anilkumar on 18/5/16.
 */
public class Sample extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("OnCreate");
    }



    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("OnPause");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("OnDestroy");
    }
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("OnStop");
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("OnStart");


    }

}
