package com.fission.broadcast_customintent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author anilkumar on 8/6/16.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"IntentDected",Toast.LENGTH_LONG).show();
    }
}
