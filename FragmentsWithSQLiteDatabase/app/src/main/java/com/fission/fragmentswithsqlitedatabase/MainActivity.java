package com.fission.fragmentswithsqlitedatabase;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        boolean isUserLogin = sharedPreferences.getBoolean("is_user_login", false);
        Log.e("A", "login value:" + isUserLogin);

        if (isUserLogin) {
            HomeFragment homeFragment = new HomeFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.your_placeholder, homeFragment);
            transaction.commit();
        } else {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            LoginFragment firstFragment = new LoginFragment();
            fragmentTransaction.add(R.id.your_placeholder, firstFragment);
            fragmentTransaction.commit();
        }

    }

}
