package com.fission.broadcastreceiver_dynamically;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MyBroadCastReceiver extends Activity {
    IntentFilter intentFilter;
    BroadCast broadCast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        intentFilter=new IntentFilter("android.intent.action.LOCALE_CHANGED");
        broadCast=new BroadCast();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.LOCALE_CHANGED");
        sendBroadcast(intent);
        registerReceiver(broadCast,intentFilter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadCast);
    }
}
