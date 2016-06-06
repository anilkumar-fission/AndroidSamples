package com.fission.fragmentswithsqlitedatabase;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by anilkumar on 4/6/16.
 */
public class LoginFragment extends Fragment {
    @Nullable
    int stutas=0;
    EditText mETUserName,mETPassword;
    Button mBtnLogin,mBtnSignUp;
    String Username,Password;
    String  NAME;
   // LoginFragment ctx=this;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //setHasOptionsMenu(true);
        View view=inflater.inflate(R.layout.loginfragment,container,false);
        mETUserName=(EditText)view.findViewById(R.id.editText);
        mETPassword=(EditText)view.findViewById(R.id.editText2);
        mBtnLogin=(Button)view.findViewById(R.id.button);
        mBtnSignUp=(Button)view.findViewById(R.id.button2);
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SignUpFragment signUpFragment = new SignUpFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.your_placeholder, signUpFragment);
                transaction.commit();
            }
        });
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username=mETUserName.getText().toString();
                Password=mETPassword.getText().toString();
                DatabaseHelper databaseHelper=new DatabaseHelper(getActivity());
                Cursor cursor=databaseHelper.getData(databaseHelper);
                cursor.moveToFirst();
                boolean loginstatus=false;
                do {
                    if (Username.equals(cursor.getString(0))&&Password.equals(cursor.getString(1))){
                        loginstatus=true;
                          NAME=cursor.getString(0);
                    }
                }while (cursor.moveToNext());
                if (loginstatus){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.your_placeholder, homeFragment);
                    transaction.commit();
                    Toast.makeText(getActivity(),"Successfully======>\n welcome:"+NAME,Toast.LENGTH_LONG).show();
                }
                else {
                Toast.makeText(getActivity(),"login failed"+NAME,Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}