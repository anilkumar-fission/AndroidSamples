package com.fission.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by anilkumar on 19/5/16.
 */
public class SignupActivity extends Activity implements View.OnClickListener{

    EditText username;
    EditText password;
    EditText conformpassword;
    Button submit;
    public static  String name=" ";
    public static  String pass=" ";
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        System.out.println("SignupActivity OnCreate");
        username=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        conformpassword=(EditText)findViewById(R.id.editText3);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("SignupActivity OnRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("SignupActivity OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("SignupActivity OnResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("SignupActivity OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("SignupActivity OnDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("SignupActivity OnPause");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                if(username.getText().toString().length()==0){
                    username.setError("please enter user name");
                    Toast.makeText(this,"Enter username",Toast.LENGTH_LONG).show();

                }
                else if (password.getText().toString().length()==0){
                    password.setError("please enter password");
                    Toast.makeText(this,"Enter Password",Toast.LENGTH_LONG).show();
                }
                else  if (conformpassword.getText().toString().length()==0){
                    conformpassword.setError("Enter conform password");
                    Toast.makeText(this,"Enter conform Password",Toast.LENGTH_LONG).show();
                }
                else if (password.getText().toString().equals(conformpassword.getText().toString())){
                    Toast.makeText(this,"password match",Toast.LENGTH_LONG).show();
                    name=username.getText().toString();
                    pass=password.getText().toString();
                    System.out.println("==================================="+name);
                    /*Intent it=new Intent(this,LoginActivity.class);
                    startActivity(it);*/
                    finish();
                }
                else{
                    Toast.makeText(this,"Please Enter Correctly",Toast.LENGTH_LONG).show();
                }
                /*username.setText(" ");
                password.setText(" ");
                conformpassword.setText(" ");*/

                break;


        }


    }
}
