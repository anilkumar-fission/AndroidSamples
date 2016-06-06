package com.fission.fragmentswithsqlitedatabase;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by anilkumar on 4/6/16.
 */
public class SignUpFragment extends Fragment {
    EditText mETUsername,mETPassword,mETConformPassword;
    Button mBtnSubmit;
    String Username,Password,ConformPassword;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.signupfragment,container,false);
        mETUsername=(EditText)view.findViewById(R.id.editText);
        mETPassword=(EditText)view.findViewById(R.id.editText2);

        mETConformPassword=(EditText)view.findViewById(R.id.editText3);
        mBtnSubmit=(Button)view.findViewById(R.id.submit);
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Username=mETUsername.getText().toString();
                Password=mETPassword.getText().toString();
                ConformPassword=mETConformPassword.getText().toString();
                if (Username.length()==0||Password.length()==0||ConformPassword.length()==0){
                    Toast.makeText(getActivity(),"Please enter the Correct details",Toast.LENGTH_LONG).show();
                }
                else if (!Password.equals(ConformPassword)){
                    Toast.makeText(getActivity(),"Passwords are not matching",Toast.LENGTH_LONG).show();
                }
                else {
                    DatabaseHelper DH=new DatabaseHelper(getActivity().getApplication());
                    DH.InsertData(DH,Username,Password);
                    Toast.makeText(getActivity(),"Successfully Inserted",Toast.LENGTH_LONG).show();
                    FragmentManager fragmentManager=getFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    LoginFragment loginFragment = new LoginFragment();
                    fragmentTransaction.replace(R.id.your_placeholder,loginFragment);
                    fragmentTransaction.commit();
                }
                Toast.makeText(getActivity(),"Successfully Submited",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
