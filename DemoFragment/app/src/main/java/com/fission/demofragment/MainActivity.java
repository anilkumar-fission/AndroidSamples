package com.fission.demofragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {
    Fragment Fragment_one;
    Button one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager man=getFragmentManager();
        FragmentTransaction tran=man.beginTransaction();
        Fragment_one=new Fragment1();
        tran.add(R.id.fragment_container, Fragment_one);
        tran.addToBackStack(null);
        tran.commit();
    }
}
