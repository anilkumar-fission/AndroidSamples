package com.fission.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * @author anilkumar on 8/6/16.
 */
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //registerReceiver(new ScreenOnReceiver(),new IntentFilter(Intent.ACTION_LOCALE_CHANGED));
    }
}
