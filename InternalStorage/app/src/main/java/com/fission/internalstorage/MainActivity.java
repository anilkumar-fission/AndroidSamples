package com.fission.internalstorage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends Activity implements View.OnClickListener {
    private String filename="MySampleFile.txt";
    private String filepath="MyFileStorage";
    Button mInternalWriteData,mInternalReadData,mExternalWriteData,mExternalReadData;
    File myInternalFile;
    File myExternalFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContextWrapper contextWrapper=new ContextWrapper(getApplicationContext());
        File directory=contextWrapper.getDir(filepath,Context.MODE_PRIVATE);
        myInternalFile=new File(directory,filename);
        mInternalWriteData=(Button)findViewById(R.id.Internalwrite);
        mInternalWriteData.setOnClickListener(this);
        mInternalReadData=(Button)findViewById(R.id.Internalread);
        mInternalReadData.setOnClickListener(this);
        mExternalWriteData=(Button)findViewById(R.id.ExternalWrite);
        mExternalWriteData.setOnClickListener(this);
        mExternalReadData=(Button)findViewById(R.id.ExternalRead);
        mExternalReadData.setOnClickListener(this);
        if (!isExternalStorageAvailable()||isExternalStorageReadOnly()){
            mExternalWriteData.setEnabled(false);
        }

        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }
    }
    private static boolean isExternalStorageAvailable(){
        String externalStorageState= Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(externalStorageState)){
            return true;
        }
        return false;
    }
    private static boolean isExternalStorageReadOnly(){
        String externalStorageState=Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(externalStorageState)){
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {

    }
}
