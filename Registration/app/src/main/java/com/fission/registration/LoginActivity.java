package com.fission.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.String;

public class LoginActivity extends Activity{

    String password;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        System.out.println("LoginActivity OnCreate");
        setContentView(R.layout.activity_login);

        /*String username="anilkumar";
          String password="anil";*/
        /*if ((SignupActivity.name)!=null){*/
             username = SignupActivity.name;
           // System.out.println("============>>>>>>>>>>>"+username);

        /*}
        else if ((SignupActivity.pass)!=null){*/
            password=SignupActivity.pass;
        //}
         /*String username=SignupActivity.name;
         String password=SignupActivity.pass;*/
        Button loginBtn,registerBtn;
        final EditText editText,editText1;
        loginBtn=(Button) findViewById(R.id.button);
        registerBtn=(Button)findViewById(R.id.button2);
        editText=(EditText)findViewById(R.id.editText);
        editText1=(EditText)findViewById(R.id.editText2);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().length()==0){
                    System.out.println("please enter user name");
                    editText.setError("please enter user name");
                    //Toast.makeText(getApplicationContext(),"Please Enter User",Toast.LENGTH_LONG).show();
                }
               else if (editText1.getText().toString().length()==0){
                    System.out.println("please enter password");
                    editText1.setError("please enter password");
                  //  Toast.makeText(getApplicationContext(),"Please Enter Password",Toast.LENGTH_LONG).show();
                }
               else if (username.equals(editText.getText().toString())&&password.equals(editText1.getText().toString())){
                    System.out.println("You are in Home");

                    Toast.makeText(getApplicationContext(),"You are in Home Page",Toast.LENGTH_LONG).show();
                }
                else{
                    System.out.println("please enter correct username and password");
                    Toast.makeText(getApplicationContext(),"Please Enter Correct Username and Password",Toast.LENGTH_LONG).show();
                }
                    editText.setText("");
                    editText1.setText("");

            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
                System.out.println("Please register");
                Toast.makeText(getApplicationContext(),"Please register here",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("LoginActivity OnRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("LoginActivity OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        username = SignupActivity.name;
        password=SignupActivity.pass;
        System.out.println("LoginActivity OnResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("LoginActivity OnDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("LoginActivity OnPause");
    }

}
