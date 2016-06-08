package com.fission.broadcastreceiver_dynamically;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * @author anilkumar on 8/6/16.
 */
public class BroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Received","Received the BroadcastReceiver");
        Toast.makeText(context,"Message Received",Toast.LENGTH_LONG).show();

    }
}
