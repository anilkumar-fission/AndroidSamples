package com.fission.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DialogCreation();

    }
    public void DialogCreation(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
        builder.setMessage("Hello");
        builder.setTitle("Title Name");
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
