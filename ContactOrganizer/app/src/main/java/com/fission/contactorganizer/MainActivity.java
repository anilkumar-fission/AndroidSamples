package com.fission.contactorganizer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity  {
    EditText contactname_edt,phonenumber_edt,email_edt,address_edt;
    Button Addcontact_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactname_edt=(EditText)findViewById(R.id.contactname);
        phonenumber_edt=(EditText)findViewById(R.id.phonenumber);
        email_edt=(EditText)findViewById(R.id.Email);
        address_edt=(EditText)findViewById(R.id.Address);
        Addcontact_btn=(Button)findViewById(R.id.AddContact);
        Addcontact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hiii", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
