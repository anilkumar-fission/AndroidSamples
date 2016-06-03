package com.fission.fragment_1;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityFragment extends Activity {
    Button mBtnFirst, mBtnSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_fragment);
        mBtnFirst=(Button)findViewById(R.id.startbtn);
        mBtnSecond =(Button)findViewById(R.id.secondbtn);
        mBtnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                FirstFragment firstFragment=new FirstFragment();
                fragmentTransaction.addToBackStack("firstFragment");
                fragmentTransaction.add(R.id.fragment1,firstFragment);
                fragmentTransaction.commit();
            }
        });
        mBtnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                SecondFragment secondFragment=new SecondFragment();
                fragmentTransaction.addToBackStack("secondFragment");
                fragmentTransaction.add(R.id.fragment2,secondFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
